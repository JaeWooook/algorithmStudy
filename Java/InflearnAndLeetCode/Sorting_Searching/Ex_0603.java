package Java.InflearnAndLeetCode.Sorting_Searching;

import java.util.Scanner;

public class Ex_0603 {
    public int[] solution(int n, int[] arr) {
        //6
        //11 7 5 6 10 9
        int index=0;
        for(int i=1; i<n; i++) {
            int temp = arr[i];
            int prev = i-1;
            while( (prev >= 0) && (arr[prev] > temp)) {// > 이게 오름차순, < 이거는 내림차순이다.
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = temp;
        }
        return arr;
    }
    public static void main(String[] args){
        Ex_0603 T = new Ex_0603();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        for(int x : T.solution(n, arr)) {
            System.out.print(x+" ");
        }
        return ;
    }
}
