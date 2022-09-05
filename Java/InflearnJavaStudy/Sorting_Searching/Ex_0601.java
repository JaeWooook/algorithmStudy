package Java.InflearnJavaStudy.Sorting_Searching;

import java.util.Scanner;

public class Ex_0601 {
    public int[] solution(int n, int[] arr) {
        //6
        //13 5 11 7 23 15
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args){
        Ex_0601 T = new Ex_0601();
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
