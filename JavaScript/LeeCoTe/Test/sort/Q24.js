//안테나
//my sol
const n = 4,
    map = [5, 1, 7, 9];

map.sort((a, b) => a - b);

// console.log(map);
let min_value = Infinity;
let result = 0;
for (let i = 0; i < map.length; i++) {
    const line = [];
    for (let j = 0; j < map.length; j++) {
        if (map[i] === map[j]) {
            line.push(0);
        } else {
            line.push(Math.abs(map[i] - map[j]));
        }
    }
    let cal_result = line.reduce((a, b) => a + b);
    if (cal_result < min_value) {
        min_value = cal_result;
        result = map[i];
    }
}

console.log("Q24 answer", result);

//other sol
//중간값을 출력한다?
console.log("Q24 other sol", map[parseInt((n - 1) / 2)]);