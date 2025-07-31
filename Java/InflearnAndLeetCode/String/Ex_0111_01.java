package Java.InflearnAndLeetCode.String;

import java.util.Scanner;

public class Ex_0111_01 {
    public String solution(String str) {//KSTTTSEEKFKKKDJJGG
        StringBuilder answer = new StringBuilder();
        int cnt = 1;
        for(int i=0; i<str.length()-1; i++) {
            if(i==str.length()-2) {
                if(str.charAt(i)==str.charAt(str.length()-1)) {
                        cnt++;
                    if(cnt>1) {
                        answer.append(Character.toString(str.charAt(i)));
                        answer.append(Integer.toString(cnt));
                    } else {
                        answer.append(Character.toString(str.charAt(i)));
                        answer.append(Character.toString(str.charAt(i+1)));
                    }
                } else {
                    answer.append(Character.toString(str.charAt(i)));
                    answer.append(Character.toString(str.charAt(i+1)));
                }
            }
            else {
                if(str.charAt(i) == str.charAt(i+1)) {
                    cnt++;
                }
                else {
                    if(cnt>1) {
                        answer.append(Character.toString(str.charAt(i)));
                        answer.append(Integer.toString(cnt));
                    }
                    else {
                        answer.append(Character.toString(str.charAt(i)));
                    }
                    cnt=1;
                }
            }
        }

        return answer.toString();
    }

    public static void main(String[] args){
        Ex_0111_01 T = new Ex_0111_01();
        Scanner in=new Scanner(System.in);
        String s = in.next();
        System.out.print(T.solution(s));
        return ;
    }
}
