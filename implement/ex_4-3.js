let str1="a1" ,str2="c2"

//mysol
console.log("input : ",str2);

// let arr1=str1.split("");
let a='a';
let trans_str1=(str2[0].charCodeAt(0)-a.charCodeAt(0))+1;
let trans_str2=parseInt(str2[1]);
// console.log(trans_str1);
// console.log(trans_str2);

let steps=[[2,1],[2,-1],[-2,-1],[-2,1],[1,2],[1,-2],[-1,2],[-1,-2]];

let minX=1, minY=1, maxX=8, maxY=8;
let result=0;
for(let i=0; i<steps.length; i++) {
    temp_x=trans_str1;
    temp_y=trans_str2;

    temp_x+=steps[i][0];
    temp_y+=steps[i][1];
    if(temp_x>=minX && temp_x<=maxX && temp_y>=minY && temp_y<=maxY) {
        result++;
    }
}
console.log("ex_4-3 answer :",result);

//other sol
