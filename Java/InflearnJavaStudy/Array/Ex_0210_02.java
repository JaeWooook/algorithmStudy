package Java.InflearnJavaStudy.Array;

import java.util.Scanner;

public class Ex_0210_02 {
    public int solution(int n , int[][] array) {
        //5
        //5 3 7 2 3
        //3 7 1 6 1
        //7 2 5 3 4
        //4 3 6 4 1
        //8 7 3 5 2
        int answer = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                boolean flag = true;
                for(int k=0; k<4; k++) {
                    int ny=i+dy[k];
                    int nx=j+dx[k];
                    if(nx>=0 && nx<n && ny>=0 && ny<n && array[ny][nx]>= array[i][j]) {
                        flag=false;
                        break;
                    }
                }
                if(flag==true) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0210_02 T = new Ex_0210_02();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        int[][] array = new int[i][i];
        for(int a=0; a<i; a++) {
            for(int c=0; c<i; c++) {
                array[a][c] = in.nextInt();
            }
        }
        System.out.print(T.solution(i, array));
        return ;
    }
}
