//만들 수 없는 금액
//my sol
const getCombinations = function(arr, selectNumber) {
    const results = [];
    if (selectNumber === 1) return arr.map((value) => [value]); // 1개씩 택할 때, 바로 모든 배열의 원소 return

    arr.forEach((fixed, index, origin) => {
        const rest = origin.slice(index + 1); // 해당하는 fixed를 제외한 나머지 뒤
        const combinations = getCombinations(rest, selectNumber - 1); // 나머지에 대해서 조합을 구한다.
        const attached = combinations.map((combination) => [fixed, ...combination]); //  돌아온 조합에 떼 놓은(fixed) 값 붙이기
        results.push(...attached); // 배열 spread syntax 로 모두다 push
    });

    return results; // 결과 담긴 results return
}

const N = 5,
    arr = [3, 2, 1, 1, 9],
    arr1 = [3, 5, 7];
const max_value = arr1.reduce((a, b) => a + b);
arr1.sort((a, b) => a - b);
// console.log(max_value);
const temp = [];
for (let i = 0; i < max_value; i++) {
    temp.push(i + 1);
}
// console.log(temp);

function cal(arr) {
    const line = [];
    for (let i = 0; i < arr.length; i++) {
        line.push(arr[i].reduce((a, b) => a + b));
    }
    return line;
}
const result = new Set();
for (let i = 1; i <= N; i++) {
    const line = getCombinations(arr1, i);
    const comp = cal(line);
    for (let i = 0; i < comp.length; i++) {
        result.add(comp[i]);
    }
}

for (let i = 0; i < temp.length; i++) {
    if (!result.has(temp[i])) {
        console.log("Q04 answer", temp[i]);
        break;
    }
}

//other sol
arr.sort((a, b) => a - b);
let target = 1;
for (let x of arr) {
    if (target < x) {
        break;
    }
    target += x;
    console.log(target, x);
}
console.log("other sol", target);