package Java.BOJ.Exhaustive_Search.Brute_Force;
import java.io.*;
import java.util.*;

public class BOJ_11_16439 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;
        static int max = 0;
        static int cnt = 0;
        static boolean[] visited = new boolean[30];
        static boolean[] duplicated = new boolean[99999999];

        public static void main(String[] args) throws IOException {
            //브루드포스 기본문제 boj 16439
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr2 = readInt2DArray(n, m); // 2차원 배열
            /**
             * 1. 각 치킨의 만족도 조사이다 시간이오래걸리기 때문에 최대 3가지 만 주문하며,
             * 2. 최대값이 되는 값을 출력
             * 3. 각 치킨의 종류에서 3개를 고른다. 거기에서 만족도가 제일 높은 값들을 골라서, 더한값?
             *
             * 3 5
             * 1 2 3 4 5
             * 5 4 3 2 1
             * 1 2 3 2 1
             *
             * (1,3,5) 열의 치킨을 골랐을 때 이다.
             * = 13
             */
            int[] comb = new int[3];
            combination(arr2, 0,n, m, 3, comb);
            sb.append(max);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void combination(int[][] arr, int depth, int n, int m, int k, int[] comb) {
            if(depth == k) {
                //최대값을 구하기
                int totalSum = 0;
                for(int i=0; i<n; i++) {
                    int currMax = 0;
                    for(int j=0; j<k; j++) {
                        currMax = Math.max(currMax, arr[i][comb[j]]);
                    }
                    totalSum += currMax;
                }
                max = Math.max(totalSum, max);
                return;
            }

            for(int i=0; i<m; i++) {
                if(!visited[i]) {
                    comb[depth] = i;
                    visited[i] = true;
                    combination(arr, depth+1, n, m, k, comb);
                    visited[i] = false;
                }
            }
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
