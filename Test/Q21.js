//인구 이동
//my sol 
const N1 = 3,
    L1 = 5,
    R1 = 10;

const arr1 = [
    [0, 0, 0, 0],
    [0, 10, 15, 20],
    [0, 20, 30, 25],
    [0, 40, 22, 10]
];
let union = Array.from(Array(N1 + 1), () => Array(N1 + 1).fill(-1));
let count = 0;
// console.log(union);

function union_check(currX, currY, L, R, arr, index) {
    const dx = [0, 1, 0, -1];
    const dy = [1, 0, -1, 0];
    let q = [];
    let union_cnt = 1;
    q.push([currX, currY]);
    union[currX][currY] = index;
    let total = arr[currX][currY];
    let trans = false;
    for (let i = 0; i < 4; i++) {
        const nx = currX + dx[i];
        const ny = currY + dy[i];

        if (nx >= 1 && nx <= N1 && ny >= 1 && ny <= N1) {

            let result = Math.abs(arr[currX][currY] - arr[nx][ny]);
            if (L <= result && result <= R) {
                union[nx][ny] = index;
                q.push([nx, ny]);
                total += arr[nx][ny];
                union_cnt++;
            }
        }
    }
    const people = parseInt(total / union_cnt);
    if (q.length > 1) {
        trans = true;
        console.log(q);
    }
    while (q.length !== 0) {
        let temp = q.shift();
        let x = temp[0],
            y = temp[1];
        arr[x][y] = people;
    }
    return trans;
}
let index = 0;
let result = 0;
while (true) {
    index = 0;
    for (let i = 1; i <= N1; i++) {
        for (let j = 1; j <= N1; j++) {
            if (union[i][j] === -1) {
                union_check(i, j, L1, R1, arr1, index);
                index += 1;

            }
        }
    }
    if (index === (N1) * (N1)) {
        break;
    }
    result++;
    // console.log(result);
}


console.log("Q21 answer:", result);