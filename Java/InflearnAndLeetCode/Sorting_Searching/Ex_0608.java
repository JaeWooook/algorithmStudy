package Java.InflearnAndLeetCode.Sorting_Searching;

import java.util.Scanner;

public class Ex_0608 {
    public int solution(int n, int m, int[] arr) {
        //8 32
        //23 87 65 12 57 32 99 81
        int answer = 0;
        for(int i=0; i<n-1; i++) {
            for(int j=i; j<n; j++) {
                if(arr[i]>arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i=0; i<n; i++) {
            if(arr[i] == m) {
                answer = i+1;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Ex_0608 T = new Ex_0608();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n,m,arr));
        return ;
    }
}
