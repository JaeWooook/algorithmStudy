package Java.InflearnAndLeetCode.String;

import java.util.Scanner;

public class Ex_0107_02 {
    public String solution(String str) {
        String answer = "YES";
        int len = str.length();
        String tmp = str.toUpperCase();

        for(int i=0; i<len/2; i++) {
            if(tmp.charAt(i) != tmp.charAt(len-i-1)) {
//                이렇게 해도되고, 굳이 break를 사용하고 싶지 않다면
//                answer="NO";
//                break;
                return "NO";
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0107_02 T = new Ex_0107_02();
        Scanner in=new Scanner(System.in);
        String s = in.next();
        System.out.println(T.solution(s));
        return ;
    }
}
