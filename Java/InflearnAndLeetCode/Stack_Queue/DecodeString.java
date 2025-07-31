package Java.InflearnAndLeetCode.Stack_Queue;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        // 3 [a] 2 [bc]
        //2[abc]3[cd]ef
        //abc3[cd]xyz
        //100[leetcode]
        //3 [ a 2 [ c ] ]
        //3[z] 2[2[y] pq  4[ 2[jk] e 1[f] ] ] ef -> ef나오고 f 나오고, e하나 jkjk 4개(jkjkef)
        Stack<String> intStack = new Stack<String>();
        Stack<String> strStack = new Stack<String>();
        int rightCnt = 0;
        int leftCnt =0;
        String result = "";
        String currIntVal = ""; //저장할때 비워주기
        String currStrVal = ""; //저장할때 비워주기

        for(char ch: s.toCharArray()) {
            if(Character.isDigit(ch)) {//숫자는 추가후
                currIntVal += ch;
            } else if('[' == ch) {//만나면 저장
                currIntVal += ch;
                intStack.push(currIntVal);
                currIntVal = "";

                //문자도 저장
                strStack.push(currStrVal);
                currStrVal = "";
                leftCnt++;
            } else if(Character.isAlphabetic(ch)) {
                currStrVal += ch;
            } else if(']' == ch) {
                rightCnt++;

                //숫자 호출
                String nums = intStack.pop();
                String strNum = "";
                for(char num : nums.toCharArray()) {
                    if(num != '[') {
                        strNum += num;
                    }
                }
                int intNum = Integer.parseInt(strNum);
                //문자 호출
                String str = strStack.pop();

                //문자 호출해서 곱셈한다
                String sumStr = "";

                for(int i=0; i< intNum; i++) {
                    sumStr += currStrVal;
                }
                str+=sumStr;

                //문자 를 result에 계싼해주기
                if(leftCnt == rightCnt) {//이건 출력되도된다.
                    result += str;
                    currStrVal = "";
                } else {//현재 문자를 만들어서 저장해준다.
                    currStrVal = str;
                }
            }
        }

        if(currStrVal.length() > 0) {
            result+= currStrVal;
        }

        return result;
    }

    public static void main(String[] args) {
//        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
//        String s = "3[a2[c]]";
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }
}
