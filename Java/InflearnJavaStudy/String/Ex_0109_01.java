package Java.InflearnJavaStudy.String;

import java.util.Scanner;

public class Ex_0109_01 {
    public int solution(String str) {
        int answer = 0;
        str=str.replaceAll("[^0-9]","");
        answer=Integer.valueOf(str);

        return answer;
    }

    public static void main(String[] args){
        Ex_0109_01 T = new Ex_0109_01();
        Scanner in=new Scanner(System.in);
        String s = in.next();
        System.out.println(T.solution(s));
        return ;
    }
}
