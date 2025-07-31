package Java.InflearnAndLeetCode.Twopointers_SlidingWindow;

import java.util.Scanner;

public class Ex_0304_01 {
    //오답..
    public int solution(int n , int k, int[] arr) { //time out..
        //8 6
        //1 2 1 3 1 1 1 2
        int answer = 0, sum=0;
        for(int i=1; i<+n; i++) {
            for(int j=0; j<i; j++) {
                sum+=arr[j];
            }
            if(sum == k) {
                answer++;
            }
            for(int j=i; j<n; j++) {
                sum+=arr[j];
                sum-=arr[j-i];
                if(sum == k) {
                    answer++;
                }
            }
            sum=0;
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0304_01 T = new Ex_0304_01();
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
