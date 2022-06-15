//화성 탐사
//my sol
//우선순위 큐
class QElement {
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
        // console.log("making the queue and add queue", this.queue);
        for (let i = 0; i < this.queue.length; i++) {
            //   console.log("compare", this.queue[i].priority, qElement.priority);
            if (this.queue[i].priority > qElement.priority) {
                //> 이거면 우선순위가 1 2 3 순이고 <이거면 우선순위가 3 2 1 순서이다.
                this.queue.splice(i, 0, qElement);
                isContain = true;
                break;
            }
        }

        // 큐에 자신보다 더 낮은 우선순위를 가진 요소가 없을 때, 큐의 맨 마지막에 삽입
        if (!isContain) {
            this.queue.push(qElement);
        }
        // console.log("changing the queue", this.queue);
    }
    dequeue() {
        // 큐가 비어있을 때는 오류를 발생시킨다.
        // 비어있지 않다면 첫번째 요소를 삭제하고 반환한다.
        if (this.queue.length === 0) {
            return new Error("우선순위 큐에 데이터가 없습니다.");
        }
        return this.queue.shift();
    }
}

const pq = new PriorityQueue();
const arr1 = [
    [5, 5, 4],
    [3, 9, 1],
    [3, 2, 7],
];
const arr2 = [
    [3, 7, 2, 0, 1],
    [2, 8, 0, 9, 1],
    [1, 2, 1, 8, 1],
    [9, 8, 9, 2, 0],
    [3, 6, 5, 1, 5],
];
const arr3 = [
    [9, 0, 5, 1, 1, 5, 3],
    [4, 1, 2, 1, 6, 5, 3],
    [0, 7, 6, 1, 6, 8, 5],
    [1, 1, 7, 8, 3, 2, 3],
    [9, 4, 0, 7, 6, 4, 1],
    [5, 8, 3, 2, 4, 8, 3],
    [7, 4, 8, 4, 8, 3, 4],
];
let result = 0;
let min_value = Infinity;
let n1 = 3,
    n2 = 5,
    n3 = 7;
const distance = Array.from(Array(n3), () => Array(n3).fill(Infinity));
const visited = Array.from(Array(n3), () => Array(n3).fill(0));
distance[0][0] = 9;
visited[0][0] = 1;
const dx = [0, 1, -1, 0];
const dy = [1, 0, 0, -1];

function dijkstra(arr, n) {
    pq.enqueue([0, 0], arr[0][0]);

    // let cnt = 5;
    while (pq.queue.length !== 0) {
        let dq = pq.dequeue();
        // console.log("꺼냄", dq);

        let currX = dq.element[0];
        let currY = dq.element[1];
        for (let i = 0; i < 4; i++) {
            let nx = dx[i] + currX;
            let ny = dy[i] + currY;
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] !== 1) {

                distance[nx][ny] = Math.min(distance[nx][ny], arr[nx][ny] + distance[currX][currY]);
                pq.enqueue([nx, ny], Math.min(distance[nx][ny], arr[nx][ny] + distance[currX][currY]));
                visited[nx][ny] = 1;
            }
        }
        // console.log(distance);
        // console.log("저장한것", pq.queue);
        if (distance[n - 1][n - 1] !== Infinity) {
            break;
        }
    }
}

dijkstra(arr3, n3);
console.log(distance);
console.log("Q39 answer", distance[n3 - 1][n3 - 1]);


//other sol