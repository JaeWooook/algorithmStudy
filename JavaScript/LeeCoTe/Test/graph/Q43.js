//어두운 길
//my sol
const n = 7,
    m = 11;
const home_path = [
    [0, 1, 7],
    [0, 3, 5],
    [1, 2, 8],
    [1, 3, 9],
    [1, 4, 7],
    [2, 4, 5],
    [3, 4, 15],
    [3, 5, 6],
    [4, 5, 8],
    [4, 6, 9],
    [5, 6, 11]
];
const parent = [0, 1, 2, 3, 4, 5, 6, 7];
let total = 0;
let result = 0;
for (let i = 0; i < home_path.length; i++) {
    total += home_path[i][2];
}
// console.log(total);

function find(parent, x) {
    if (parent[x] !== x) {
        parent[x] = find(parent, parent[x]);
    }
    return parent[x];
}

function union(parent, a, b) {
    a = find(parent, a);
    b = find(parent, b);
    if (a < b) {
        parent[b] = a;
    } else {
        parent[a] = b;
    }
}
home_path.sort((a, b) => a[2] - b[2]);
// console.log(home_path);
for (let i = 0; i < home_path.length; i++) {
    if (find(parent, home_path[i][0]) !== find(parent, home_path[i][1])) {
        result += home_path[i][2];
        union(parent, home_path[i][0], home_path[i][1]);
    }
}
console.log("Q43 answer", total - result);