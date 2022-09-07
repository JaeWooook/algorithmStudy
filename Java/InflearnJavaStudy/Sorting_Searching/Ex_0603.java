package Java.InflearnJavaStudy.Sorting_Searching;

import java.util.Scanner;

public class Ex_0603 {
    public int[] solution(int n, int[] arr) {

        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {// > 오름차순이고, < 내림차순이다.
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
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
