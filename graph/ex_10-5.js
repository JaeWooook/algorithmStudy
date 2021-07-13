//cycle 판별
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

const parent = [0, 1, 2, 3];
let cycle = false;
const v = 3,
    e = 3;
const input = [
    [1, 2],
    [1, 3],
    [2, 3]
];
for (let i = 0; i < input.length; i++) { //같은 값이 있으면 cycle이 존재하는 것이다.
    if (find_parent(parent, input[i][0]) === find_parent(parent, input[i][1])) {
        cycle = true;
        break;
    } else {
        union_parent(parent, input[i][0], input[i][1]);
    }
}

if (cycle) {
    console.log("사이클이 발생했습니다.");
} else {
    console.log("사이클이 없습니다.");
}