//모험가 길드
//mysol
const N = 5;
const arr = [2, 3, 1, 2, 2];
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