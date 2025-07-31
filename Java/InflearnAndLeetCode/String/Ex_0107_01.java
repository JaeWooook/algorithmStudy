package Java.InflearnAndLeetCode.String;

import java.util.Scanner;

public class Ex_0107_01 {
    public String solution(String str) {
        String answer = "";
        char [] tempData = str.toCharArray();
        int rt = 0, lt= str.length()-1;

        while(rt<lt) {
            if(Character.toUpperCase(tempData[rt]) == Character.toUpperCase(tempData[lt])) {
                answer="YES";
            } else {
                answer="";
                answer+="NO";
                break;
            }
            rt++;
            lt--;
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0107_01 T = new Ex_0107_01();
        Scanner in=new Scanner(System.in);
        String s = in.next();
        System.out.println(T.solution(s));
        return ;
    }
}
