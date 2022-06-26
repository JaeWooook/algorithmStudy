package Java.InflearnJavaStudy.Array;

import java.util.Scanner;

public class Ex_0208 {
    public int[] solution(int n , int[] array) {
        //5
        //87 89 92 100 76
        int[] answer = new int[n];
        int cnt = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(array[i] < array[j]) {
                    cnt++;
                }
            }
            answer[i]=cnt;
            cnt=1;
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0208 T = new Ex_0208();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        int[] array = new int[i];
        for(int a=0; a<i; a++) {
            array[a] = in.nextInt();
        }
        for(int b : T.solution(i, array)) {
            System.out.print(b+" ");
        }
        return ;
    }
}
