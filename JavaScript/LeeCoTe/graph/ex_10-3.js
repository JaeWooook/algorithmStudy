//other sol
const v = 7,
    e = 12;
const parent = [0, 1, 2, 3, 4, 5, 6, 7];
const edges = [
    [1, 2, 3],
    [1, 3, 2],
    [3, 2, 1],
    [2, 5, 2],
    [3, 4, 4],
    [7, 3, 6],
    [5, 1, 5],
    [1, 6, 2],
    [6, 4, 1],
    [6, 5, 3],
    [4, 5, 3],
    [6, 7, 4]
];
let result = 0;

function find_parent(parent, x) {
    if (parent[x] !== x) {
        parent[x] = find_parent(parent, parent[x]);
    }
    return parent[x];
}

function union_parent(parent, a, b) {
    a = find_parent(parent, a);
    b = find_parent(parent, b);
    if (a < b) {
        parent[b] = a;
    } else {
        parent[a] = b;
    }
}

// edges.sort((a, b) => a - b);
edges.sort(); //비용순으로 정렬된다.
console.log(edges);

let last = 0;
for (let edge of edges) {
    let cost = edge[0],
        a = edge[1],
        b = edge[2];
    // console.log("1,3,2?", cost, a, b);
    if (find_parent(parent, a) !== find_parent(parent, b)) {
        union_parent(parent, a, b);
        result += cost;
        last = cost;
    }
}
console.log("ex_10-3 answer : ", result - last);