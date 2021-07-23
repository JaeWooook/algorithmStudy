//못생긴 수
//my sol
const N = 1000;
const dp = Array(N + 1).fill(0);
dp[0] = 1;
let two = 2,
    three = 3,
    five = 5;
let cnt_2 = 1;
let cnt_3 = 1;
let cnt_5 = 1;
const go_two = 2,
    go_three = 3,
    go_five = 5;
for (let i = 1; i < dp.length; i++) {
    console.log(two, three, five);
    dp[i] = Math.min(two, three, five);
    if (dp[i] === five) {
        five = go_five * dp[cnt_5];
        cnt_5++;
    }
    if (dp[i] === three) {
        three = go_three * dp[cnt_3];
        cnt_3++;
    }
    if (dp[i] === two) {
        two = go_two * dp[cnt_2];
        cnt_2++;
    }
}
// console.log(dp);
console.log("Q35 answer", dp[N - 1]);

//other sol
const ugly = Array(N);
let i2 = 0,
    i3 = 0,
    i5 = 0;
let next2 = 2,
    next3 = 3,
    next5 = 5;
ugly[0] = 1
for (let i = 1; i < N; i++) {
    ugly[i] = Math.min(next2, next3, next5);
    if (ugly[i] === next2) {
        i2 += 1;
        next2 = ugly[i2] * 2;
    }
    if (ugly[i] === next3) {
        i3 += 1;
        next3 = ugly[i3] * 3;
    }
    if (ugly[i] === next5) {
        i5 += 1;
        next5 = ugly[i5] * 5;
    }
}
// console.log(ugly);
console.log("other sol", ugly[N - 1]);