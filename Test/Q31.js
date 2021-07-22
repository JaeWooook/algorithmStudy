//금광
//my sol
const T = 2,
    N1 = 3,
    M1 = 4,
    N2 = 4,
    M2 = 4;
const arr1 = [
    [1, 3, 3, 2],
    [2, 1, 4, 1],
    [0, 6, 4, 7]
];
const arr2 = [

    [1, 3, 1, 5],
    [2, 2, 4, 1],
    [5, 0, 2, 3],
    [0, 6, 1, 2]
];
let result = 0;
const d = Array.from(Array(20), () => Array());
for (let i = 0; i < N1; i++) {
    for (let j = 0; j < M1; j++) {
        d[i][j] = arr1[i][j];
    }
}
// console.log(d);
for (let i = 1; i < N1; i++) {
    for (let j = 0; j < M1; j++) {
        let left, leftDown, leftUp;
        if (j === 0) {
            leftUp = 0;
            left = 0;
            leftDown = 0;
        } else {
            leftUp = d[i - 1][j - 1];
            left = d[i][j - 1];
            if (i !== N1 - 1) {
                leftDown = d[i + 1][j - 1];
            } else {
                leftDown = 0;
            }
        }
        d[i][j] = Math.max(leftUp, Math.max(left, leftDown));
    }
}
for (let i = 0; i < N1; i++) {
    result = Math.max(result, d[i][M2 - 1]);
}
console.log("Q31 answer", result);

//other sol 다시 확인하고 풀것 어렵다..
const arr = [
    [1, 3, 1, 5],
    [2, 2, 4, 1],
    [5, 0, 2, 3],
    [0, 6, 1, 2]
];
const dp = Array.from(Array(20), () => Array());

for (let i = 0; i < N2; i++) {
    for (let j = 0; j < M2; j++) {
        dp[i][j] = arr[i][j];
    }
}
// console.log("check", dp);

//다이나믹 프로그래밍 진행
for (let j = 1; j < M2; j++) {
    for (let i = 0; i < N2; i++) {
        let leftUp, leftDown, left;

        if (i === 0) { //왼쪽 위에서 오는 경우
            leftUp = 0;
        } else {
            leftUp = dp[i - 1][j - 1];
            // console.log("왼쪽 위", leftUp);
        }

        if (i === (N2 - 1)) { //왼쪽 아래에서 오는 경우
            leftDown = 0;
        } else {
            leftDown = dp[i + 1][j - 1];
            // console.log("왼쪽 아래", leftDown);
        }
        left = dp[i][j - 1]; //왼쪽에서 오는 경우?
        // console.log("왼쪽", left);
        dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));
    }
}
let answer = 0;
for (let i = 0; i < N2; i++) {
    answer = Math.max(answer, dp[i][M2 - 1]);
}
// console.log(dp);
console.log("other sol", answer);