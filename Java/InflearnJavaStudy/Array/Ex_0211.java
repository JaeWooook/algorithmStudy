package Java.InflearnJavaStudy.Array;

import java.util.Scanner;

public class Ex_0211 {
    public int solution(int n , int[][] array) {
        //5
        //2 3 1 7 3
        //4 1 9 6 8
        //5 5 2 4 4
        //6 5 2 6 7
        //8 4 2 2 2
        int answer = 0;
        int maxValue=0;
        int[][] checkMany = new int[n][5];
        for(int i=0; i<n; i++) {
            int cnt = 0;
            for(int j=0; j<n; j++) {
                for(int k=0; k<5; k++) {
                    if(array[i][k] == array[j][k]) {
                        cnt++;
                        break;//브레이크를 해주는 이유는 같은반인 학생을 한번만 찾으면 되기 때문이다.
                        //중복해서 카운팅 하면 안되기 때문에 break를 반드시 해줘야한다.
                    }
                }
            }
            if(cnt>maxValue) {
                maxValue = cnt;
                answer=i+1;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0211 T = new Ex_0211();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        int[][] array = new int[i][5];
        for(int a=0; a<i; a++) {
            for(int c=0; c<5; c++) {
                array[a][c] = in.nextInt();
            }
        }
        System.out.print(T.solution(i, array));
        return ;
    }
}
