package Java.InflearnAndLeetCode.HashMap_TreeSet;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Ex_0405 {
    public int solution(int n, int k, int[] arr) {
        //10 3
        //13 15 34 23 45 65 33 11 26 42
        int answer = -1;
        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int p=j+1; p<n; p++) {
                    tSet.add(arr[i]+arr[j]+arr[p]);//이렇게 해서 3가지를 뽑는 경우의수를 모두 더한다.
                }
            }
        }
        int cnt = 0;
        for(int x : tSet) {
            cnt++;
            if(cnt == k) {
                return x;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex_0405 T = new Ex_0405();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n, k, arr));
        return ;
    }
}
