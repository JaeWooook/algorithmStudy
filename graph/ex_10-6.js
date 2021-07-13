//크루스칼알고리즘
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

const v = 7,
    e = 9;

const parent = [0, 1, 2, 3, 4, 5, 6, 7];

const edges = [
    [29, 1, 2],
    [75, 1, 5],
    [35, 2, 3],
    [34, 2, 6],
    [7, 3, 4],
    [23, 4, 6],
    [13, 4, 7],
    [53, 5, 6],
    [25, 6, 7]
]
let result = 0;
edges.sort((a, b) => a[0] - b[0]); //2차원배열의 첫번째칸으로 정렬하기 위함이다 cost를 중심으로 정렬을해야한다 크루스칼알고리즘은
// console.log(edges);

for (let edge of edges) {
    let cost = edge[0],
        a = edge[1],
        b = edge[2];

    if (find_parent(parent, a) !== find_parent(parent, b)) {
        union_parent(parent, a, b);
        result += cost;
    }
}
// console.log(parent);
// console.log(result);