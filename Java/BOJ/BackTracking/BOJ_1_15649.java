package Java.BOJ.BackTracking;
import java.io.*;
import java.util.*;

public class BOJ_1_15649 {

    public static class Main {
        static boolean[] visited = new boolean[9];

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //backtracking 연습문제 boj 15649
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            /**
             * 1. N과 M이 주어질 때
             * 2. 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 이다.
             * 3. 백트레킹은 어찌보면 조합이나 순열? 같은것 이다. 순차적으로 뽑기만하면된다.
             *
             * 3 1
             *
             * 4 2
             */

            int[] arr = new int[m];
            dfs(sb, 0, arr, m, n);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
        static void dfs(StringBuilder sb, int depth, int[] arr, int m, int n) {
            if(depth == m) {
                for(int i=0; i<m; i++) {
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
                return;
            }

            for(int i=1; i<=n; i++) {
                if(visited[i]) continue;
                arr[depth] = i;
                visited[i] = true;
                dfs(sb, depth+1, arr, m, n);
                visited[i] = false;
            }
        }
    }
}
