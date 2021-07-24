//my sol
const N = 2;
let arr1 = [
    ["홍길동", 95],
    ["이순신", 77]
];

const sorting = arr1.sort(function(a, b) {
    if (a[1] > b[1]) {
        return 1;
    }
    if (a[1] < b[1]) {
        return -1;
    }
    return 0;
});

sorting.forEach((arr) => process.stdout.write(`${arr[0]} `));