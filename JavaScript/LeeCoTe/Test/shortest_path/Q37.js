//플로이드
//왜 자기자신으로 가는것은 0으로 처리를 해야하는지?
//i에서 j로 가는 최소비용이다 자기자신은 갈 필요가없다 비용이 0이다.
const n = 5,
    m = 14;

const busInfos = [
    [1, 2, 2],
    [1, 3, 3],
    [1, 4, 1],
    [1, 5, 10],
    [2, 4, 2],
    [3, 4, 1],
    [3, 5, 1],
    [4, 5, 3],
    [3, 5, 10],
    [3, 1, 8],
    [1, 4, 2],
    [5, 1, 7],
    [3, 4, 2],
    [5, 2, 4],
];
const graph = Array.from(Array(n), () => Array(n).fill(Infinity));
// console.log(graph);

function initArray() {
    for (let i = 0; i < busInfos.length; i++) {
        graph[busInfos[i][0] - 1][busInfos[i][1] - 1] = Math.min(
            graph[busInfos[i][0] - 1][busInfos[i][1] - 1],
            busInfos[i][2]
        );
    }
}
initArray();
// console.log(graph);

function search() {
    for (let i = 0; i < n; i++) {
        for (let a = 0; a < n; a++) {
            for (let b = 0; b < n; b++) {
                if (a === b) {
                    graph[a][b] = 0;
                } else {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }
    }

    for (let i = 0; i < graph.length; i++) {
        for (let j = 0; j < graph.length; j++) {
            if (graph[i][j] === Infinity) {
                graph[i][j] = 0;
            }
        }
    }
}
search();
console.log("Q37 answer");
console.log(graph);