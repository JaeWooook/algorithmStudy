package Java.InflearnJavaStudy.Array;

import java.util.Scanner;

public class Ex_0212 {
    public int solution(int n ,int m, int[][] array) {
        //4 3
        //3 4 1 2
        //4 3 2 1
        //3 1 4 2
        int answer = 0;

        return answer;
    }

    public static void main(String[] args){
        Ex_0212 T = new Ex_0212();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int[][] array = new int[i][j];
        for(int a=0; a<i; a++) {
            for(int b=0; b<j; b++) {
                array[a][b] = in.nextInt();
            }
        }
        System.out.print(T.solution(i,j, array));
        return ;
    }
}
