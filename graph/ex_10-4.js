const v = 5;
const indegree = Array(v + 1).fill(0);

const time = Array(v + 1).fill(0);
const graph = Array.from(Array(v + 1), () => Array(v + 1).fill(0));

const data = [
    [10, -1],
    [10, 1, -1],
    [4, 1, -1],
    [4, 3, 1, -1],
    [3, 3, -1]
];
for (let i = 1; i < v + 1; i++) {
    time[i] = data[0];
    // console.log(time);
    const data_temp = data.slice(1, -1);
    for (let x of data_temp) {
        indegree[i] += 1;
        graph[x].push(i);
    }
}

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

    for (let i = 1; i < v + 1; i++) {
        console.log(result[i]);
    }
}

topology_sort();