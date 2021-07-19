//국영수
//mysol
const N = 12;
const arr = [
    ['Junkyu', 50, 60, 100],
    ['Sangkeun', 80, 60, 50],
    ['Sunyoung', 80, 70, 100],
    ['Soong', 50, 60, 90],
    ['Haebin', 50, 60, 100],
    ['Kangsoo', 60, 80, 100],
    ['Donghyuk', 80, 60, 100],
    ['Sei', 70, 70, 70],
    ['Wonseob', 70, 70, 90],
    ['Sanghyun', 70, 70, 80],
    ['nsj', 80, 80, 80],
    ['Taewhan', 50, 60, 90]
];

arr.sort((a, b) => {
    if (a[1] === b[1]) {
        return a[2] - b[2];
    } else if (a[1] === b[1] && a[2] === b[2]) {
        return b[3] - a[3];
    } else if (a[1] === b[1] && a[2] === b[2] && a[3] === b[3]) {
        return a[0] - b[0];
    } else {
        return b[1] - a[1];
    }
});
console.log("Q23 answer");
for (let i = 0; i < arr.length; i++) {
    console.log(arr[i][0]);
}
//other sol
//1->4->3->2번 방식으로 옮겨야한다.
//왜냐하면 2번이 4번보다 앞서게 되면
//국어점수가 같은 경우에만 판단하기 때문에 영,수도 같을 수도있기 때문이다.
//즉, 국,영,수가 모두 같으면 사전 순으로 정렬해야 하지만, 국어 점수가 같다는 것만 판단하고 영어 점수 오름차순 정렬을 해버릴 수 도 있기 때문이다.
const arr1 = [
    ['Junkyu', 50, 60, 100],
    ['Sangkeun', 80, 60, 50],
    ['Sunyoung', 80, 70, 100],
    ['Soong', 50, 60, 90],
    ['Haebin', 50, 60, 100],
    ['Kangsoo', 60, 80, 100],
    ['Donghyuk', 80, 60, 100],
    ['Sei', 70, 70, 70],
    ['Wonseob', 70, 70, 90],
    ['Sanghyun', 70, 70, 80],
    ['nsj', 80, 80, 80],
    ['Taewhan', 50, 60, 90]
];

arr1.sort((a, b) => {
    if (a[1] !== b[1]) { //국어점수가 서로 다른경우 === 국어점수가 감소하는 순서 같은말이다.
        return b[1] - a[1];
    } else if (a[1] === b[1] && a[2] === b[2] && a[3] === b[3]) { //문자열 비교는 sort자체로 되는데 a,b 를 빼는 방식은 숫자에서 사용하는 정렬방식이다.
        if (a[0] > b[0]) { //문자열 오름차순 처리하는 방법
            return 1;
        } else if (a[0] < b[0]) {
            return -1;
        } else {
            return 0;
        }
    } else if (a[1] == b[1] && a[2] === b[2]) {
        return b[3] - a[3];
    } else if (a[1] === b[1]) {
        return a[2] - b[2];
    }
});

console.log("Q23 other sol");
for (let i = 0; i < arr1.length; i++) {
    console.log(arr1[i][0]);
}
// const arr2 = ['Junkyu', 'Haebin'];
// arr2.sort((a, b) => {
//     if (a > b) {
//         return 1;
//     } else if (a < b) {
//         return -1;
//     } else {
//         return 0;
//     }
// });
// console.log("test", arr2);

// const digit = [
//     [1, 4, 5],
//     [3, 1, 2],
//     [2, 5, 6]
// ];
// digit.sort((a, b) => a[0] - b[0]);
// console.log(digit);