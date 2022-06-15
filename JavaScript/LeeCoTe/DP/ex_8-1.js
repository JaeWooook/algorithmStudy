//fibonaci Top-down
let d = Array(100).fill(0);

function fibo(x) {
    console.log("실행", x);
    if (x === 1 || x === 2) {
        return 1;
    }

    if (d[x] !== 0) {
        console.log("이미 계산된 문제", d[x]);
        return d[x];
    }

    d[x] = fibo(x - 1) + fibo(x - 2);
    console.log("아직 계산 하지 않은 문제", d[x], x);
    return d[x];
}

console.log("top-down sol", fibo(10));
//fibonaci Bottom-up
let d_2 = Array(100).fill(0);
d_2[1] = 1;
d_2[2] = 1;
let n = 10;

for (let i = 3; i < n + 1; i++) {
    d_2[i] = d_2[i - 1] + d_2[i - 2];
}
console.log("bottom-up sol", d[n]);