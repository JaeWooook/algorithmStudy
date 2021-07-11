//other sol
const N = 7,
    M = 8;
const parent = [0, 1, 2, 3, 4, 5, 6, 7];

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
oper = [
    [0, 1, 3],
    [1, 1, 7],
    [0, 7, 6],
    [1, 7, 1],
    [0, 3, 7],
    [0, 4, 2],
    [0, 1, 1],
    [1, 1, 1]
];

for (let i = 0; i < oper.length; i++) {

    if (oper[i][0] === 0) {
        union_parent(parent, oper[i][1], oper[i][2]);
    } else {
        if (find_parent(parent, oper[i][1]) === find_parent(parent, oper[i][2])) {
            console.log("YES");
        } else {
            console.log("NO");
        }
    }
}