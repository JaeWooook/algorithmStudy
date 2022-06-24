package Java.InflearnJavaStudy.Array;

import java.util.Scanner;

public class Ex_0203 {
    public char[] solution(int[] arrayA, int[] arrayB, int num) {
        //5
        //2 3 3 1 3
        //1 1 2 2 3
        char[] answer = new char[num];
        for(int i=0; i<num; i++) {
            if(arrayA[i] == arrayB[i]) {
                answer[i] = 'D';
            }
            else {
                if(arrayA[i] == 1 && arrayB[i] == 3) {
                    answer[i] = 'A';
                }
                else if(arrayA[i] == 3 && arrayB[i] == 1) {
                    answer[i] = 'B';
                } else {
                    if(arrayA[i] > arrayB[i]) {
                        answer[i] = 'A';
                    } else {
                        answer[i] = 'B';
                    }
                }

            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0203 T = new Ex_0203();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        int[] arrayA = new int[i];
        int[] arrayB = new int[i];
        for(int a=0; a<i; a++) {
            arrayA[a] = in.nextInt();
        }
        for(int b=0; b<i; b++) {
            arrayB[b] = in.nextInt();
        }
        for(char x : T.solution(arrayA, arrayB,i)) {
            System.out.println(x);
        }
        return ;
    }
}
