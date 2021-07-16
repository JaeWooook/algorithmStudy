//뱀
//my sol
const N = 6,
    K = 3;
const apple = [
    [3, 4],
    [2, 5],
    [5, 3]
];
const L = 3;
const dist = [
    [3, 'D'],
    [15, 'L'],
    [17, 'D']
];

let result = 0;

const board = Array.from(Array(N), () => Array(N).fill(0));
let vamLen = 1;
board[0][0] = 9;
for (let i = 0; i < apple.length; i++) { //board in apple
    board[apple[i][0]][apple[i][1]] = 1;
}
console.log(board);





console.log("Q11 answer :", result);