//공유기 설치
//my sol
const N = 5,
    C = 3,
    arr1 = [1, 2, 8, 4, 9];
arr1.sort((a, b) => a - b);

//other sol
let start = 1;
let end = arr1[arr1.length - 1] - arr1[0];
let result = 0;

while (start <= end) {
    let mid = parseInt((start + end) / 2);
    let value = arr1[0];
    let count = 1;
    // console.log("check", value, mid, start, end);
    for (let i = 1; i < N; i++) {
        if (arr1[i] >= value + mid) {
            value = arr1[i];
            count += 1;
            // console.log("check value mid", value, mid);
        }
    }
    if (count >= C) {
        start = mid + 1;
        result = mid;
    } else {
        end = mid - 1;
    }
}
console.log("Q29 answer", result);