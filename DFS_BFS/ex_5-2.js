const N = 5,
    M = 6;
let arr1 = [
    [1, 0, 1, 0, 1, 0],
    [1, 1, 1, 1, 1, 1],
    [0, 0, 0, 0, 0, 1],
    [1, 1, 1, 1, 1, 1],
    [1, 1, 1, 1, 1, 1]
];

let visited = Array.from(Array(N), () => Array(M).fill(0));
//my sol
let startX = 0,
    startY = 0;
visited[startY][startX] = 1;
let direction = 0;
const dx = [0, 1, 0, -1],
    dy = [1, 0, -1, 0];
let destX = M - 1;
destY = N - 1;
let result = 0;

function turn_right() {
    direction += 1;
    if (direction === 4) {
        direction = 0;
    }
}
let stack = [],
    top = 0;
stack.push([startY, startX]);
let count = 0;
let cnt = 0;
while (true) {
    cnt++;
    let x = dx[direction];
    let y = dy[direction];

    let nx = stack[top][1] + x;
    let ny = stack[top][0] + y;
    if (nx > -1 && nx < M && ny > -1 && ny < N) {
        if (visited[ny][nx] === 0 && arr1[ny][nx] === 1) {
            // console.log("find ny nx", ny, nx);
            visited[ny][nx] = 1;
            stack.push([ny, nx]);
            top++;
            count = 0;
            // console.log("stack", stack);
        } else {
            count++;
        }
    }
    if (count === 4) {
        stack.pop();
        top--;
    }
    turn_right();
    if (visited[destY][destX] === 1) {
        break;
    }
}
console.log("ex_5-2 answer : ", stack.length);

//other sol
let arr2 = [
    [1, 0, 1, 0, 1, 0],
    [1, 1, 1, 1, 1, 1],
    [0, 0, 0, 0, 0, 1],
    [1, 1, 1, 1, 1, 1],
    [1, 1, 1, 1, 1, 1]
];
let answer = 0;
const dx_2 = [-1, 1, 0, 0],
    dy_2 = [0, 0, -1, 1];
let que = [];

function bfs(x, y) {
    que.push([x, y]);

    while (que.length !== 0) {
        let line = que.shift();
        x = line[0];
        y = line[1];

        for (let i = 0; i < dx_2.length; i++) {
            let nx2 = x + dx_2[i];
            let ny2 = y + dy_2[i];

            if (nx2 < 0 || ny2 < 0 || nx2 >= N || ny2 >= M) {
                continue;
            }
            if (arr2[nx2][ny2] === 0) {
                continue;
            }
            if (arr2[nx2][ny2] === 1) {
                arr2[nx2][ny2] = arr2[x][y] + 1;
                que.push([nx2, ny2]);
            }
        }
    }
    return arr2[N - 1][M - 1];
}

console.log("other sol", bfs(0, 0));