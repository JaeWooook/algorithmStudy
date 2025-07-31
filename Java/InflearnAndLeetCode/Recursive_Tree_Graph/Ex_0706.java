package Java.InflearnAndLeetCode.Recursive_Tree_Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_0706 {
    public void solution(int[] arr, int idx, boolean[] select) {//subset 부분집합 방법
        //3
        if(idx == arr.length) {//idx가 length만큼이면 끝까지 탐색했다는 뜻으로 select배열을 이용해서 뽑은것들을 호출한다.
            for(int i=-0; i<select.length; i++) {
                if(select[i]) {
                    System.out.print(arr[i]+ " ");
                }
            }
            System.out.println("");
            return;
        }

        // 현재 인덱스를 선택하고, 다음 인덱스로 재귀를 타거나, 현재 인덱스를 선택하지 않고, 다음 인덱스로 재귀를 타는 두가지 경우를 모두 탐색한다.
        select[idx] = true; // 선택 O
        solution(arr, idx+1, select); // 다음 인덱스 재귀
        select[idx] = false; // 선택 X
        solution(arr, idx+1, select); // 다음 인덱스 재귀
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
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        T.solution(arr, 0, visited);
//        T.solution2(arr);
        return ;
    }
}
