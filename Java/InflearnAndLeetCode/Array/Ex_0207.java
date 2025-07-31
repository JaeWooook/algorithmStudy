package Java.InflearnAndLeetCode.Array;

import java.util.Scanner;

public class Ex_0207 {
    public int solution(int n , int[] array) {
        //10
        //1 0 1 1 1 0 0 1 1 0
        int answer = 0;
        int[] answerArr = new int[n+1];
        int score = 0;
        for(int i=0; i<n; i++) {
            if(array[i] == 0) {
                answerArr[i] = 0;
                score=0;
            }
            else {
                if(score==0) {
                    score++;
                    answerArr[i]=score;
                } else {
                    score++;
                    answerArr[i]=score;
                }
            }
        }
        for(int i=0; i<answerArr.length; i++) {
            answer+=answerArr[i];
        }
        return answer;
    }

    public int solution2(int n , int[] array) {//좀더 간단하게 한다면
        //10
        //1 0 1 1 1 0 0 1 1 0
        int answer = 0;
        int score = 0;
        for(int i=0; i<n; i++) {
            if(array[i]==1) {
                score++;
                answer+=score;
            } else {
                score=0;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0207 T = new Ex_0207();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        int[] array = new int[i];
        for(int a=0; a<i; a++) {
            array[a] = in.nextInt();
        }
        System.out.print(T.solution2(i,array));
        return ;
    }
}
