package Java.InflearnAndLeetCode.String;

import java.util.Scanner;

public class Ex_0110_02 {
    public int[] solution(String str, char ch) {//teachermode e
        int[] answer = new int[str.length()];
        int p=1000;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)==ch) {
                p=0;
                answer[i]=p;
            }
            else {
                p++;
                answer[i]=p;
            }
        }
        for(int i=str.length()-1; i>=0; i--) {
            if(str.charAt(i)==ch) {
                p=0;
            }
            else {
                p++;
                answer[i]=Math.min(answer[i], p);//min을 이용해서 더작은값을 넣을 수 있도록 비교해준다.
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0110_02 T = new Ex_0110_02();
        Scanner in=new Scanner(System.in);
        String s = in.next();
        char c = in.next().charAt(0);//char형으로 받기위한 input
        for(int x : T.solution(s,c)) {
            System.out.print(x+" ");
        }
        return ;
    }
}
