//럭키 스트레이트
//my sol

let N = 123402,
    N2 = 7755;

let str = String(N);
const arr = [];
for (let i = 0; i < str.length; i++) {
    arr.push(str[i]);
}
const leftArr = arr.slice(0, parseInt(arr.length / 2));
// console.log(leftArr);
const rightArr = arr.slice(parseInt(arr.length / 2), arr.length);
// console.log(rightArr);
let leftSum = 0,
    rightSum = 0;
for (let i = 0; i < leftArr.length; i++) {
    leftSum += parseInt(leftArr[i]);
    rightSum += parseInt(rightArr[i]);
}
console.log("Q07 answer");
if (leftSum === rightSum) {
    console.log("LUCKY");
} else {
    console.log("READY");
}