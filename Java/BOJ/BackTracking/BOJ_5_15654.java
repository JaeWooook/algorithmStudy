package Java.BOJ.BackTracking;
import java.io.*;
import java.util.*;

public class BOJ_5_15654 {

    public static class Main {
        static boolean[] visited = new boolean[10001];
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //backtracking 기본문제 boj 15654
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr1 = readIntArray(n); // 1차원 배열 사용

            /**
             * 1. 첫째줄에 N과M이 주어진다.
             * 2. 오름차순, 먼저 정렬을하고, 중복출력하면안된다.
             *
             * 4 2
             * 9 8 7 1
             *
             * 1 7
             * 1 8
             * 1 9
             * 7 1
             * 7 8
             * 7 9
             * 8 1
             * 8 7
             * 8 9
             * 9 1
             * 9 7
             * 9 8
             */
            int[] arr = new int[m];
            Arrays.sort(arr1);
            dfs(0, n, m, sb, arr, arr1);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void dfs(int depth, int n, int m, StringBuilder sb, int[] arr, int[] sorted) {
            if(depth == m) {
                for(int i=0; i<m; i++) {
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
                return;
            }

            for(int i=0; i<n; i++) {
                if(visited[sorted[i]]) continue;
                visited[sorted[i]] = true;
                arr[depth] = sorted[i];
                dfs(depth+1, n, m, sb, arr, sorted);
                visited[sorted[i]] = false;
            }
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
