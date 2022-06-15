let INF = Infinity;
let arr = [
    [0, 10, 1, 4, INF, INF],
    [10, 0, 2, 5, INF, INF],
    [1, 2, 0, 1, INF, 8],
    [4, 5, 1, 0, INF, 3],
    [INF, INF, INF, INF, 0, 2],
    [INF, INF, 8, 3, 2, 0]
]; //0 1 2 3 4 5번에게 가는 경로가 있으면 cost 표시, 없으면 INF, 자기자신이면 0
// let visited = Array.from(Array(N), () => Array(M).fill(0));
const isVisit = new Array(6).fill(false);
//vertex 6개

function getMin(vertex) {
    let min = INF;
    let idx = 0;
    for (let i = 0; i < vertex.length; i++) {
        if (min > vertex[i] && !isVisit[i]) { //방문안한 노드이면서, 0번이랑 가장 가까운 노드찾는다.
            min = vertex[i];
            idx = i;
        }
    }
    return idx;
}

function dist(start) {
    let v = arr[start - 1]; //arr[0][0~5] 배열생성
    let count = 0;
    let end = v.length;
    let min = 0;
    let startV = v;
    isVisit[start - 1] = true; //0번 노드 방문표시
    // console.log("pre v node", v);
    while (count < end) {
        const idx = getMin(startV);
        min += startV[idx]; //제일 작은 값을 min에 더한다. 초기화를안한다.
        const next = arr[idx]; //다음 방문할 노드는 해당 그 제일 작은값이다.
        // console.log("pre node , next node", v, next);
        for (let i = 0; i < v.length; i++) {
            if (v[i] > next[i] + min && !isVisit[i]) { //현재 방문한 노드에서, 1번노드랑 3번노드
                v[i] = next[i] + min;
                // console.log("check", v[i], next[i], min);
            }
            // console.log("transition check", i, v[i], next[i]);
        }
        startV = arr[idx];
        isVisit[idx] = true;
        count++;
        // console.log("node", v, startV);
    }
    console.log(v); //v가 책의 distance역할을 한다.
}

dist(1);

//min heap && PriorityQueue
class QElement { //우선순위 큐에 삽입되는 데이터 클래스
    constructor(element, priority) {
        this.element = element;
        this.priority = priority;
    }
}
class PriorityQueue {
    constructor() {
        this.queue = [];
    }

    enqueue(element, priority) {
        const qElement = new QElement(element, priority);
        let isContain = false;
        //전체를 순회하면서 자신의 우선순위가 더 높은 위치를 탐색
        for (let i = 0, j = this.queue.length; i < j; i++) {
            if (this.queue[i].priority < qElement.priority) {
                this.queue.splice(i, 0, qElement);
                isContain = true;
                break;
            }
        }
        if (!isContain) { //큐에 자신보다 더 낮은 우선순위를 가진 요소가 없을 때, 큐의 맨 마지막에 삽입
            this.queue.push(qElement);
        }
    }
    dequeue() {
        if (this.queue.length === 0) {
            return new Error("우선순위 큐에 데이터가 없습니다.");
        }
        return this.queue.shift();
    }
}

//Floyd-Warshall Algorithm
const N = 4,
    M = 7;
const graph = [
    [INF, INF, INF, INF, INF],
    [INF, 0, 4, INF, 6],
    [INF, 3, 0, 7, INF],
    [INF, 5, INF, 0, 4],
    [INF, INF, INF, 2, 0]
];

for (let k = 1; k < N + 1; k++) {
    for (let a = 1; a < N + 1; a++) {
        for (let b = 1; b < N + 1; b++) {
            graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
        }
    }
}

for (let a = 1; a < N + 1; a++) {
    for (let b = 1; b < N + 1; b++) {
        if (graph[a][b] === INF) {
            process.stdout.write(`INFINTY `);
        } else {
            process.stdout.write(`${graph[a][b]} `);
        }
    }
    console.log();
}
// console.log(graph);