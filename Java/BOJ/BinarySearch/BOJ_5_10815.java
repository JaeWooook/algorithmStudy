package Java.BOJ.BinarySearch;
import java.io.*;
import java.util.*;

public class BOJ_5_10815 {

    public static class Main {
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //Binary Search 기본문제 boj 10815
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            /**
             * 1. 첫째줄 상근이 가진 숫자카드, 두 숫자 카드에 같은수가 적힌 경우는 없다. (중복 없음)
             * 2. 상근이가 가지고 있는 숫자 카드인지 아닌지 구해야할 m개의 정수 배열
             *
             * 5
             * 6 3 2 10 -10
             * 8
             * 10 9 -5 2 3 4 5 -10
             */
            int n = readInt();
            int[] arr1 = readIntArray(n);
            int m = readInt();
            int[] arr2 = readIntArray(m);

            Arrays.sort(arr1);
            for(int i=0; i<arr2.length; i++) {
                if(Arrays.binarySearch(arr1, arr2[i]) > -1) {
                    sb.append(1).append(" ");
                } else {
                    sb.append(0).append(" ");
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
