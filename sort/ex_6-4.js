//my sol
const N = 5,
    K = 3;
let A = [1, 2, 5, 4, 3],
    B = [5, 5, 6, 6, 5];

A.sort((a, b) => a - b);
B.sort((a, b) => b - a);

for (let i = 0; i < K; i++) {
    if (A[i] < B[i]) {
        [A[i], B[i]] = [B[i], A[i]];
    }
}

console.log("ex_6-4 answer : ", A.reduce((a, b) => a + b));