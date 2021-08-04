//문자열 재정렬
//my sol
const S1 = "K1KA5CB7",
    S2 = "AJKDLSI412K4JSJ9D";

const strArray = [];
let cnt = 0;

function find_digit(str) {
    for (let i = 0; i < str.length; i++) {
        if (isNaN(str[i])) {
            strArray.push(str[i]);
        } else {
            cnt += parseInt(str[i]);
        }
    }

    strArray.sort();
    const result = strArray.concat(String(cnt));

    return result.join("");
}
const result = find_digit(S2);

console.log(result);