package Java.InflearnJavaStudy.Array;

import java.util.Scanner;

public class Ex_0202 {
    public int solution(int[] array, int num) {
        //8
        //130 135 148 140 145 150 150 153
        int answer = 0;
        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++) {
            if(array[i] > maxValue) {
                maxValue=array[i];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0202 T = new Ex_0202();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        int[] array = new int[i];
        for(int a=0; a<i; a++) {
            array[a] = in.nextInt();
        }
        System.out.print(T.solution(array,i));
        return ;
    }
}
