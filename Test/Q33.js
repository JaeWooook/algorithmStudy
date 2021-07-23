//퇴사
const N = 10;
const cost = [
    [5, 50],
    [4, 40],
    [3, 30],
    [2, 20],
    [1, 10],
    [1, 10],
    [2, 20],
    [3, 30],
    [4, 40],
    [5, 50],
];
// let cnt = N;

const dp = Array.from(Array(N + 1).fill(0));
// console.log(dp);
const stack = [];
for (let i = 0; i < N; i++) {
    let pre_value = 0,
        value = 0;
    let ix = 0;
    if (cost[i][0] === 1) {
        value = cost[i][1];
    } else {
        value = 0;
    }
    const line = [];
    if (i !== 0) {
        for (let j = 0; j < i; j++) {
            //   const line = [];
            // console.log("저장하는 값 첫번째 <= 두번째 이면 저장", cost[j][0], i + 1);
            if (cost[j][0] <= i + 1) {
                //과거의날에 시간보다 현재의 시간이 작을때
                line.push([cost[j][1], j]);
                // console.log("save there", j, cost[j][1], line);
            } else {
                pre_value = 0;
            }
        }
        if (line.length !== 0) {
            line.sort((a, b) => a[0] - b[0]);
            //   console.log("big test", line);
            pre_value = line[line.length - 1][0];
            ix = line[line.length - 1][1];
            // stack.push(ix);

        }
    }
    let index = i + 1;
    // console.log("what value pre_value, i, ix", value, pre_value, i, ix);

    if (value <= pre_value && i > ix) {
        // console.log("what ix", ix, index);
        stack.push(ix);
        // console.log("????", stack);
        if (pre_value !== 0) {
            let nlen = ix + cost[ix][0];
            if (nlen > cost.length) {
                nlen = cost.length;
            }
            for (let i = ix; i < nlen; i++) {
                cost[i][1] = 0;
            }
        }
        dp[index] = dp[index - 1] + pre_value;
        if (stack.length !== 0) {
            if (stack.shift() > ix) {
                dp[index] = pre_value;
                // console.log("stack check", dp[index], ix, stack);
            }
        }

    } else {
        if (value !== 0) {
            cost[i][1] = 0;
        }
        dp[index] = dp[index - 1] + value;
    }
    // console.log("지워진 값", cost);
    // console.log(dp);
    //이전값을 저장할지 판단
    //이전값과 현재값 비교해서 더 큰값을 더해준다
    //더한 값을 0으로 만들어서 다시 더하는 일 없도록 한다
}
console.log(dp);
console.log("Q33 answer", dp[N]);

//other sol
d = Array.from(Array(N + 1), () => Array());
console.log(d);
for (let i = 0; i < N; i++) {

}