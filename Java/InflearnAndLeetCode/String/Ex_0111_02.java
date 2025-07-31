package Java.InflearnAndLeetCode.String;

import java.util.Scanner;

public class Ex_0111_02 {
    public String solution(String str) {//KSTTTSEEKFKKKDJJGG
        String answer = "";
        str+=" ";
        int cnt = 1;
        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) cnt++;
            else {
                answer+=str.charAt(i);
                if(cnt>1) {
                    answer+=String.valueOf(cnt);
                }
                cnt=1;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex_0111_02 T = new Ex_0111_02();
        Scanner in=new Scanner(System.in);
        String s = in.next();
        System.out.print(T.solution(s));
        return ;
    }
}
