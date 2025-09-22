package Java.BOJ.BFS;

import java.io.*;
import java.util.*;

public class BOJ_3_7576 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static int cnt = 0;
        static boolean[][] visited = new boolean[1000][1000];

        public static void main(String[] args) throws IOException {
            //bfs 연습문제 boj 7576
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[][] arr2 = readInt2DArray(n, m); // 2차원 배열
            /**
             * 1. 최소 토마토가 며칠이 걸려야 다익는지, 확인하는것 -1은 토마토없는곳, 1은 익은것 0은 안익은것
             * 2. 모두익지못하는 순간이 생길수있다. -1로 갖혀있는경우? 즉 전부 돌았는데 0이 1개라도 있다면 그건 -1이다.
             * 3. 처음부터 0이 없다면 그것 또한 안익은게 없으므로 0이다.
             * 4. 대각선의 라인바이 라인으로 차오른다.
             * 5. 우선은 맨처음엔 1이 되는 좌표의 위치를 찾아서 넣는다.
             *
             * 6 4
             * 0 0 0 0 0 0
             * 0 0 0 0 0 0
             * 0 0 0 0 0 0
             * 0 0 0 0 0 1
             *
             * 8
             */

            if(isZero(arr2, n, m)) {
                bfs(arr2, n, m);
                if(isZero(arr2, n, m)) {
                    sb.append(-1);
                } else {
                    sb.append(cnt-1);
                }
            } else {
                sb.append(0);
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
        static boolean isZero(int[][] arr2, int n, int m) {
            for(int i=0; i<n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr2[i][j] == 0) {
                        return true;
                    }
                }
            }
            return false;
        }

        static void bfs(int[][] arr2, int n, int m) {
            int dayCnt = 0;
            Queue<List<Integer>> queue = new LinkedList<>();
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(arr2[i][j] == 1) {
                        queue.add(List.of(i,j));
                    }
                }
            }
            dayCnt = queue.size();//size가 종료되면 하루 카운팅

            while(!queue.isEmpty()) {
                List<Integer> xy = queue.poll();
                dayCnt--;

                int[] dx = {0, 1, 0 , -1};
                int[] dy = {1, 0, -1, 0};
                //나온 xy를 기반으로 4방면을 추가한다.
                for(int i=0; i<4; i++) {
                    int nx = dx[i] + xy.get(0);
                    int ny = dy[i] + xy.get(1);

                    if(nx >= 0 && nx<n && ny >= 0 && ny<m && arr2[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        arr2[nx][ny] = 1;
                        queue.add(List.of(nx, ny));
                    }
                }

                if(dayCnt == 0) {
                    cnt++;
                    dayCnt = queue.size();
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
