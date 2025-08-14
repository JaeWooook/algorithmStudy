package Java.BOJ.Sort;
import java.io.*;
import java.util.*;

public class BOJ_4_10814 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //정렬 기본문제 boj 10814
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용

            String[][] strArr2D = readString2DArray(n, 2); // 2차원 문자열 배열 사용
            /**
             * TreeMap으로 받으면 key값으로 알아서 오름차순 정렬된다.
             * 3
             * 21 Junkyu
             * 21 Dohyun
             * 20 Sunyoung
             */
            //복잡한 방법
            Arrays.sort(strArr2D, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    int o1Int = Integer.parseInt(o1[0]);
                    int o2Int = Integer.parseInt(o2[0]);
                    return o1Int - o2Int;
                }
            });

            //좀더 간단한 방법
            Arrays.sort(strArr2D, (a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    sb.append(strArr2D[i][j]).append(" ");
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        // ===== 입력 메서드들 =====
        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static String[][] readString2DArray(int rows, int cols) throws IOException {
            String[][] arr = new String[rows][cols];
            for (int i = 0; i < rows; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = st.nextToken();
                }
            }
            return arr;
        }
    }
}
