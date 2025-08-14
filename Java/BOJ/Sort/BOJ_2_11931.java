package Java.BOJ.Sort;
import java.io.*;
import java.util.*;

public class BOJ_2_11931 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //정렬 기본문제 boj 11931
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[] arr1 = readIntLineByArray(n); // 1차원 배열 사용

            Integer[] transArr = new Integer[arr1.length];
            for(int i=0 ; i<arr1.length; i++) {
                transArr[i] = arr1[i];
            }
            Arrays.sort(transArr, Collections.reverseOrder());
            for (int num : transArr) sb.append(num).append("\n");

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
