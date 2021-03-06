//치킨 배달
//my sol
const N = 5,
    M1 = 3,
    M2 = 2,
    M3 = 1;
const arr1 = [
    [0, 0, 0, 0, 0, 0],
    [0, 0, 0, 1, 0, 0],
    [0, 0, 0, 2, 0, 1],
    [0, 0, 1, 2, 0, 0],
    [0, 0, 0, 1, 0, 0],
    [0, 0, 0, 0, 0, 2]
];
const arr2 = [
    [0, 0, 0, 0, 0, 0],
    [0, 0, 2, 0, 1, 0],
    [0, 1, 0, 1, 0, 0],
    [0, 0, 0, 0, 0, 0],
    [0, 2, 0, 0, 1, 1],
    [0, 2, 2, 0, 1, 2]
];
const arr3 = [
    [0, 0, 0, 0, 0, 0],
    [0, 1, 2, 0, 0, 0],
    [0, 1, 2, 0, 0, 0],
    [0, 1, 2, 0, 0, 0],
    [0, 1, 2, 0, 0, 0],
    [0, 1, 2, 0, 0, 0]
];

function checker_home(arr) {
    let flag = 1;
    for (let i = 1; i <= N; i++) {
        for (let j = 1; j <= N; j++) {
            if (arr[i][j] === 1) {
                arr[i][j] = 0;
                let line = [i, j];
                flag = 0;
                return line;
            }
        }
    }
    if (flag === 1) {
        return false;
    }
}


function checker_dak(arr, a, b) {
    let small = Infinity;
    for (let i = 1; i <= N; i++) {
        for (let j = 1; j <= N; j++) {
            if (arr[i][j] === 2) {
                let result1 = Math.abs(a - i);
                let result2 = Math.abs(b - j);
                let result = result1 + result2;
                if (small > result) {
                    small = result;
                    // console.log("what?", small);
                }
            }
        }
    }
    return small;
}
let result = [];

// while (true) {
//     let temp = checker_home(arr1);
//     if (temp !== false) {
//         result.push(checker_dak(arr1, temp[0], temp[1]));
//     }

//     if (temp === false) {
//         // console.log(result);
//         console.log("Q13 answer:", result.reduce((a, b) => a + b));
//         break;
//     }
// }

//other sol
let answer = 0;

function getCombinations(arr, selectNumber) {
    const comp = [];
    if (selectNumber === 1) {
        return arr.map((value) => [value]);
    }
    arr.forEach((fixed, index, origin) => {
        const rest = origin.slice(index + 1);
        const combinations = getCombinations(rest, selectNumber - 1);
        const attached = combinations.map((combination) => [fixed, ...combination]);
        comp.push(...attached);
    });
    return comp;
}
const house = [],
    chicken = [];

function check(arr) {
    for (let i = 1; i <= N; i++) {
        for (let j = 1; j <= N; j++) {
            if (arr[i][j] === 1) {
                house.push([i, j]);
            } else if (arr[i][j] === 2) {
                chicken.push([i, j]);
            }
        }
    }
}
check(arr3);
let candidates = getCombinations(chicken, M3);

function get_sum(candidates) {
    let result = 0;
    for (let h of house) {
        let hx = h[0];
        let hy = h[1];
        let temp = Infinity;
        for (let c of candidates) {
            let cx = c[0];
            let cy = c[1];
            temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));
        }
        result += temp;
    }
    return result;
}
answer = Infinity;
for (let candidate of candidates) {
    answer = Math.min(answer, get_sum(candidate));
}
console.log("Q13 other sol", answer);

//other sol
const n5 = 5, //백트레킹에 대해 학습
    m5 = 2;
const arr5 = [
    [0, 2, 0, 1, 0],
    [1, 0, 1, 0, 0],
    [0, 0, 0, 0, 0],
    [2, 0, 0, 1, 1],
    [2, 2, 0, 1, 2],
];

const person = [];
const chicken2 = [];
for (let i = 0; i < n5; i++) {
    for (let j = 0; j < n5; j++) {
        if (arr5[i][j] === 1) {
            person.push([i, j]);
        }

        if (arr2[i][j] === 2) {
            chicken2.push([i, j]);
        }
    }
}
let ans = Infinity;
let open = Array(chicken2.length).fill(-1);
// console.log(open);
function dfs(start, cnt) {
    if (cnt === m5) {
        let res = 0;
        for (let i = 0; i < person.length; i++) {
            let temp = Infinity;
            for (let j = 0; j < chicken2.length; j++) {
                if (open[j]) {
                    let distance =
                        Math.abs(person[i][0] - chicken2[j][0]) +
                        Math.abs(person[i][1] - chicken2[j][1]);

                    temp = Math.min(temp, distance);
                }
            }
            res += temp;
        }
        ans = Math.min(ans, res);
        return;
    }

    for (let i = start; i < chicken2.length; i++) {
        open[i] = true;
        dfs(i + 1, cnt + 1);
        // console.log("what?back", ans);
        open[i] = false;
    }
}

dfs(0, 0);
console.log("Q13 other sol answer", ans);