package Java.InflearnJavaStudy.Twopointers_SlidingWindow;

import java.util.Scanner;

public class Ex_0301 {
    public int[] solution(int n ,int m, int[] array1, int[] array2) {
        //3
        //1 3 5
        //5
        //2 3 6 7 9
        int[] answer = new int[n+m];
        int i=0, j=0, cnt=0;
        while(i<n && j<m) {//짧은쪽까지는 비교하면서 계산한다.
            if(array1[i] < array2[j]) {
                answer[cnt] = array1[i];
                i++;
                cnt++;
            } else if(array1[i] > array2[j]) {
                answer[cnt] = array2[j];
                j++;
                cnt++;
            } else if(array1[i] == array2[j] ) {
                answer[cnt] = array1[i];
                cnt++;
                answer[cnt] = array2[j];
                cnt++;
                i++; j++;
            }
        }
        if(i<n) {//마지막에 남은 부분을 그대로 넣어준다.
            for(int a=i; a<n; a++) {
                answer[cnt]=array1[a];
                cnt++;
            }
        } else if(j<m) {
            for(int b=j; b<m; b++) {
                answer[cnt]=array2[b];
                cnt++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex_0301 T = new Ex_0301();
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
