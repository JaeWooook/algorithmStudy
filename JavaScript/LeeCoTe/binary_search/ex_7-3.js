const N = 4,
    M = 6;
let A = [19, 15, 10, 17];
//my sol
A.sort((a, b) => a - b);

for (let i = 0; i < A.length; i++) {
    let line = [];
    for (let j = 0; j < A.length; j++) {
        if (A[i] < A[j]) {
            line.push(A[j] - A[i])
        }
    }
    let result = line.reduce((a, b) => a + b);
    if (result === M) {
        console.log("ex_7-3 answer : ", A[i]);
        break;
    }
}
//other sol
let start = 0,
    end = A[A.length - 1];
let result = 0;
while (start <= end) {
    let total = 0;
    let mid = parseInt((start + end) / 2);
    for (let i = 0; i < A.length; i++) {
        if (A[i] > mid) {
            total += A[i] - mid;
        }
    }
    if (total < M) {
        end = mid - 1;
    } else {
        result = mid;
        start = mid + 1;
    }
}

console.log("other sol", result);