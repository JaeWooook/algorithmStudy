package Java.InflearnJavaStudy.Twopointers_SlidingWindow;

import java.util.Scanner;

public class Ex_0306 {
    public int solution(int n, int m, int[] arr) {
        //14 2
        //1 1 0 0 1 1 0 1 1 0 1 1 0 1
        int answer = 0, sum = 0, cnt = 0;
        int lt = 0;
//        for(int rt = 0; rt<n; rt++) {
//            if(arr[rt]==0) {
//                cnt++;
//            }
//            if(cnt == m) {
//
//            }
//        }
        int rt=0;
        while(rt<n) {
            if(arr[rt]==0) {
                cnt++;
            }
            rt++;
            if(cnt == m) {
                if(arr[rt]==0) {
                    cnt=0;
                    lt++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex_0306 T = new Ex_0306();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n,m, arr));
        return ;
    }
}
