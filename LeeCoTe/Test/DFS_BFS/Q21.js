//인구 이동
//my sol 전염되서 지속적으로 붙어있는 인접한 나라들도 체크해야된다.
const N1 = 4,
    L1 = 10,
    R1 = 50;

const arr1 = [
    [10, 100, 20, 90],
    [80, 100, 60, 70],
    [70, 20, 30, 40],
    [50, 20, 100, 10]
];

// console.log(union);

function union_check(currX, currY, L, R, arr, index, union) {
    const dx = [0, 1, 0, -1];
    const dy = [1, 0, -1, 0];
    let q = [];
    let union_cnt = 1;
    q.push([currX, currY]);
    let where = [];
    where.push([currX, currY]);
    union[currX][currY] = index;
    let total = arr[currX][currY];
    while (q.length !== 0) {
        let temp = q.shift();
        currX = temp[0];
        currY = temp[1];
        for (let i = 0; i < 4; i++) {
            const nx = currX + dx[i];
            const ny = currY + dy[i];

            if (nx >= 0 && nx < N1 && ny >= 0 && ny < N1 && union[nx][ny] === -1) {

                let result = Math.abs(arr[currX][currY] - arr[nx][ny]);
                if (L <= result && result <= R) {
                    union[nx][ny] = index;
                    q.push([nx, ny]);
                    where.push([nx, ny]);
                    total += arr[nx][ny];
                    union_cnt++;
                }
            }
        }
    }
    const people = parseInt(total / union_cnt);
    for (let i = 0; i < where.length; i++) {
        let temp = where[i];
        arr[temp[0]][temp[1]] = people;
    }
}
let index = 0;
let result = 0;
while (true) {
    const union = Array.from(Array(N1), () => Array(N1).fill(-1));
    index = 0;
    for (let i = 0; i < N1; i++) {
        for (let j = 0; j < N1; j++) {
            if (union[i][j] === -1) {
                union_check(i, j, L1, R1, arr1, index, union);
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
console.log(arr1);
console.log("Q21 answer:", result);

//other sol
const N = 4,
    L = 10,
    R = 50;
const graph = [
    [10, 100, 20, 90],
    [80, 100, 60, 70],
    [70, 20, 30, 40],
    [50, 20, 100, 10]
];

function process(x, y, index, unionCheck) {
    let dx = [-1, 0, 1, 0];
    let dy = [0, -1, 0, 1];

    let united = [];
    united.push([x, y]);
    unionCheck[x][y] = index;
    let summary = graph[x][y];
    let count = 1;
    const que = [];
    que.push([x, y]);
    while (que.length !== 0) {
        let temp = que.shift();
        let currX = temp[0];
        let currY = temp[1];
        for (let i = 0; i < 4; i++) {
            let nx = currX + dx[i];
            let ny = currY + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < N && unionCheck[nx][ny] === -1) {
                let value = Math.abs(graph[nx][ny] - graph[currX][currY]);
                if (L <= value && value <= R) {
                    que.push([nx, ny]);
                    unionCheck[nx][ny] = index;
                    summary += graph[nx][ny];
                    count += 1;
                    united.push([nx, ny]);
                }
            }
        }
    }

    for (let i = 0; i < united.length; i++) {
        graph[united[i][0]][united[i][1]] = parseInt(summary / count);
        // console.log(graph);
    }
}

let total_count = 0;

while (true) {
    let unionCheck = Array.from(Array(N), () => Array(N).fill(-1));
    let index = 0;
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < N; j++) {
            if (unionCheck[i][j] === -1) {
                process(i, j, index, unionCheck);
                index += 1;
            }
        }
    }
    if (index === N * N) {
        break;
    }
    total_count += 1;
}
console.log(graph);
console.log("Q21 other sol", total_count);