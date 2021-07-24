//정렬된 배열에서 특정 수의 개수 구하기
//my sol
const N = 7,
    X = 2;
const arr1 = [1, 1, 2, 2, 2, 2, 3];
const X2 = 4;

//other sol
function lowerBound(arr, target, start, end) {
    while (start < end) {
        let mid = parseInt((start + end) / 2);
        if (arr[mid] >= target) {
            end = mid;
        } else {
            start = mid + 1;
        }
    }
    return end;
}

function upperBound(arr, target, start, end) {
    while (start < end) {
        let mid = parseInt((start + end) / 2);
        if (arr[mid] > target) {
            end = mid;
        } else {
            start = mid + 1;
        }
    }
    return end;
}

function countByRange(arr, leftValue, rightValue) {
    let rightIndex = upperBound(arr, rightValue, 0, arr.length);
    let leftIndex = lowerBound(arr, leftValue, 0, arr.length);
    return rightIndex - leftIndex;
}

let cnt = countByRange(arr1, X, X);
if (cnt === 0) {
    console.log("Q27 answer", -1);
} else {
    console.log("Q27 answer", cnt);
}