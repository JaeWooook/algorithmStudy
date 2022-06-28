package Java.InflearnJavaStudy.Array;

import java.util.Scanner;

public class Ex_0212 {
    public int solution(int n ,int m, int[][] array) {
        //4 3
        //3 4 1 2
        //4 3 2 1
        //3 1 4 2
        int answer = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                int cnt = 0;
                for(int k=0; k<m; k++) {
                    int pi = 0;
                    int pj = 0;
                    for(int s=0; s<n; s++) {
                        if(array[k][s] == i) {
                            pi = s;
                        }
                        if(array[k][s] == j) {
                            pj = s;
                        }
                    }
                    if(pi < pj) {
                        cnt++;
                    }
                }
                if(cnt == m) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0212 T = new Ex_0212();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int[][] array = new int[j][i];
        for(int a=0; a<j; a++) {
            for(int b=0; b<i; b++) {
                array[a][b] = in.nextInt();
            }
        }
        System.out.print(T.solution(i,j, array));
        return ;
    }
}
