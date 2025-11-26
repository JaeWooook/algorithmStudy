package Java.BOJ.BackTracking;
import java.io.*;
import java.util.*;

public class BOJ_3_15651 {

    public static class Main {
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //backtracking 기본문제 boj 15651
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            /**
             * 1.자연수 N과 M이 잇을때 1부터 N까지 자연수중에서 중복없이 M개를 고른 수열
             * 2.여러번 골라도 된다.
             *
             * 4 2
             *
             * 1 1
             * 1 2
             * 1 3
             * 1 4
             * 2 1
             * 2 2
             * 2 3
             * 2 4
             * 3 1
             * 3 2
             * 3 3
             * 3 4
             * 4 1
             * 4 2
             * 4 3
             * 4 4
             */
            int[] arr = new int[m];
            dfs(0, n, m, sb, arr);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void dfs(int depth, int n, int m, StringBuilder sb, int[] arr) {
            if(depth == m) {
                for(int i=0; i<m; i++) {
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
                return;
            }

            for(int i=1; i<=n; i++) {
                arr[depth] = i;
                dfs(depth+1, n, m, sb, arr);
            }
        }
    }
}
