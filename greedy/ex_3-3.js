//my sol
M=3, M2=2;
N=3, N2=4;
arr1=[[3,1,2],[4,1,4],[2,2,2]];
arr2=[[7,3,1,8],[3,3,3,4]];

let result=new Array(M);
let answer=0;
for (let i=0; i<M2; i++) {
    let min=999999;
    for (let j=0; j<N2; j++) {
        min=Math.min(min,arr2[i][j]);
        result[i]=min;
    }
}
for (let i=0; i<M2; i++) {
    let max=-1;
    max=Math.max(max, result[i]);
    answer=max;
}
console.log("result",answer);

//other sol

