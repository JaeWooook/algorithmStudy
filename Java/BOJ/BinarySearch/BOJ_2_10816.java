package Java.BOJ.BinarySearch;
import java.io.*;
import java.util.*;

public class BOJ_2_10816 {

    public static class Main {
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //Binary Search 연습문제 boj 10816
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            /**
             * 1. 첫째줄은 상근이의 카드의 개수, 둘째줄에는 숫자 카드에 적혀있는 정수가 주어진다.
             * 2. 넷째줄은 상근이가 몇개 가지고 있는 숫자 카드인지 구해야할 m개의 정수가 주어진다.
             *
             * 10
             * 6 3 2 10 10 10 -10 -10 7 3
             * 8
             * 10 9 -5 2 3 4 5 -10
             * -> 10이 3개고, .. 등등 개수새면된다.
             *
             * -10 2 3 3 6 7 10 10 10
             *
             * 3 0 0 1 2 0 0 2
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
                int target = arr2[i];

                while(st<en) {
                    if(arr1[mid] >= target) {
                        en = mid;
                    } else {
                        st = mid + 1;
                    }
                    mid = (st+en)/2;
                }

                int st2 = 0;
                int en2 = n;
                int mid2 = (st2+en2)/2;

                while(st2<en2) {
                    if(arr1[mid2] <= target) {
                        st2 = mid2 + 1;
                    } else {
                        en2 = mid2;
                    }
                    mid2 = (st2+en2)/2;
                }
                sb.append(en2-st).append(" ");
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
