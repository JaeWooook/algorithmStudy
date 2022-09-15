package Java.InflearnJavaStudy.Sorting_Searching;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_0606 {
    public ArrayList<Integer> solution(int n, int[] arr) {
        //9
        //120 125 152 130 135 135 143 127 160
        ArrayList<Integer> answer = new ArrayList<>();
        int[] temp = new int[n];
        for(int i=0; i<n; i++) {
            temp[i] = arr[i];
        }
        for(int i=0; i<n-1; i++) {
            for(int j=i; j<n; j++) {
                if(temp[i] > temp[j]) {
                    int tmp = temp[i];
                    temp[i] = temp[j];
                    temp[j] = tmp;
                }
            }
        }
        for(int i=0; i<n; i++) {
            if(temp[i] != arr[i]) {
                answer.add(i+1);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Ex_0606 T = new Ex_0606();
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
