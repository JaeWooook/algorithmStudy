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
// console.log(zero_count.length, one_count.length);

if (zero_count.length < one_count.length) {
    result = zero_count.length;
} else {
    result = one_count.length;
}
console.log("Q03 answer : ", result);