//문자열 뒤집기
//my sol
const s = "0001100";
let result = 0;
let td = s.split("0");
let one_count = [];
let zero_count = [];
let one_cnt = 0,
    zero_cnt = 0;
for (let i = 0; i < td.length; i++) {
    if (td[i] === "") {
        one_cnt++;
        if (zero_cnt !== 0) {
            zero_count.push(zero_cnt)
        }
        zero_cnt = 0;

    } else {
        if (one_cnt !== 0) {
            one_count.push(one_cnt);
        }
        one_cnt = 0;
        zero_cnt++;
    }

    if (i === td.length - 1) {
        if (one_cnt !== 0) {
            one_count.push(one_cnt);
        } else if (zero_cnt !== 0) {
            zero_count.push(zero_cnt);
        }
    }
}
if (zero_count.length < one_count.length) {
    result = zero_count.length;
} else {
    result = one_count.length;
}
console.log("Q03 answer : ", result);

//other sol
let count0 = 0;
let count1 = 0;

if (s[0] === '1') {
    count0 += 1;
} else {
    count1 += 1;
}

for (let i = 0; i < s.length - 1; i++) {
    if (s[i] !== s[i + 1]) {
        if (s[i + 1] === '1') {
            count0 += 1;
        } else {
            count1 += 1;
        }
    }
}
console.log("Q03 other sol", Math.min(count0, count1));