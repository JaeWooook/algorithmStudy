//my sol
const N = 4,
    M = 7;
const X = 3,
    K = 4;

const INF = Infinity;

const graph1 = [
    [INF, INF, INF, INF, INF, INF],
    [INF, 0, 1, 1, 1, INF],
    [INF, 1, 0, INF, 1, INF],
    [INF, 1, INF, 0, 1, 1],
    [INF, 1, 1, 1, 0, 1],
    [INF, INF, INF, 1, 1, 0]
];

const graph2 = [
    [INF, INF, INF, INF, INF],
    [INF, 0, INF, 1, INF],
    [INF, INF, 0, INF, 1],
    [INF, 1, INF, 0, INF],
    [INF, INF, 1, INF, 0]
]

for (let i = 1; i < N + 1; i++) {
    for (let a = 1; a < N + 1; a++) {
        for (let b = 1; b < N + 1; b++) {
            graph2[a][b] = Math.min(graph2[a][b], graph2[a][i] + graph2[i][b]);
        }
    }
}
console.log(graph1);

if (graph2[1][K] + graph2[K][X] < INF) {
    console.log("ex_9-2 answer : ", graph2[1][K] + graph2[K][X])
} else {
    console.log("ex_9-2 answer : -1")
}