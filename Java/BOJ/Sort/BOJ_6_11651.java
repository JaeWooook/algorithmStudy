package Java.BOJ.Sort;
import java.io.*;
import java.util.*;

public class BOJ_6_11651 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //정렬 기본문제 boj 11651
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[][] arr2 = readInt2DArray(n, 2); // 2차원 배열

            /**
             * 동일하다 뒤에 조건보는것같다.
             */
            Arrays.sort(arr2, (a,b) -> {
                if(a[1] != b[1])  return a[1] - b[1];
                return a[0] - b[0];
            });

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    sb.append(arr2[i][j]).append(" ");
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static int[][] readInt2DArray(int rows, int cols) throws IOException {
            int[][] arr = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            return arr;
        }
    }
}
