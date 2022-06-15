//감시피하기
//my sol
//예외처리 전부다된것인지 사실 모르겠다.
const n1 = 5,
    n2 = 4;

let byuk = 3;
const map1 = [
    ["X", "S", "X", "X", "T"],
    ["T", "X", "S", "X", "X"],
    ["X", "X", "X", "X", "X"],
    ["X", "T", "X", "X", "X"],
    ["X", "X", "T", "X", "X"],
];
const map2 = [
    ["S", "S", "S", "T"],
    ["X", "X", "X", "X"],
    ["X", "X", "X", "X"],
    ["T", "T", "T", "X"],
];

const que = [];

function findT(map) {
    for (let i = 0; i < map.length; i++) {
        for (let j = 0; j < map.length; j++) {
            if (map[i][j] === "T") {
                que.push([i, j]);
            }
        }
    }
}

function left_T(currX, currY, map) {
    let dx = currX,
        dy = currY;
    while (dy >= 0) {
        if (map[dx][dy] === "S" && map[dx][dy + 1] === "X") {
            map[dx][dy + 1] = "O";
            byuk--;
            break;
        }
        dy--;
    }
}

function left_S(currX, currY, map) {
    let dx = currX,
        dy = currY;
    let check = 0;
    while (dy >= 0) {
        if (map[dx][dy] === "O") {
            check = 1;
        }

        if (map[dx][dy] === "T" && check === 1) {
            return 1;
        } else if (map[dx][dy] === "T" && check == 0) {
            return -1;
        }
        dy--;
    }
}

function right_T(currX, currY, map, n) {
    let dx = currX,
        dy = currY;
    while (dy < n) {
        if (map[dx][dy] === "S" && map[dx][dy - 1] === "X") {
            map[dx][dy - 1] = "O";
            byuk--;
            break;
        }
        dy++;
    }
}

function right_S(currX, currY, map, n) {
    let dx = currX,
        dy = currY;
    let check = 0;
    while (dy < n) {
        if (map[dx][dy] === "O") {
            check = 1;
        }

        if (map[dx][dy] === "T" && check === 1) {
            return 1;
        } else if (map[dx][dy] === "T" && check == 0) {
            return -1;
        }
        dy++;
    }
}

function up_T(currX, currY, map) {
    let dx = currX,
        dy = currY;
    while (dx >= 0) {
        if (map[dx][dy] === "S" && map[dx + 1][dy] === "X") {
            map[dx + 1][dy] = "O";
            byuk--;
            break;
        }
        dx--;
    }
}

function up_S(currX, currY, map) {
    let dx = currX,
        dy = currY;
    let check = 0;
    while (dx >= 0) {
        if (map[dx][dy] === "O") {
            check = 1;
        }

        if (map[dx][dy] === "T" && check === 1) {
            return 1;
        } else if (map[dx][dy] === "T" && check == 0) {
            return -1;
        }
        dx--;
    }
}

function down_T(currX, currY, map, n) {
    let dx = currX,
        dy = currY;
    while (dx < n) {
        if (map[dx][dy] === "S" && map[dx - 1][dy] === "X") {
            map[dx - 1][dy] = "O";
            byuk--;
            break;
        }
        dx++;
    }
}

function down_S(currX, currY, map, n) {
    let dx = currX,
        dy = currY;
    let check = 0;

    while (dx < n) {
        if (map[dx][dy] === "O") {
            check = 1;
        }

        if (map[dx][dy] === "T" && check === 1) {
            return 1;
        } else if (map[dx][dy] === "T" && check == 0) {
            return -1;
        }
        dx++;
    }
}

function findS(map, que, n) {
    while (que.length !== 0) {
        let [currX, currY] = que.shift();
        left_T(currX, currY, map);
        right_T(currX, currY, map, n);
        up_T(currX, currY, map);
        down_T(currX, currY, map, n);
    }
}

function Student_Check(map, n) {
    if (byuk < 0) {
        return -1;
    }
    for (let i = 0; i < map.length; i++) {
        for (let j = 0; j < map.length; j++) {
            if (map[i][j] === "S") {
                que.push([i, j]);
            }
        }
    }
    while (que.length !== 0) {
        let [currX, currY] = que.shift();
        let result1 = left_S(currX, currY, map);
        let result2 = right_S(currX, currY, map, n);
        let result3 = up_S(currX, currY, map);
        let result4 = down_S(currX, currY, map, n);

        if (result1 < 0 || result2 < 0 || result3 < 0 || result4 < 0) {
            return -1;
        }
    }
    return 1;
}
findT(map2);
findS(map2, que, n2);
// console.log(map1);
// console.log(que);
let result = Student_Check(map2, n2);
if (result < 0) {
    console.log("Q20 answer NO");
} else {
    console.log("Q20 answer YES");
}