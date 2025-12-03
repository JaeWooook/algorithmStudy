package Java.BOJ.BinarySearch;
import java.io.*;
import java.util.*;

public class BOJ_1_1920 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //Binary Search 연습문제 boj 1920
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            /**
             * 1. n개의 정수가 배열 1~n까지 주어졌을때 이 안에 X라는 정수가 존재하는지 알아내는 프로그램
             * 2. 존재하면 1 아니면 0이다.
             *
             * 5
             * 4 1 5 2 3
             * 5
             * 1 3 7 9 5
             *
             * 9 -> 9/2 -> 4야 그럼 4보다 크냐 햇을때 2지 근데 6을 봐야해
             *
             * 1
             * 1
             * 0
             * 0
             * 1
             *
             * 4
             * -1 8 4 -1
             * 2
             * 3 4
             *
             * 0
             * 1
             */
            int n = readInt();
            int[] arr1 = readIntArray(n);

            int m = readInt();
            int[] arr2 = readIntArray(m);
            Arrays.sort(arr1);

            for(int i=0; i<m; i++) {
                int st = 0;
                int en = n;
                int mid = (st+en)/2;
                boolean find = false;
                int target = arr2[i];
                while(st<=en) {
                    if(mid < 0 || mid >= n) {
                        break;
                    }

                    if(arr1[mid] > target) {
                        en = mid-1;
                    } else if(arr1[mid] < target) {
                        st = mid+1;
                    } else {
                        find = true;
                        break;
                    }
                    mid = (st+en)/2;
                }
                if(find) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static int[] readIntArray(int size) throws IOException {//한칸씩 띄어쓰기 되어있는것
            int[] arr = new int[size];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            return arr;
        }
    }
}
