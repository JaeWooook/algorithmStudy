package Java.InflearnJavaStudy.Twopointers_SlidingWindow;

import java.util.Scanner;

public class Ex_0304_03 {
    public int solution(int n , int k, int[] arr) { //정답
        //8 6
        //1 2 1 3 1 1 1 2
        int answer = 0, sum=0;
        int lt=0;
        for(int rt=0; rt<n; rt++) {
            sum+=arr[rt];
            if(sum==k) {
                answer++;
            }
            while(sum>=k) {
                sum-=arr[lt++]; //lt가 빼고 증가되는 수순이다. lt++;을 또 안쓰기위함
                if(sum==k) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex_0304_03 T = new Ex_0304_03();
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
