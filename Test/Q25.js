//실패율
//mysol

function solution(N, stages) {
    const line = Array(N + 2).fill(0);
    for (let i = 0; i < stages.length; i++) {
        line[stages[i]]++;
    }
    // console.log(line);
    var answer = [];
    const fail = [];
    let total = stages.length;
    for (let i = 1; i < line.length; i++) {
        if (line[i] !== 0) {
            fail.push([i, line[i] / total]);
            total -= line[i];
        } else {
            fail.push([i, 0]);
        }
    }
    fail.sort((a, b) => {
        if (a[1] == b[1]) {
            if (a[0] > b[0]) {
                return 1;
            } else if (a[0] < b[0]) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return b[1] - a[1]
        }
    })
    console.log(fail);
    for (let i = 0; i < fail.length; i++) {
        if (fail[i][0] <= N) {
            answer.push(fail[i][0]);
        }
    }
    return answer;
}
//other sol