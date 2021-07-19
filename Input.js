const readline = require("readline");
const std = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

/* 문자형 숫자를 두개 입력받아 숫자로 변환한후 두개를 더해서 출력하는 예제  */
std.on('line', (line) => {
    input = line.split(' ').map(el => Number(el));
    console.log(input[0] + input[1]); //input[0]이면 그냥 1개를 입력하고 출력하는것이다.
    std.close();
}).on('close', () => process.exit())

//============other===========
/*
console.log("여러줄을 입력해보세요 !!");
input = [];
std.on("line", function(line) {
    input.push(line);
}).on("close", function() {
    console.log(input);
    process.exit();
});*/


//백준 인풋넣는방법
let [n, ...arr] = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");