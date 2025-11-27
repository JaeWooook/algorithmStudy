package Java.BOJ.BackTracking;
import java.io.*;
import java.util.*;

public class BOJ_6_6603 {

    public static class Main {
        static boolean[] visited = new boolean[47];
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //backtracking 기본문제 boj 6603
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            /**
             * 1. 1,2,...~,49 에서 수 6개를 고른다.
             * 2. 49가지수 중 k > 6개 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.
             * 3. 입력은 0이 나올때까지 출력이다.
             * 4. 중복된 경우는 제외한다.
             *
             * 7 1 2 3 4 5 6 7
             * 8 1 2 3 5 8 13 21 34
             * 0
             *
             * 1 2 3 4 5 6
             * 1 2 3 4 5 7
             * 1 2 3 4 6 7
             * 1 2 3 5 6 7
             * 1 2 4 5 6 7
             * 1 3 4 5 6 7
             * 2 3 4 5 6 7
             *
             * 1 2 3 5 8 13
             * 1 2 3 5 8 21
             * 1 2 3 5 8 34
             * 1 2 3 5 13 21
             * 1 2 3 5 13 34
             * 1 2 3 5 21 34
             * 1 2 3 8 13 21
             * 1 2 3 8 13 34
             * 1 2 3 8 21 34
             * 1 2 3 13 21 34
             * 1 2 5 8 13 21
             * 1 2 5 8 13 34
             * 1 2 5 8 21 34
             * 1 2 5 13 21 34
             * 1 2 8 13 21 34
             * 1 3 5 8 13 21
             * 1 3 5 8 13 34
             * 1 3 5 8 21 34
             * 1 3 5 13 21 34
             * 1 3 8 13 21 34
             * 1 5 8 13 21 34
             * 2 3 5 8 13 21
             * 2 3 5 8 13 34
             * 2 3 5 8 21 34
             * 2 3 5 13 21 34
             * 2 3 8 13 21 34
             * 2 5 8 13 21 34
             * 3 5 8 13 21 34
             */
            while(true) {
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());

                if(k == 0) break;

                int[] s = new int[k];
                for (int i = 0; i < k; i++) {
                    s[i] = Integer.parseInt(st.nextToken());
                }
                int[] arr1 = new int[6];
                Arrays.sort(s);
                dfs(0, k, 6, sb, arr1, s, 0);
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void dfs(int depth, int n, int m, StringBuilder sb, int[] arr, int[] sorted, int st) {
            if(depth == m) {
                for(int i=0; i<m; i++) {
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
                return;
            }

            for(int i=st; i<n; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                arr[depth] = sorted[i];
                dfs(depth+1, n, m, sb, arr, sorted, i+1);
                visited[i] = false;
            }
        }
    }
}
