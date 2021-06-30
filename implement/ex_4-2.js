let N=5;
//my soll
let hour=0, min=0, sec=0;
let result=0;
console.log("input N : ",N);
while(true) {

    sec++;
    if(sec===60) {
        sec=0;
        min++;
    }

    if(min===60) {
        min=0;
        hour++;
    }

    if (sec%10===3 || parseInt(sec/10)===3 || min%10===3 || parseInt(min/10)===3 || hour%10===3) {
        result++;
    }
    // console.log("this is time",hour,min,sec);
    if(N===hour) {
        if(min===59) {
            if(sec===59) {
                break;
            }
        }
    }
}

console.log("ex_4-2 answer : ",result);
//other sol