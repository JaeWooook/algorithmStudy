const N = 15,
    M = 14;
const arr1 = [
    [0, 0, 1, 1, 0],
    [0, 0, 0, 1, 1],
    [1, 1, 1, 1, 1],
    [0, 0, 0, 0, 0]
];
const arr2 = [
    [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0],
    [1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0],
    [1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0],
    [1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0],
    [1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
    [1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0],
    [1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1],
    [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1],
    [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0],
    [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1],
    [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1],
    [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1]
];
//my sol DFS
let visited = Array.from(Array(N), () => Array(M).fill(0));
// console.log(visited);

let result = 0;
const dx = [1, 0, -1, 0],
    dy = [0, 1, 0, -1];
let direction = 0;
let que = [],
    di_cnt = 0;

function turn_right() {
    direction += 1;
    if (direction === 4) {
        direction = 0;
    }
}

function check_ice() {
    let line = que.shift();
    let y = line[0];
    let x = line[1];
    while (true) {
        // console.log("std y and x",y,x,di_cnt,direction);
        di_cnt++;
        if (di_cnt === 4 && que.length !== 0) {
            line = que.shift();
            y = line[0];
            x = line[1];
            di_cnt = 0;
        }
        let nx = x + dx[direction];
        let ny = y + dy[direction];
        if (nx < M && nx >= 0 && ny < N && ny >= 0) {
            if (arr2[ny][nx] === 0 && visited[ny][nx] === 0) {
                visited[ny][nx] = 1;
                // console.log("find y x",ny,nx);
                que.push([ny, nx]);
                // console.log("inner que",que);
            }
        }
        turn_right();
        if (que.length === 0 && di_cnt === 4) {
            result++;
            break;
        }
    }
}

for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
        if (arr2[i][j] === 0 && visited[i][j] === 0) {
            visited[i][j] = 1;
            que.push([i, j]);
            direction = 0;
            di_cnt = 0;
            check_ice();
        }
    }
}
console.log("ex_5-1  answer :", result);

//other sol BFS
let answer = 0;
const N2 = 4,
    M2 = 5;

function dfs(x, y) {
    if (x <= -1 || x >= N2 || y <= -1 || y >= M2) {
        return false;
    }

    if (arr1[x][y] === 0) {
        arr1[x][y] = 1;
        dfs(x - 1, y);
        dfs(x, y - 1);
        dfs(x + 1, y);
        dfs(x, y + 1);
        return true;
    }
    return false;
}
for (let i = 0; i < N2; i++) {
    for (let j = 0; j < M2; j++) {
        if (dfs(i, j) === true) {
            answer += 1;
        }
    }
}
console.log("other sol", answer);