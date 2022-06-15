//뱀
//my sol
const N = 10,
    K = 5;
const apple = [
    [1, 5],
    [1, 3],
    [1, 2],
    [1, 6],
    [1, 7]
];
const L = 4;
const dist = [
    [8, 'D'],
    [10, 'D'],
    [11, 'D'],
    [13, 'L']
];

let result = 1;

const board = Array.from(Array(N), () => Array(N).fill(0));
board[0][0] = 9;
for (let i = 0; i < apple.length; i++) { //board in apple
    board[apple[i][0]][apple[i][1]] = 1;
}

const dx = [1, 0, -1, 0];
const dy = [0, 1, 0, -1];
let position = 0;
const q = [
    [0, 0]
];

function check(position, result) {
    let temp = [];
    // console.log(result, dist[0][0]);
    if (dist.length !== 0) {
        if (result === dist[0][0]) {
            temp = dist.shift();
            console.log(temp);
        }
    }
    if (temp[1] === 'D') {
        position++;
        if (position === 4) {
            position = 0;
        }
    }

    if (temp[1] === 'L') {
        position--;
        if (position === -1) {
            position = 3;
        }
    }

    return position;
}
while (true) { //충돌하면 길이를 -1로해준다.

    let curX = q[q.length - 1][1];
    let curY = q[q.length - 1][0];

    let nx = curX + dx[position];
    let ny = curY + dy[position];

    console.log("where is it?", ny, nx, "count", result);
    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
        if (board[ny][nx] === 0) {
            q.push([ny, nx]);
            board[ny][nx] = 9;
            let tail = q.shift();
            board[tail[0]][tail[1]] = 0;

        } else if (board[ny][nx] === 1) {
            q.push([ny, nx]);
            board[ny][nx] = 0;
            console.log(ny, nx, "eating");
        } else {
            // result++;
            break;
        }
    } else {
        // result++;
        break;
    }
    position = check(position, result);
    result++;
    // console.log("count", result);

}
console.log(board);


console.log("Q11 answer :", result);

//other sol
const d_x = [0, 1, 0, -1];
const d_y = [1, 0, -1, 0];
const arr = Array.from(Array(101), () => Array(101).fill(0));
const info = [
    [8, 'D'],
    [10, 'D'],
    [11, 'D'],
    [13, 'L']
];

function turn(direction, c) {
    if (c === 'L') {
        direction = (direction - 1) % 4;
    } else {
        direction = (direction + 1) % 4;
    }
    return direction;
}

function simulate() {
    let x = 1,
        y = 1;
    arr[x][y] = 2;
    let direction = 0;
    let time = 0;
    let index = 0;
    let queue = [];
    queue.push([x, y]);

    while (true) {
        let nX = x + d_x[direction];
        let nY = y + d_y[direction];

        if (1 <= nX && nX <= N && 1 <= nY && nY <= N && arr[nX][nY] !== 2) {
            if (arr[nX][nY] === 0) {
                arr[nX][nY] = 2;
                queue.push([nX, nY]);
                let px = queue[0][0];
                let py = queue[0][1];
                queue.shift();
                arr[px][py] = 0;
            }
            if (arr[nX][nY] === 1) {
                arr[nX][nY] = 2;
                queue.push([nX, nY]);
            }
        } else {
            time += 1;
            break;
        }
        x = nX;
        y = nY;
        time += 1;
        if (index < 1 && time === info[index][0]) {
            direction = turn(direction, info[index][1]);
            index += 1;
        }
    }
    return time;
}

let answer = simulate();
console.log("other sol", answer);