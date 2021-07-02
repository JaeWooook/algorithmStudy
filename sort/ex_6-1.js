//prototype swap
Array.prototype.swap = function(x, y) {
    let temp = x;
    arr[x] = arr[y];
    arr[y] = temp;
    return arr;
}

//select sort

arr = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8];

for (let i = 0; i < arr.length; i++) {
    let min_index = i;
    for (let j = i + 1; j < arr.length; j++) {
        if (arr[min_index] > arr[j]) {
            min_index = j;
        }
    }
    [arr[i], arr[min_index]] = [arr[min_index], arr[i]]; //swap
    // arr.swap(i, min_index);
}

console.log("select sort", arr);

//insert sort
arr1 = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8];

for (let i = 1; i < arr1.length; i++) {
    for (let j = i; j > 0; j--) {
        if (arr1[j] < arr1[j - 1]) {
            [arr1[j], arr1[j - 1]] = [arr1[j - 1], arr1[j]];
        } else {
            break;
        }
    }
}

console.log("insert sort", arr1);

//quick sort
arr2 = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8];

function quickSort(arr2) {
    if (arr2.length < 2) {
        return arr2;
    }

    const pivot = [arr2[0]];
    const left = [];
    const right = [];

    for (let i = 1; i < arr2.length; i++) {
        if (arr2[i] < pivot) {
            left.push(arr2[i]);
        } else if (arr2[i] > pivot) {
            right.push(arr2[i]);
        } else {
            pivot.push(arr2[i]);
        }
    }
    console.log(`left: ${left}, pivot: ${pivot}, right: ${right}`);
    return quickSort(left).concat(pivot, quickSort(right));
}
const result = quickSort(arr2);
console.log("quick sort", result);

//count sort
arr3 = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2];

let count = Array(Math.max.apply(null, arr3) + 1).fill(0);
for (let i = 0; i < arr3.length; i++) {
    count[arr3[i]] += 1;
}

console.log("count sort");
for (let i = 0; i < count.length; i++) {
    for (let j = 0; j < count[i]; j++) {
        process.stdout.write(`${i} `); // no "\n"  === no new line
    }
}
// console.log("count sort", arr3);