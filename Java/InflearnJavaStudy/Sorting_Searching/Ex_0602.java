package Java.InflearnJavaStudy.Sorting_Searching;

import java.util.Scanner;

public class Ex_0602 {
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

    //버블 정렬
    public int[] solution2(int n, int[] arr) {

        for(int i=0; i<n-1; i++) { //맨 끝에 까지는 돌필요가 없다. 어차피 정렬이되어 가장 마지막에는 큰수가 될것이다.
            for(int j=0; j<n-i-1; j++) { // i가 0일때 가장 마지막이 결정되고, i가 1일때 n-1번째가 결정된다. 즉, 하나씩 줄어드는 구조이기 때문에 i번째씩 끝에까지는 돌필요가 없다.
                if(arr[j] > arr[j+1]) { // > 오름차순이고 뒤에것이 더 작으면 바꿔준다., < 내림차순이다. 뒤에꺼가 더 크면 바꿔주는것이다.
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }
    public static void main(String[] args){
        Ex_0602 T = new Ex_0602();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        for(int x : T.solution2(n, arr)) {
            System.out.print(x+" ");
        }
        return ;
    }
}
