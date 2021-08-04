//무지의 먹방 라이브
//my sol 효율성 테스트 탈락
function notZero(index, food_times) {
    while (true) {
        index++;
        if (index === food_times.length) {
            index = 0;
        }
        if (food_times[index] !== 0) {
            return index;
        }
    }
}

function solution(food_times, k) {
    let index = 0;
    let eated = 0;
    while (true) {
        if (food_times[index] > 0) {
            food_times[index]--;
            eated++;
            index++;
        } else {
            index++;
        }
        if (Math.max.apply(null, food_times) === 0) {
            return -1;
        }

        if (index === food_times.length) {
            index = 0;
        }
        if (eated === k) {
            if (food_times[index] === 0) {
                index = notZero(index, food_times);
                break;
            }
            break;
        }
    }
    return index + 1;
}

//other sol
function othersol(food_times, k) {
    let sortFoodTimes = [];
    const len = food_times.length;

    //1. {index, time} 구조의 배열로 생성
    //2. time 오름차순으로 정렬
    sortFoodTimes = food_times.map((time, index) => {
        return { index: index + 1, time };
    }).sort((a, b) => {
        return a.time - b.time;
    });
    console.log("sortFoodTimes", sortFoodTimes);
    //3. K를 넘어가는 순간을 찾아서 반환
    for (let i = 0; i < len; i++) {
        const food_time = sortFoodTimes[i].time; //index의 음식을 먹는데 필요한 시간
        const remains_foods_len = len - i; //남은 음식의 갯수
        const roop_time = (food_time - (i == 0 ? 0 : sortFoodTimes[i - 1].time)) * remains_foods_len; //현재 roop의 음식을 먹는데 걸리는 시간
        console.log("what", food_time, remains_foods_len, roop_time, k);
        if (k < roop_time) {
            console.log(sortFoodTimes.slice(i));
            return sortFoodTimes.slice(i).sort((a, b) => a.index - b.index)[k % remains_foods_len].index;
        }
        k -= roop_time; //먹은 음식들의 시간을 제외
    }
    return -1;
}

console.log("othersol", othersol([3, 1, 2], 5));