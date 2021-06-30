//my sol
let array=[500,100,50,10];
let N=1260;
let index=0;
let obj={};
while(N!=0) {
    if(N>=array[index]) {
        N-=array[index];
        obj[array[index]] ? obj[array[index]]++ : obj[array[index]]=1;
    }
    else {
        index++;
    }
}
// console.log(obj);

let result=0;
for (let i=0; i<array.length; i++) {
    result+=obj[array[i]];
}
console.log(result);