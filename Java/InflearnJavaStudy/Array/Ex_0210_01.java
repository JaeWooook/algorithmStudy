package Java.InflearnJavaStudy.Array;

import java.util.Scanner;

public class Ex_0210_01 {//예외상황을 모두 처리하지못한 오답이다. Ex_0210_02가 정답이다.
    public int solution(int n , int[][] array) {//0이라는 안전장치를 넣지않고 만든다.
        //5
        //5 3 7 2 3
        //3 7 1 6 1
        //7 2 5 3 4
        //4 3 6 4 1
        //8 7 3 5 2
        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; i<n; j++) {
                if(i!=0 && j!=0 && i!=n-1 && j!=n-1) {//일반적인 케이스 모서리가 아닐때
                    int comp  = Math.max(array[i-1][j], array[i][j]);
                    comp = Math.max(comp, array[i][j+1]);
                    comp = Math.max(comp, array[i+1][j]);
                    comp = Math.max(comp, array[i-1][j]);
                    if(comp==array[i][j]) {
                        answer++;
                    }
                }else {//모서리일때
                    int comp=0;
                    if(i==0 && j==0) { //가장 상단 왼쪽
                        comp=Math.max(array[i][j],array[i][j+1]);
                        comp=Math.max(comp,array[i+1][j]);

                    } else if(i==n-1 && j==0) { //가장 하단 왼쪽
                        comp=Math.max(array[i][j],array[i+1][j]);
                        comp=Math.max(comp,array[i][j+1]);

                    } else if(j==0 && i!=0 && i!=n-1) { //가장 왼쪽 모서리들 벽면
                        comp=Math.max(array[i][j],array[i+1][j]);
                        comp=Math.max(comp,array[i][j+1]);
                        comp=Math.max(comp,array[i-1][j]);

                    } else if(i==0 && j==n-1) { // 가장 상단 오른쪽
                        comp=Math.max(array[i][j],array[i][j-1]);
                        comp=Math.max(comp,array[i+1][j]);

                    } else if(i==n-1 && j==n-1) { // 가장 하단 오른쪽
                        comp=Math.max(array[i][j],array[i+1][j]);
                        comp=Math.max(comp,array[i][j-1]);

                    } else if(j==n-1 && i!=n-1 && i!=0) { //가장 오른쪽 모서리들 벽면
                        comp=Math.max(array[i][j],array[i+1][j]);
                        comp=Math.max(comp,array[i][j-1]);
                        comp=Math.max(comp,array[i-1][j]);

                    } else if(i==0 && j!=0 && j!=n-1) { // 가장 상단 윗쪽 모서리들 벽면
                        comp=Math.max(array[i][j],array[i][j-1]);
                        comp=Math.max(comp,array[i][j+1]);
                        comp=Math.max(comp,array[i-1][j]);

                    } else if(i==n-1 && j!=0 && j!=n-1) { // 가장 상단 아래쪽 모서리들 벽면
                        comp=Math.max(array[i][j],array[i+1][j]);
                        comp=Math.max(comp,array[i][j-1]);
                        comp=Math.max(comp,array[i][j+1]);
                    }

                    if(comp==array[i][j]) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0210_01 T = new Ex_0210_01();
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
