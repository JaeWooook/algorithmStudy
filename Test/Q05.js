//볼링공 고르기
//mysol
const N = 5,
    N2 = 8,
    M2 = 5
M = 3;
const arr = [1, 3, 2, 3, 2];
const arr2 = [1, 5, 4, 3, 2, 4, 5, 2];

let result = 0;
for (let i = 0; i < arr.length; i++) {
    for (let j = i + 1; j < arr.length; j++) {
        if (arr[i] !== arr[j]) {
            result++;
        }
    }
}

console.log("Q05 answer : ", result);