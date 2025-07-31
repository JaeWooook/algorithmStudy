package Java.InflearnAndLeetCode.Sorting_Searching;

import java.util.Scanner;

public class Ex_0605 {
    public char solution(int n, int[] arr) {
        //8
        //20 25 52 30 39 33 43 33
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(arr[i] == arr[j]) {
                    return 'D';
                }
            }
        }

        return 'U';
    }
    public static void main(String[] args){
        Ex_0605 T = new Ex_0605();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n,arr));
        return ;
    }
}
