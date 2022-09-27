package Java.InflearnJavaStudy.Recursive_Tree_Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_0706 {
    public void solution(int[] arr, int idx, int[] select, int sidx) {//오답
        //3
        if(idx == arr.length) {
            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0; i< sidx; i++) {
                list.add(select[i]);
            }
            System.out.println(list);
            return;
        }

        solution(arr, idx+1, select, sidx);
        select[sidx] = arr[idx];
        solution(arr, idx+1, select, sidx+1);
    }

    public void solution2(int[] arr) {//Bitmask 사용
        //3
        for(int i=0; i<1 << arr.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0; j<arr.length; j++) {
                if((i&1<<j)!=0) {
                    list.add(arr[j]);
                }
            }
            System.out.println(list);
        }
    }

    public static void main(String[] args){
        Ex_0706 T = new Ex_0706();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] visited = new int[n+1];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }
//        T.solution(arr, 0, visited, n);
        T.solution2(arr);
        return ;
    }
}
