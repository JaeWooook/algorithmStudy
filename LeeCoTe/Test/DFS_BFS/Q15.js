//특정 거리의 도시 찾기
//my sol
const N1 = 4,
    M1 = 4,
    K1 = 2,
    X1 = 1;
const arr1 = [
    [1, 2],
    [1, 3],
    [2, 3],
    [2, 4]
];

//other sol
const graph1 = [
    [],
    [2, 3],
    [3, 4],
    [],
    []
];
const distance = Array(N1 + 1).fill(-1);
distance[X1] = 0;
const q = [];
q.push(X1);

while (q.length !== 0) {
    let now = q.shift();
    for (let next_node of graph1[now]) { //현재 노드에서 이동할 수 있는 모든 노드 확인
        if (distance[next_node] === -1) { //방문하지 않았다면 현재 노드에서 갈 수 있는 최단거리로 갱신
            distance[next_node] = distance[now] + 1;
            q.push(next_node);
        }
    }
}
let check = false;
for (let i = 1; i < N1 + 1; i++) {
    if (distance[i] === K1) {
        console.log("Q15 other sol", i);
        check = true;
    }
}
if (check === false) {
    console.log("Q15 ohter sol -1");
}