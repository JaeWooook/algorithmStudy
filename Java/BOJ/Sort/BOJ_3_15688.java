package Java.BOJ.Sort;
import java.io.*;
import java.util.*;

public class BOJ_3_15688 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //정렬 기본문제 boj 15688
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용

            int[] arr1 = readIntLineByArray(n); // 1차원 배열 사용

            Arrays.sort(arr1);

            for (int num : arr1) sb.append(num).append("\n");
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static int[] readIntLineByArray(int size) throws IOException {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            return arr;
        }
    }
}
