package Java.InflearnAndLeetCode.Twopointers_SlidingWindow;

import java.util.Scanner;

public class Ex_0305 {
    //0304랑 문제 푸는 알고리즘이 똑같다 하지만 배열을 생성하고 자기자신을 빼주는것만 다르다.
    public int solution(int n) {
        //15
        int answer = 0, sum=0;
        int arr[] = new int[n-1];
        for(int i=0; i<n-1; i++) {
            arr[i]=i+1;
        }
        int lt = 0;
        for(int rt=0; rt<n-1; rt++) {
            sum+=arr[rt];
            if(sum==n) answer++;
            while(sum>=n) {
                sum-=arr[lt++];
                if(sum==n) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    public int solution2(int n) {//굳이 자기자신이 아닌 15라고하면 8+9만 해도 15가 넘는다. 자기자신을 나누기2 한것의 몫의 +1까지만 계산해줘도된다.
        //15
        int answer = 0, sum=0;
        int arr[] = new int[n-1];
        for(int i=0; i<n-1; i++) {
            arr[i]=i+1;
        }
        int lt = 0;
        for(int rt=0; rt<n/2+1; rt++) {
            sum+=arr[rt];
            if(sum==n) answer++;
            while(sum>=n) {
                sum-=arr[lt++];
                if(sum==n) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex_0305 T = new Ex_0305();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        System.out.print(T.solution2(n));
        return ;
    }
}
