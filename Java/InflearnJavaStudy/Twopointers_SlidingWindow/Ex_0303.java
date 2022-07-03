package Java.InflearnJavaStudy.Twopointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Sliding Window
public class Ex_0303 {
    //오답 타임아웃이다..
    public int solution(int n , int k, int[] arr) {//time out 나옴..
        //10 3
        //12 15 11 20 25 10 20 19 13 15
        int answer = Integer.MIN_VALUE;
        int sum = 0;
        int i=0, cnt=0, save=0;
        boolean flag = true;
        while(i<n) {
            sum+=arr[i];
            i++; cnt++;
            if(flag == true) {
                flag=false;
                save=i;
            }
            if(cnt==k) {
                if(answer < sum) {
                    answer = sum;
                }
                sum=0;
                cnt=0;
                i=save;
                flag=true;
            }
        }
        return answer;
    }
//정답 보고한것
    public int solution2(int n , int k, int[] arr) {//정답
        //10 3
        //12 15 11 20 25 10 20 19 13 15
        int answer = 0;
        int sum = 0;
        for(int i=0; i<k; i++) {
            sum+=arr[i];
        }
        answer = sum;
        for(int i=k; i<n; i++) {
            sum+=arr[i];
            sum-=arr[i-k];
            if(sum>answer) {
                answer = sum;
            }
        }
        return answer;
    }
    
    public static void main(String[] args){
        Ex_0303 T = new Ex_0303();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution2(n,k,arr));
        return ;
    }
}
