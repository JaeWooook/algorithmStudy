//my sol
let N = 3;
const d = Array(1001).fill(0);

d[1] = 1;
d[2] = 3;
for (let i = 3; i < N + 1; i++) {
    d[i] = d[i - 1] + (d[i - 2] * 2);
}
console.log(d[N] % 796796);