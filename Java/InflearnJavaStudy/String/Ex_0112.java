package Java.InflearnJavaStudy.String;

import java.util.Scanner;

public class Ex_0112 {
    public String solution(String str, int num) {
        //4
        //#****###**#####**#####**##**
        //#*** *### **## ###* *### ##** ##**
        String answer = "";
        int[] DigitArray = new int[str.length()];
        int len = str.length()/num;
        System.out.println(len);


        return answer;
    }

    public static void main(String[] args){
        Ex_0112 T = new Ex_0112();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        String s = in.next();
        System.out.print(T.solution(s, i));
        return ;
    }
}
