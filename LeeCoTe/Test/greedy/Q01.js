//모험가 길드
//my sol
const N = 5;
const arr = [1, 2, 2, 2, 3];
const result = [];
let line = [];
let max = -1;
for (let i = 0; i < arr.length; i++) {
    if (arr[i] > max) {
        max = arr[i];
    }
    line.push(arr[i]);
    if (line.length === max) {
        result.push(line);
        line = [];
        max = -1;
    }
}

console.log("Q01 answer:", result.length);

//other sol
let count = 0,
    answer = 0;
arr.sort((a, b) => a - b);
for (let i = 0; i < arr.length; i++) {
    count += 1;
    if (count >= i) {
        answer += 1;
        count = 0;
    }
}

console.log("Q01 other answer : ", answer);