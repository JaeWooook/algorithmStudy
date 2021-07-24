//위상 정렬
const v = 7,
    e = 8;
const indegree = [0, 0, 1, 1, 2, 1, 2, 1];
// console.log(indegree);
const graph = [
    [],
    [2, 5],
    [3, 6],
    [4],
    [7],
    [6],
    [4],
    []
];
// console.log(graph);

function topology_sort() {
    let result = [];
    let q = [];

    for (let i = 1; i < v + 1; i++) {
        if (indegree[i] === 0) {
            q.push(i);
        }
    }
    while (q.length !== 0) {
        let now = q.shift();
        result.push(now);
        for (let i of graph[now]) {
            // console.log(i);
            indegree[i] -= 1;
            if (indegree[i] === 0) {
                q.push(i);
            }
        }
    }
    console.log(result);
}

topology_sort();