//여행 계획
//my sol
const n = 5,
    m = 4;
const map = [
    [0, 1, 0, 1, 1],
    [1, 0, 1, 1, 0],
    [0, 1, 0, 0, 0],
    [1, 1, 0, 0, 0],
    [1, 0, 0, 0, 0]
];
const parent = [0, 1, 2, 3, 4, 5];
const path = [2, 3, 4, 3];

function graph_search(arr, x) {
    if (arr[x] !== x) {
        arr[x] = graph_search(arr, arr[x]);
    }
    return arr[x];
}

function graph_union(arr, a, b) {
    a = graph_search(arr, a);
    b = graph_search(arr, b);

    if (a < b) {
        arr[b] = a;
    } else {
        arr[a] = b;
    }
}

for (let i = 0; i < map.length; i++) {
    for (let j = 0; j < map.length; j++) {
        if (map[i][j] === 1) {
            graph_union(parent, i + 1, j + 1);
            // console.log("check", i + 1, j + 1, parent);
        }
    }
}
console.log(parent); //지금과 같이 전부 연결이된경우? parent와 path를 체크해서 기존의 시작패스보다 다 작다면 갈수있는 경로가 존재한다.
const check = path[0];
let cnt = 0;
for (let i = 0; i < path.length; i++) {
    if (check > graph_search(parent, path[i])) {
        cnt++;
    }
}
if (cnt === path.length) {
    console.log("Q41 answer YES");
} else {
    console.log("Q41 answer NO");
}

//other sol
const parent2 = [0, 1, 2, 3, 4, 5];
for (let i = 0; i < map.length; i++) {
    for (let j = 0; j < map.length; j++) {
        if (map[i][j] === 1) {
            graph_union(parent, i + 1, j + 1);
        }
    }
}

let result = true;

for (let i = 0; i < m - 1; i++) { //맨마지막것은 계산할 필요가없기 때문에 m-1으로 해주는것이다.
    if (graph_search(parent, path[i]) !== graph_search(parent, path[i + 1])) {
        result = false;
        break;
    }
}
console.log("other sol");
if (result) {
    console.log("YES");
} else {
    console.log("NO");
}