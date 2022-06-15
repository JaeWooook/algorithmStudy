//곱하기 혹은 더하기
//my sol
const num1 = "02984",
    num2 = "567";

function arrTrans(num) {
    const arr = [];
    for (let i = 0; i < num.length; i++) {
        arr.push(parseInt(num[i]));
    }
    return arr;
}

function cal(arr) {
    let temp1 = arr[0] + arr[1];
    let temp2 = arr[0] * arr[1];
    let result = 0;
    if (temp1 > temp2) {
        result = temp1;
    } else {
        result = temp2;
    }
    for (let i = 2; i < arr.length; i++) {
        let temp = result;
        let temp1 = temp + arr[i];
        let temp2 = temp * arr[i];
        if (temp1 > temp2) {
            result = temp1;
        } else {
            result = temp2;
        }
    }
    return result;
}
let arr = arrTrans(num2);
let result = cal(arr);

console.log("Q2 answer:", result);