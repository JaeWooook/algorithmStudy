package Java.InflearnAndLeetCode.String;

import java.util.Scanner;

public class Ex_0106 {

    public String solution(String str) {
        String answer = "";
        for(char x : str.toCharArray()) {
           if(answer.indexOf(x) == -1) {
               answer+=x;
           }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0106 T = new Ex_0106();
        Scanner in=new Scanner(System.in);
        String s = in.next();
        System.out.println(T.solution(s));
        return ;
    }
}
