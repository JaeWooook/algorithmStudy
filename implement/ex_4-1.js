let N=5, A=['R','R','R','U','D','D'];

console.log("input N, A : ",N ," " ,A);

let start=[1,1];
//my sol
for (let i=0; i<A.length; i++) {
    if(A[i]==='R'&& start[1]<N) {
        start[1]++;
    }
    else if(A[i]==='L' && start[1]>1) {
        start[1]--;
    }
    else if(A[i]==='U'&& start[0]>1) {
        start[0]--;
    }
    else if(A[i]==='D'&& start[0]<N) {
        start[0]++;
    }


}
console.log("ex_4-1 result :",start[0],start[1]);

//other sol
let B=['R','R','R','U','D','D'];
let dx = [0,0,-1,1], dy=[-1,1,0,0];
move_types=['L','R','U','D'];
let x=1,y=1, nx=0, ny=0;
for (b of B) {
    for (let i=0; i<move_types.length; i++) {
        if (b===move_types[i]) {
            nx=x+dx[i];
            ny=y+dy[i];
        }
    }
    if (nx<1 || ny<1 || nx>N || ny>N) {
        continue;
    }
    x=nx; 
    y=ny;
}

console.log("other sol",x,y);