//연산자 끼워 넣기
//my sol




//other sol
const N = 3;
const digit = [3, 4, 5];

let add = 1,
    sub = 0,
    mul = 1,
    div = 0;

let min_value = Infinity;
let max_value = -1 * Infinity;

function dfs(i, now) { //계산식을 초기화해주고 길이가끝날때까지 재귀함수를 이용한다.
    // console.log("what", i, now);
    if (i === N) {
        min_value = Math.min(min_value, now);
        max_value = Math.max(max_value, now);
    } else {
        if (add > 0) {
            add -= 1;
            dfs(i + 1, now + digit[i]);
            add += 1;
        }
        if (sub > 0) {
            sub -= 1;
            dfs(i + 1, now - digit[i]);
            sub += 1;
        }
        if (mul > 0) {
            mul -= 1;
            dfs(i + 1, now * digit[i]);
            mul += 1;
        }
        if (div > 0) {
            div -= 1;
            dfs(i + 1, parseInt(now / digit[i]));
            div += 1;
        }
    }
}
dfs(1, digit[0]);

console.log("Q19 other sol");
console.log("max", max_value);
console.log("min", min_value);