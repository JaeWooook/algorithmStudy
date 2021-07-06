const N = 2,
    N2 = 3,
    M2 = 4
M = 15;
const arr = [2, 3];
const arr1 = [3, 5, 7];
const d = Array(M + 1).fill(10001);
d[0] = 0;
console.log(d);
//my sol



//other sol
for (let i = 0; i < N; i++) {
    for (let j = arr[i]; j < M + 1; j++) {
        if (d[j - arr[i]] !== 10001) {
            d[j] = Math.min(d[j], d[j - arr[i]] + 1);
        }
    }
}
console.log(d);
if (d[M] === 10001) {
    console.log("other sol", -1);
} else {
    console.log("other sol", d[M]);
}