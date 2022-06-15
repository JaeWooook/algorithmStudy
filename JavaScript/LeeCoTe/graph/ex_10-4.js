//커리큘럼 other sol
const v = 5;

const graph = [
    [],
    [2, 3, 4],
    [],
    [4, 5],
    [],
    []
];
const indegree = [0, 0, 1, 1, 2, 1];
const data = [3, 3 - 1];
const time = [0, 10, 10, 4, 4, 3];

function topology_sort() {
    const result = time.slice();
    const q = [];

    for (let i = 1; i < v + 1; i++) {
        if (indegree[i] === 0) {
            q.push(i);
        }
    }

    while (q.length) {
        let now = q.shift();
        for (let i of graph[now]) {
            result[i] = Math.max(result[i], result[now] + time[i]);
            indegree[i] -= 1;

            if (indegree[i] === 0) {
                q.push(i);
            }
        }
    }

    console.log(result);
}

topology_sort();