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

//other sol
const N = 3,
    M = 2,
    C = 1;
const INF = Infinity;
const distance = Array(N + 1).fill(INF);
const graph = [
    [],
    [
        [2, 4],
        [3, 2]
    ],
    [],
    []
]
console.log(distance);

function dijkstra(C) {

    const PQ = new PriorityQueue(); //우선순위 큐생성
    PQ.enqueue(0, C); //우선순위 큐에 삽입
    distance[C] = 0 //element가 우선순위의 최단경로 , priority가 현재 노드
    while (PQ.queue.length) {
        const dq = PQ.dequeue();
        const dist = dq.element,
            now = dq.priority;
        // console.log("dist now", dist, now);
        if (distance[now] < dist) {
            continue;
        }
        // console.log(graph[now]);
        for (let i of graph[now]) {
            // console.log("i", i);
            let cost = dist + i[1];
            if (cost < distance[i[0]]) {
                distance[i[0]] = cost;
                PQ.enqueue(cost, i[0]);
            }

        }
    }
}

dijkstra(C);

let count = 0;
let max_distance = 0;
for (let d of distance) {
    if (d !== INF) {
        count += 1;
        max_distance = Math.max(max_distance, d);
    }
}

console.log("ex_9-3 answer :", count - 1, max_distance);