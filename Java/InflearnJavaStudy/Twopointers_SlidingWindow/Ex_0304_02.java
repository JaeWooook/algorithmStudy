package Java.InflearnJavaStudy.Twopointers_SlidingWindow;

import java.util.Scanner;

public class Ex_0304_02 {
    public int solution(int n , int k, int[] arr) { //오답이다.
        //8 6
        //1 2 1 3 1 1 1 2
        int answer = 0, sum=0;
        int lt=0, rt=1;
        sum+=arr[lt];
        while(rt<n && lt<rt) {
            if(sum==k) {
                answer++;
                sum+=arr[rt];
                rt++;
            } else if(sum<k) {
                sum+=arr[rt];
                rt++;
            } else {
                sum-=arr[lt];
                lt++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex_0304_02 T = new Ex_0304_02();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n,k,arr));
        return ;
    }
}
