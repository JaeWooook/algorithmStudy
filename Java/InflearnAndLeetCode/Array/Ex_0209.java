package Java.InflearnAndLeetCode.Array;

import java.util.Scanner;

public class Ex_0209 {
    public int solution(int n , int[][] array) {
        //5
        //10 13 10 12 15
        //12 39 30 23 11
        //11 25 50 53 15
        //19 27 29 37 27
        //19 13 30 13 19
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {//행 계산
                sum+=array[i][j];
            }
            if(answer < sum) {
                answer = sum;
            }
            sum=0;
            for(int j=0; j<n; j++) {//열 계산
                sum+=array[j][i];
            }
            if(answer < sum) {
                answer = sum;
            }
        }
        int i=0, j=0;
        int sum=0;
        while(i<n && j<n) { //왼쪽에서 오른쪽으로 대각선 계산
            sum+=array[i][j];
            i++;
            j++;
        }
        if(answer < sum) {
            answer = sum;
        }
        i=0; j=n-1;
        sum=0;
        while(i<n && j>0) { //오른쪽에서 왼쪽으로 대각선 계산
            sum+=array[i][j];
            i++;
            j--;
        }
        if(answer < sum) {
            answer = sum;
        }
        return answer;
    }
    public int solution2(int n , int[][] array) {
        //5
        //10 13 10 12 15
        //12 39 30 23 11
        //11 25 50 53 15
        //19 27 29 37 27
        //19 13 30 13 19
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int sum1 = 0, sum2=0;
            for(int j=0; j<n; j++) {
                sum1+=array[i][j];//행 계산
                sum2+=array[j][i];//열 계산
            }
            answer = Math.max(answer,sum1);
            answer = Math.max(answer,sum2);
        }
        int sum1 = 0, sum2=0;
        for(int i=0; i<n; i++) {
            sum1+=array[i][i];//왼쪽에서 오른쪽 대각선 계산
            sum2+=array[i][n-1-i];//오른쪽에서 왼쪽 대각선 계산
            answer = Math.max(answer,sum1);
            answer = Math.max(answer,sum2);
        }

        return answer;
    }

    public static void main(String[] args){
        Ex_0209 T = new Ex_0209();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        int[][] array = new int[i][i];
        for(int a=0; a<i; a++) {
            for(int c=0; c<i; c++) {
                array[a][c] = in.nextInt();
            }
        }
        System.out.print(T.solution2(i, array));
        return ;
    }
}
