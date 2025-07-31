package Java.InflearnAndLeetCode.Array;

import java.util.Scanner;

public class Ex_0204 {
    public int[] solution(int num) {
        //10
        int[] answer = new int[num];
        if(num == 1) {
            answer[0] = 1;
        } else if(num == 2) {
            answer[0] = 1;
            answer[1] = 1;
        } else if(num > 3) {
            answer[0] = 1;
            answer[1] = 1;
            for(int i=2; i<num; i++) {
                answer[i] = answer[i-1]+answer[i-2];
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex_0204 T = new Ex_0204();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();

        for(int a : T.solution(i)) {
            System.out.print(a+" ");
        }
        return ;
    }
}
