package Java.InflearnJavaStudy.String;

import java.util.Scanner;

public class Ex_0102 {
    public String solution(String str) {
        String temp = "";

        for(char x : str.toCharArray()) {
            if(Character.isUpperCase(x)) {
                temp+=Character.toLowerCase(x);
            } else {
                temp+=Character.toUpperCase(x);
            }
        }

        return temp;
    }

    public static void main(String[] args){
        Ex_0102 T = new Ex_0102();
        Scanner in= new Scanner(System.in);
        String str = in.next();
        System.out.print(T.solution(str));
    }
}
