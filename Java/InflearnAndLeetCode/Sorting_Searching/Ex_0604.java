package Java.InflearnAndLeetCode.Sorting_Searching;

import java.util.Scanner;

public class Ex_0604 {
    public int[] solution(int m, int n, int[] arr) { //오답
        //5 9
        //1 2 3 2 6 2 3 5 7
        //10 50
        //24 7 50 3 1 11 26 1 27 44 16 21 48 36 37 43 49 9 28 5 10 34 36 32 3 17 40 21 5 22 48 46 27 2 30 14 41 45 35 41 16 33 36 7 19 36 45 26 9 14
        int[] answer = new int[m];
        //answer가 전부 0이 아니면, 넣을값이 있는지 찾고, 있으면 가장 앞으로 땡기고 나머지 뒤로 밀어주고
        //없으면 가장 마지막 삭제하고 나머지 한칸씩 미루고, 맨 앞에 넣는다.
        for(int x : arr) {
            int pos = -1;
            for(int i=0; i<m; i++) if(x==answer[i]) pos=i;
            if(pos != -1) {
                answer[pos] = 0;
                for(int i=m-2; i>=0; i--) {
                    if(answer[i]!=0) {
                        answer[i+1] = answer[i];
                    }
                }
                answer[0] = x;
            } else {
                for(int i=m-2; i>=0; i--) {
                    if(answer[i]!=0) {
                        answer[i+1] = answer[i];
                    }
                }
                answer[0] = x;
            }
        }
        return answer;
    }

    public int[] solution2(int size, int n, int[] arr) {
        int[] cache = new int[size];
        for(int x : arr) {
            int pos = -1;
            for(int i=0; i<size; i++ ) if(x==cache[i]) pos = i;
            if(pos==-1) {
                for(int i=size-1; i>=1; i--) {
                    cache[i] = cache[i-1];
                }
            } else {
                for(int i=size-1; i>=1; i--) {
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = x;
        }

        return cache;
    }
    public static void main(String[] args){
        Ex_0604 T = new Ex_0604();
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        for(int x : T.solution(m, n, arr)) {
            System.out.print(x+" ");
        }
        return ;
    }
}
