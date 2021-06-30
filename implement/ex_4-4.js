let N=4, M=4;

let people1=[1,1,0];
let arr1=[[1,1,1,1],[1,0,0,1],[1,1,0,1],[1,1,1,1]];
let steps=[-1,1,1,-1];
console.log("input N,M : ",N,M);
console.log("people, Map : ",people1,",", arr1);
let result=0, cnt=0;
let startA=1, startB=1, startC=0;
if (arr1[startA][startB]!==1) {
    arr1[startA][startB]=1;
    result=1;
}
else {
    result=0;
}

while(true) {
    if(startC===0) {
        if(arr1[startA+steps[startC]][startB]!==1) {
            arr1[startA+steps[startC]][startB]=1;
            startA+=steps[startC];
            result++;
            cnt=0;
        }
        else{
            startC-=1;
            cnt++;       
        }
    }
    if(startC===1) {
        if(arr1[startA][startB+steps[startC]]!==1) {
            arr1[startA][startB+steps[startC]]=1;
            startB+=steps[startC];
            result++;
            cnt=0;
        }
        else{
            startC-=1;
            cnt++;
        }
    }
    if (startC===2) {
        if(arr1[startA+steps[startC]][startB]!==1) {
            arr1[startA+steps[startC]][startB]=1;
            startA+=steps[startC];
            result++;
            cnt=0;
        }
        else {
            startC-=1;
            cnt++;
        }
    }
    if (startC===3) {
        if(arr1[startA][startB+steps[startC]]!==1) {
            arr1[startA][startB+steps[startC]]=1;
            startB+=steps[startC];
            result++;
            cnt=0;
        }
        else {
            startC-=1;
            cnt++;
        }
    }

    if(startC===-1) {
        startC=3;    
    }
    if(cnt===4) {
        break;
    }
}
console.log("ex_4-4 result :",result);
//other sol
d=[[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]];
let arr2=[[1,1,1,1],[1,0,0,1],[1,1,0,1],[1,1,1,1]];
let dx=[-1,0,1,0], dy=[0,1,0,-1];
let direction=0;
let x=1,y=1;
d[x][y]=1;
function turn_left() {
    direction-=1;
    if (direction==-1) {
        direction=3;
    }
}
let count=1;
let turn_time=0;
let nx=0, ny=0;
while (true) {
    turn_left();
    nx=x+dx[direction];
    ny=y+dy[direction];
    
    if(d[nx][ny] === 0 && arr2[nx][ny] === 0) {
        d[nx][ny]=1;
        x=nx;
        y=ny;
        count+=1;
        turn_time=0;
        continue;
    }
    else {
        turn_time+=1;
    }

    if(turn_time===4) {
        nx=x-dx[direction];
        ny=y-dy[direction];
        if (arr2[nx][ny]===0) {
            x=nx;
            y=ny;
        }
        else {
            break;
        }
        turn_time=0;
    }
}
console.log("other sol answer : ",count);