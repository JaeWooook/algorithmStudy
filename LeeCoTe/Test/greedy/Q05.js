//볼링공 고르기
//my sol
const M2 = 5
M = 3;
let N = 5,
    N2 = 8;
const arr = [1, 3, 2, 3, 2];
const arr2 = [1, 5, 4, 3, 2, 4, 5, 2];

let result = 0;
for (let i = 0; i < arr2.length; i++) {
    for (let j = i + 1; j < arr2.length; j++) {
        if (arr2[i] !== arr2[j]) {
            result++;
        }
    }
}

console.log("Q05 answer : ", result);

//other sol
let answer = 0;
let binArray = Array(11).fill(0);

for (let i of arr2) {
    binArray[i] += 1;
}
for (let i = 1; i < M2 + 1; i++) {
    N2 -= binArray[i];
    answer += binArray[i] * N2;
}
console.log("Q05 other answer : ", answer);