package Java.InflearnJavaStudy.Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_0610 {
    public int solution(int n, int m, int[] arr) {
        //5 3
        //1 2 8 4 9
        int answer = 0;
        Arrays.sort(arr);//오름차순 정렬 사용

        int lt = 1;
        int rt = arr[n-1];
        while(lt<=rt) {
            int mid = (lt+rt)/2;
            if(count(arr, mid) >= m) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    public int count(int[] arr, int capacity) {
        int ep  = arr[0]; // endpoisition 가장 최근에 말을 배치한곳의 인덱스
        int cnt = 1; // 배치한 말의 개수 처음에 한마리는 배치하기 때문에 무조건 1이된다.
        for(int i=1; i<arr.length; i++) {
            if(arr[i] - ep >= capacity) {
                ep = arr[i];
                cnt++;//배치한 말의 개수를 리턴한다.
            }
        }

        return cnt;
    }

    public static void main(String[] args){
        Ex_0610 T = new Ex_0610();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n,m,arr));
        return ;
    }
}
