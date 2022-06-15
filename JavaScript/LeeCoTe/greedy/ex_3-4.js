//my sol

let N=25, K=5;
let cnt=0;
let N2=17, K2=4;

console.log("input:", "N: ",N, " K: ",K);
while (N!=1) {
    if (N%K==0) {
        N/=K;
        cnt++;
    }
    else {
        N-=1;
        cnt++;
    }
}
console.log("ex_3-4 answer : ", cnt, "N: ",N);


//other sol
