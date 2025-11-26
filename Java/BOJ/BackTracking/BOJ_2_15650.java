package Java.BOJ.BackTracking;
import java.io.*;
import java.util.*;

public class BOJ_2_15650 {

    public static class Main {
        static boolean[] visited = new boolean[9];
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //backtracking 기본문제 boj 15650
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            /**
             * 1. 자연수 N과 M이 잇을때 1부터 N까지 자연수중에서 중복없이 M개를 고른 수열
             * 2. 오름차순
             * 3. 그래프 까지는 이해했는데 1밑에 2 2밑에 34라면 이 3 4가 각 노드의 끝인지는 어떻게 증명 하나?
             * 4. 출력은또 어떻게.. 현재 노드까지 없는것만 넣는거라는건 좀 이해 했다.
             *
             * 4 2
             *
             * 1 2
             * 1 3
             * 1 4
             * 2 3
             * 2 4
             * 3 4
             */
            int[] arr = new int[m];
            dfs(0, n, m, sb, arr, 1);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void dfs(int depth, int n, int m, StringBuilder sb, int[] arr, int st) {
            if(depth == m) {
                for(int i=0; i<m; i++) {
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
                return;
            }

            for(int i=st; i<=n; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                arr[depth] = i;
                dfs(depth+1, n, m, sb, arr, i+1);
                visited[i] = false;
            }
        }
    }
}
