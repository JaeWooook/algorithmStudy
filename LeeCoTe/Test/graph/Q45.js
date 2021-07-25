//최종 순위
//my sol



//other sol
const n1 = 3,
    n2 = 3,
    n3 = 4,
    m1 = 2,
    m2 = 0,
    m3 = 3;

const indegree = Array(n1 + 1).fill(0);
const graph = Array.from(Array(n1 + 1), () => Array(n1 + 1).fill(false));
const trans1 = [
        [2, 4],
        [3, 4]
    ],
    trans3 = [
        [1, 2],
        [3, 4],
        [2, 3]
    ];
const data1 = [5, 4, 3, 2, 1],
    data2 = [2, 3, 1],
    data3 = [1, 2, 3, 4];

for (let i = 0; i < n1; i++) {
    for (let j = i + 1; j < n1; j++) {
        graph[data[i]][data[j]] = true;
        indegree[data[j]] += 1;
    }
}
for (let i = 0; i < m1; i++) {
    if (graph[trans1[i][0]][trans1[i][1]]) {
        graph[trans1[i][0]][trans1[i][1]] = false;
        graph[trans1[i][1]][trans1[i][0]] = true;
        indegree[trans1[i][0]] += 1;
        indegree[trans1[i][1]] -= 1;
    } else {
        graph[trans1[i][0]][trans1[i][1]] = true;
        graph[trans1[i][1]][trans1[i][0]] = false;
        indegree[trans1[i][0]] -= 1;
        indegree[trans1[i][1]] += 1;
    }
}
const result = [];
const que = [];

for (let i = 1; i < n1 + 1; i++) {
    if (indegree[i] === 0) {
        que.push(i);
    }
}
let certain = true;
let cycle = false;

for (let i = 0; i < n1; i++) {
    if (que.length === 0) {
        cycle = true;
        break;
    }
    if (que.length >= 2) {
        certain = false;
        break;
    }
    let now = que.shift();
    result.push(now);
    for (let j = 1; j < n + 1; j++) {
        if (graph[now][j]) {
            indegree[j] -= 1;

            if (indegree[j] === 0) {
                que.push(j);
            }
        }
    }
}
if (cycle) {
    console.log("IMPOSSIBLE");
} else if (!certain) {
    console.log("?");
} else {
    for (let i of result) {
        process.stdout.write(`${i} `);
    }
    console.log()
}