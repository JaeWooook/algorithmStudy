package Java.BOJ.Exhaustive_Search.Brute_Force;
import java.io.*;
import java.util.*;

public class BOJ_13_14620 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;
        static int min = Integer.MAX_VALUE;
        static boolean[][] visited = new boolean[10][10];

        public static void main(String[] args) throws IOException {
            //브루드포스 기본문제 boj 14620
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[][] arr2 = readInt2DArray(n, n); // 2차원 배열
            /**
             * 1.각 화단의 가격이고 꽃은 3개이다. 3개를 가장싼곳에 심을수 있는 땅을 찾아야한다.
             * 2.가격적인 측면에서 합한 곳의 구역이 가장 싼곳을 min으로 한다.
             * 3.각각 3개의 땅을 찾아야한다. 그 3개를 depth로 생각하고 돌린다.
             * 4.최소 땅의 크기는 6이다. 첫줄은 배제한채로 거의 row1과 col1에서 시작한다고 생각하면된다.
             * 5.바운더리를 정해야한다 시작은 1이고 종료는 length-1까지 해야 한다.
             * 6.depth가 넘어갈때는 이전에 찾은것에 대해서는 하지않도록 visited를 체크한다.
             *
             * 6
             * 1 0 2 3 3 4
             * 1 1 1 1 1 1
             * 0 0 1 1 1 1
             * 3 9 9 0 1 99
             * 9 11 3 1 0 3
             * 12 3 0 0 0 1
             */
            int[] comb = new int[3];

            dfs(arr2, 0, 3, n,comb);
            sb.append(min);

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void dfs(int[][] arr2, int depth, int k, int n, int[] comb) {
            if(depth == k) {
                int result = 0;
                for(int i=0; i<k; i++) {
                    result += comb[i];
                }
                min = Math.min(result, min);

                return;
            }

            for(int i=1; i<n-1; i++) {
                for(int j=1; j<n-1; j++) {
                    if(!visited[i][j] && !visited[i][j-1] && !visited[i][j+1] && !visited[i-1][j] && !visited[i+1][j]) {
                        visited[i][j] = true;
                        visited[i][j-1] = true;
                        visited[i][j+1] = true;
                        visited[i-1][j] = true;
                        visited[i+1][j] = true;
                        comb[depth] = arr2[i][j] + arr2[i][j-1] + arr2[i][j+1] + arr2[i-1][j] + arr2[i+1][j];
                        dfs(arr2, depth+1, k, n, comb);
                        visited[i][j] = false;
                        visited[i][j-1] = false;
                        visited[i][j+1] = false;
                        visited[i-1][j] = false;
                        visited[i+1][j] = false;
                    }
                }
            }
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
