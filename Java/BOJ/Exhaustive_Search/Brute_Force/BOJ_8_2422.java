package Java.BOJ.Exhaustive_Search.Brute_Force;
import java.io.*;
import java.util.*;

public class BOJ_8_2422 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static int cnt;

        public static void main(String[] args) throws IOException {
            //브루드포스 기본문제 boj 2422
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr2 = readInt2DArray(m, 2); // 2차원 배열

            /**
             * 1. N은 5 M은 3 N은 아이스크림 종류 M은 이제 아이스크림 고르는 개수 아이스크림은 무조건 3개를 고른다.
             * 2. 그밑에 나오는건 골라서는 안되는 경우의 수
             * 3. 재귀의 컴비네이션이나 뭐이런거 함수만들어서 동일하게 for문돌리면서 하나씩 다넣어보는수밖엔없다
             * 4. 2차원배열에 조합되면 안되는 데이터들은 1,2가 되면안된다면 일단, 2를 키로 1을 키로하는 map으로 관리한다.는 안된다. 1,3 1,2가 중복
             *
             *
             * 5 3
             * 1 2
             * 3 4
             * 1 3
             */
            int answer = 0;
            int[] comb = new int[3];
            boolean[][] ban  = new boolean[n+1][n+1];
            for(int i=0; i<m; i++) {
                ban[arr2[i][0]][arr2[i][1]] = true;
                ban[arr2[i][1]][arr2[i][0]] = true;
            }
            combination(arr2, 0, n, 3, comb, 1, ban);
            sb.append(cnt);

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void combination(int[][] arr, int depth, int n, int m, int[] comb, int next, boolean[][] ban) {
            if(depth == m) {
                cnt++;
                return;
            }

            for(int i=next; i<=n; i++) {
                boolean pass = false;
                if(depth > 0) {
                    for(int a=0; a<depth; a++) {
                        if(a != depth && ban[comb[a]][i] || ban[i][comb[a]]) {
                            pass=true;
                            break;
                        }
                    }
                }
                if(pass) continue;
                comb[depth] = i;

                combination(arr, depth+1, n, m, comb, i+1, ban);
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
