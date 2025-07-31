package Java.InflearnAndLeetCode.Twopointers_SlidingWindow;

import java.util.Scanner;

public class Ex_0306 {
    public int solution(int n, int m, int[] arr) {
        //14 2
        //1 1 0 0 1 1 0 1 1 0 1 1 0 1
        int answer = 0, rt=0;
        for(int lt=0; lt<arr.length; lt++) {
            rt=lt;
            int cnt=0;
            while(cnt<=m && rt<arr.length) {
                if(arr[rt]==0) {
                    cnt++;
                }
                if(cnt>m) {
                    break;
                }
                if(answer<rt-lt+1) {
                    answer=rt-lt+1;
                }
                rt++;
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
