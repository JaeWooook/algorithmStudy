//경쟁적 전염
//my sol
const N = 3,
    K = 3;
const arr1 = [
    [0, 0, 0, 0],
    [0, 1, 0, 2],
    [0, 0, 0, 0],
    [0, 3, 0, 0]
];
const S1 = [2, 3, 2];
const S2 = [1, 2, 2];

// const distance = Array(Array(), Array(), Array(), Array()); 빈 2차원 배열 생성 방법
const distance = Array.from(Array(N + 1), () => Array()); //빈 2차원 배열 생성 방법
// const distance = Array(N + 1).fill(null).map(() => Array()); 빈 2차원 배열 생성 방법
// console.log(distance);

function check_4dist(arr, num) {
    const dx = [0, -1, 0, 1];
    const dy = [1, 0, -1, 0];
    let cnt = distance[num].length;
    while (cnt !== 0) {
        let curr = distance[num].shift();
        cnt--;
        // console.log("curr?", curr, distance[num].length);
        let x = curr[0];
        let y = curr[1];
        for (let i = 0; i < dx.length; i++) {
            let nx = x + dx[i];
            let ny = y + dy[i];

            if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && arr[nx][ny] === 0) {
                arr[nx][ny] = num;
                // temp.push(nx, ny); //정확히 나누어서 넣어주어야한다
                distance[num].push([nx, ny]);

            }
        }
    }
    // console.log("this", distance);
}

function gyun(arr) {
    const line = [];
    for (let i = 1; i <= N; i++) {
        for (let j = 1; j <= N; j++) {
            if (arr[i][j] !== 0) {
                line.push(arr[i][j]);
                distance[arr[i][j]].push([i, j]);
                // console.log(distance);
            }
        }
    }
    return line;
}

const list = gyun(arr1);
list.sort((a, b) => a - b);
for (let i = 1; i <= S2[0]; i++) {
    for (let j = 0; j < list.length; j++) {
        check_4dist(arr1, list[j]);
    }
}
console.log(arr1);
let flag = arr1[S2[1]][S2[2]];
if (flag !== 0) {
    console.log("Q17 answer:", flag);
} else {
    console.log("Q17 answer:", flag);
}

//other sol 확인할것
const arr2 = [
    [0, 0, 0, 0],
    [0, 1, 0, 2],
    [0, 0, 0, 0],
    [0, 3, 0, 0]
];
const data = [];

for (let i = 1; i < N + 1; i++) {
    for (let j = 1; j < N + 1; j++) {
        if (arr2[i][j] !== 0) {
            data.push([arr2[i][j], 0, i, j]);
        }
    }
}
data.sort((a, b) => a - b);
// const q = Array.from(Array(N + 1), () => Array());
const q = [];
for (let i = 0; i < data.length; i++) {
    q.push(data[i]);
}
console.log(q);
const dx = [0, -1, 0, 1];
const dy = [1, 0, -1, 0];

while (q.length !== 0) {
    let dap = q.shift();
    let virus = dap[0],
        s = dap[1],
        x = dap[2],
        y = dap[3];
    if (s === S1[0]) {
        break;
    }
    for (let i = 0; i < 4; i++) {
        let nx = x + dx[i];
        let ny = y + dy[i];

        if (1 <= nx && nx <= N && 1 <= ny && ny <= N) {
            if (arr2[nx][ny] === 0) {
                arr2[nx][ny] = virus;
                q.push([virus, s + 1, nx, ny]);
            }
        }
    }
}

console.log("Q17 other sol", arr2[S1[1]][S1[2]]);