//my sol
let N=5; let M2=7;
let M=8; let K2=2;
let K=3;

let arr1=[2,4,5,4,6];
let arr2=[3,4,3,4,3];

let result=0;

arr1.sort((a,b)=>b-a);
arr2.sort((a,b)=>b-a);

// console.log(arr1);

console.log(arr2);

let cnt=0;
for(let i=0; i<M2; i++) {
    if (cnt<K2) {
        cnt++;
        result+=arr2[0];
    }
    else {
        cnt=0;
        result+=arr2[1];
    }
}

console.log(result);

//other sol
//수열의 관점으로 봐서 가장 큰수가 몇번 반복되는지를 확인하고 전체의 덧셈-가장큰수가 나오는 횟수 = 나머지만큼을 더해준다.

let first=arr1[0];
let second=arr1[1];
let otherResult=0;
let count=parseInt(M/(K+1))*K; //수열의 관점으로 가장 큰수가 나오는 횟수를 계산한다.
count+=parseInt(M%(K+1)); //큰 수가 나오는 횟수를 계산할때 M/K+1의 값에서 나누어 떨어지지 않은경우를 생각하여 나머지를 추가로 계산한다.
otherResult+=count*first;
otherResult+=(M-count)*second;
console.log("this is other sol", otherResult);
