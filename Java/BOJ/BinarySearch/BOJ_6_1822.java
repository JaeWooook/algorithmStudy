package Java.BOJ.BinarySearch;
import java.io.*;
import java.util.*;

public class BOJ_6_1822 {

    public class Main {
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //Binary Search 기본문제 boj 1822
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr1 = readIntArray(n); // 1차원 배열 사용
            int[] arr2 = readIntArray(m); // 1차원 배열 사용

            /**
             * 1. 집합A와 B가있는데, A에 속하면서 집합 B에 속하지 않는 원소를 구해라
             * 2.
             *
             * 4 3
             * 2 5 11 7
             * 9 7 4
             *
             * 3
             * 2 5 11
             */
            List<Integer> result = new ArrayList<>();
            int cnt = 0;
            Arrays.sort(arr2);
            for(int i=0; i<arr1.length; i++) {
                if(Arrays.binarySearch(arr2, arr1[i]) <= -1) {
                    cnt++;
                    result.add(arr1[i]);
                }
            }
            Collections.sort(result);
            sb.append(cnt).append("\n");
            for(int i=0; i<result.size(); i++) {
                sb.append(result.get(i)).append(" ");
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
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
