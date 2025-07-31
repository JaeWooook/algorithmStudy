package Java.InflearnAndLeetCode.Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_0609 {
    public int solution(int n, int m, int[] arr) {
        //9 3
        //1 2 3 4 5 6 7 8 9
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt(); //해당 배열에서 가장 큰수 찾아주는것
        int rt = Arrays.stream(arr).sum(); // 해당 배열을 전부 합한것

        while(lt<=rt) {
            int mid = (lt+rt)/2; //dvd한장의 용량이다.

            if(count(arr, mid)<=m) {//리턴한 dvd장수가 m보다 작거나 같으면 만족하는 용량이다.
                answer = mid;
                rt = mid-1;
            }
            else {//lt가 rt보다 커지면 멈추면된다.
                lt = mid+1;
            }
        }

        return answer;
    }

    public int count(int[] arr, int capacity) {
        int cnt  = 1; //dvd장수
        int sum = 0; //dvd의 곡들의 합
        for(int x : arr) {
            if(sum+x > capacity) {
                cnt++;
                sum=x;
            } else {
                sum+=x;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        Ex_0609 T = new Ex_0609();
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
