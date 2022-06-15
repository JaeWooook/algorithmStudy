//카드 정렬하기
//my sol
const n = 3;
const arr = [1, 3, 6, 7, 8, 10];
const result = [];
arr.sort((a, b) => a - b);
let index = 0;
for (let i = 0; i < arr.length; i++) {
    if (i === 0) {
        result.push(arr[i] + arr[i + 1]);
    }

    if (i > 1) {
        result.push(result[index] + arr[i]);
        index++;
    }
}
let answer = result.reduce((a, b) => a + b);
console.log("Q26 answer", answer);

//other sol
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


        for (let i = 0; i < this.queue.length; i++) {

            if (this.queue[i].priority > qElement.priority) {

                this.queue.splice(i, 0, qElement);
                isContain = true;
                break;
            }
        }


        if (!isContain) {
            this.queue.push(qElement);
        }

    }
    dequeue() {

        if (this.queue.length === 0) {
            return new Error("우선순위 큐에 데이터가 없습니다.");
        }
        return this.queue.shift().element; //element만 뱉어내도록 만들었다.
    }
}

const pq = new PriorityQueue();
for (let i = 0; i < arr.length; i++) {
    pq.enqueue(arr[i], arr[i]);
}
let othersol = 0;
while (pq.queue.length !== 1) {
    let one_value = pq.dequeue();
    let two_value = pq.dequeue();

    let sum_value = one_value + two_value;
    othersol += sum_value;
    console.log("check", othersol, sum_value, one_value, two_value);
    pq.enqueue(sum_value, sum_value);
}

console.log("Q26 other sol", othersol);