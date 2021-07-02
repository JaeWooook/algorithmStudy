//binary_search
function binary_search(array, target, start, end) {
    while (start <= end) {
        let mid = parseInt((start + end) / 2);

        if (array[mid] === target) {
            return mid;
        } else if (array[mid] > target) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return NaN;
    }
}

let array = [1, 2, 3, 4, 5, 6, 7, 8, 9];

let result = binary_search(array, 5, 0, array.length - 1);

if (result === NaN) {
    console.log("no stay here!");
} else {
    console.log("find : ", result + 1);
}