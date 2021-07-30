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