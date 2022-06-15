//문자열 압축
//my sol
function solution(s) {
    var answer = Infinity;
    let cnt = 1;
    while (cnt <= s.length) {
        const line = [];
        for (let i = 0; i < s.length; i += cnt) {
            line.push(s.slice(i, i + cnt));
        }
        cnt++;
        const result = [];
        let count = 1;
        for (let i = 0; i < line.length; i++) {
            if (line[i] === line[i + 1]) {
                count++;
            } else {
                if (count !== 1) {
                    result.push(String(count));
                }
                result.push(line[i]);
                count = 1;
            }
            if (i === line.length - 1) {
                if (line[i - 1] === line[i]) {
                    if (count !== 1) {
                        result.push(String(count));
                        result.push(line[i]);
                        count = 1;
                    }
                }
            }
        }
        let temp = [];
        for (let i = 0; i < result.length; i++) {
            temp += result[i];
        }
        if (temp.length < answer) {
            answer = temp.length;
        }
    }

    return answer;
}

//other sol
function solution(s) {
    if (s.length === 1) return 1;
    let min = 1000;
    for (let i = 1; i <= s.length / 2; i++) {
        let str1 = '';
        let str2 = '';
        let ans = '';
        let count = 1;
        for (let j = 0; j < s.length; j += i) {

            if (j === 0) {
                str1 = s.slice(j, j + i);
            } else {
                str2 = s.slice(j, j + i)
                if (str1 === str2) {
                    count++;
                    if (j + i === s.length) ans += `${count}${str1}`;

                } else {
                    if (count > 1) {
                        ans += `${count}${str1}`
                    } else {
                        ans += str1;
                    }
                    count = 1;
                    if (str1.length > str2.length) {
                        ans += str2;
                    }
                    str1 = str2;
                    if (j + i === s.length) ans += str2;
                }
            }




        }
        min = Math.min(ans.length, min);
    }
    return min;
}