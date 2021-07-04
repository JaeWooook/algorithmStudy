const N = 5,
    M = 3;
let arr1 = [8, 3, 7, 9, 2],
    arr2 = [5, 7, 9];

//my sol
arr1.sort((a, b) => a - b);

function binary_search(arr, start, end, target) {

    while (start <= end) {
        let mid = parseInt((end + start) / 2);
        if (arr[mid] === target) {
            return true;
        } else if (arr[mid] < target) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return false;
}

for (let i = 0; i < M; i++) {
    if (binary_search(arr1, 0, arr1.length - 1, arr2[i])) {
        console.log("yes");
    } else {
        console.log("no");
    }
}
console.log("======other sol======");
//other sol
let result = [];
for (let i = 0; i < N; i++) {
    result[arr1[i]] = 1;
}

for (let j = 0; j < M; j++) {
    if (result[arr2[j]] === 1) {
        console.log("yes");
    } else {
        console.log("no");
    }
}
console.log("======other sol======");
//other sol
for (let i = 0; i < M; i++) {
    if (arr1.indexOf(arr2[i]) === -1) {
        console.log("no");
    } else {
        console.log("yes");
    }

}