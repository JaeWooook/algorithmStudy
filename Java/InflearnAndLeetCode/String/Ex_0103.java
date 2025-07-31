package Java.InflearnAndLeetCode.String;

import java.util.Scanner;

public class Ex_0103 {
    public String solution(String str) {
        String[] answer = str.split(" ");
        String temp = "";
        int maxLength = -999;

        for(String tempStr : answer) {
            if(tempStr.length() > maxLength) {
                maxLength=tempStr.length();
                temp=tempStr;
            }
        }

        return temp;
    }

    public static void main(String[] args){
        Ex_0103 T = new Ex_0103();
        Scanner in= new Scanner(System.in);
        String str = in.nextLine();
        System.out.print(T.solution(str));
    }
}
