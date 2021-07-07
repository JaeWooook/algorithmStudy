let INF = Infinity;
let arr = [
    [0, 2, 5, 1, INF, INF],
    [2, 0, 3, 2, INF, INF],
    [5, 3, 0, 3, 1, 5],
    [1, 2, 3, 0, 1, INF],
    [INF, INF, 1, 1, 0, 2],
    [INF, INF, 5, INF, 2, 0]
];
// let visited = Array.from(Array(N), () => Array(M).fill(0));
const isVisit = new Array(6).fill(false);

function getMin(vertex) {
    let min = INF;
    let idx = 0;
    for (let i = 0; i < vertex.length; i++) {
        if (min > vertex[i] && !isVisit[i]) {
            min = vertex[i];
            idx = i;
        }
    }
    return idx;
}

function dist(start) {
    let v = arr[start - 1];
    let count = 0;
    let end = v.length;
    let min = 0;
    let startV = v;
    isVisit[start - 1] = true;

    while (count < end) {
        const idx = getMin(startV);
        min += startV[idx];
        const next = arr[idx];
        for (let i = 0; i < v.length; i++) {
            if (v[i] > next[i] + min && !isVisit[i])
                v[i] = next[i] + min;
        }
        startV = arr[idx];
        isVisit[idx] = true;
        count++;
    }
    console.log(v);
}

dist(1);