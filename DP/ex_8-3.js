//my sol
let N = 4;
let arr1 = [1, 3, 1, 5];

let count = Math.ceil(N / 2);
let D = Array(count).fill(0);
let max = -1;
let result = 0;
let index = 0;


//other sol
let F = Array(100).fill(0);
F[0] = arr1[0];
F[1] = Math.max(arr1[0], arr1[1]);

for (let i = 2; i < N; i++) {
    F[i] = Math.max(F[i - 1], F[i - 2] + arr1[i]);
}
console.log("other sol", F[N - 1]);