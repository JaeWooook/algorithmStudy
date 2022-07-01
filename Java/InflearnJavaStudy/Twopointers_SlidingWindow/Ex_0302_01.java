package Java.InflearnJavaStudy.Twopointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex_0302_01 {//시간초과 발생
    public ArrayList<Integer> solution(int n , int m, int[] array1, int[] array2) {
        //5
        //1 3 9 5 2
        //5
        //3 2 5 7 8
        int[] tmp = new int[n+m];
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(array1[i] == array2[j]) {
                    tmp[i] = array1[i];
                    break;
                }
            }
        }
        Arrays.sort(tmp);
        for(int i=0; i<tmp.length; i++) {
            if(tmp[i]!=0) {
                answer.add(tmp[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0302_01 T = new Ex_0302_01();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        int[] arr1 = new int[i];
        for(int a=0; a<i; a++) {
            arr1[a] = in.nextInt();
        }
        int j = in.nextInt();
        int[] arr2 = new int[j];
        for(int b=0; b<j; b++) {
            arr2[b] = in.nextInt();
        }
        for(int x : T.solution(i,j, arr1, arr2)) {
            System.out.print(x+" ");
        }
        return ;
    }
}
