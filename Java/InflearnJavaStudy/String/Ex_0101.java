package Java.InflearnJavaStudy.String;

import java.util.Scanner;

public class Ex_0101 {
    public int solution(String str, char ch) {

        int answer = 0;
        str = str.toUpperCase();
        ch = Character.toUpperCase(ch);
        for(char a : str.toCharArray()) {
            if(a == ch) answer++;
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0101 T = new Ex_0101();
        Scanner in=new Scanner(System.in);
        String str = in.next();
        char ch = in.next().charAt(0);
        System.out.print(T.solution(str, ch));

        return ;
    }
}
