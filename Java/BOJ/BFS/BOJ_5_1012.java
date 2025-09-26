package Java.BOJ.BFS;
import java.io.*;
import java.util.*;
public class BOJ_5_1012 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static int cnt = 0;
        static boolean[][] visited = new boolean[50][50];

        public static void main(String[] args) throws IOException {
            //bfs 기본문제 boj 1012
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int t = readInt(); // 단일 정수 사용

            /**
             * 1. 0은 배추없음 1은 배추있음, 목적은 지렁이 몇마리 필요한지 지렁이인접 상하좌우 4방향 배추필요
             * 2. 테스트케이스 t가주어지고, 배추 넓이 n, m, k는 테스트케이스 개수?
             * 3. 약간 배추들을 하나의 묶음으로? 대각선인 곳은 가지 못하지만, 인접한 1은 다이동할수있다고 이해하면된다.
             *
             * 2
             * 10 8 17
             * 0 0
             * 1 0
             * 1 1
             * 4 2
             * 4 3
             * 4 5
             * 2 4
             * 3 4
             * 7 4
             * 8 4
             * 9 4
             * 7 5
             * 8 5
             * 9 5
             * 7 6
             * 8 6
             * 9 6
             * 10 10 1
             * 5 5
             *
             * 4 3 4
             * 2 2
             * 0 2
             * 2 0
             * 0 0
             *
             * 1 0 1
             * 0 0 0
             * 1 0 1
             * 0 0 0
             */

            for(int i=0; i<t; i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                int[][] field = new int[n][m];

                for(int a=0; a<k; a++) {
                    st = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    field[x][y] = 1;
                }

                //입력 다받은 이후에,
                bfs(field, n, m);
                for(int x=0; x<50; x++) {
                    for(int y=0; y<50; y++) {
                        visited[x][y] = false;
                    }
                }
                sb.append(cnt).append("\n");
                cnt = 0;
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void bfs(int[][] arr2, int n, int m) {
            Queue<List<Integer>> que = new LinkedList<>();

            for(int c=0; c<n; c++) {
                for(int j=0; j<m; j++) {
                    if(!visited[c][j] && arr2[c][j] == 1) {
                        que.add(List.of(c,j));
                        visited[c][j] = true;
                        cnt++;
                        while(!que.isEmpty()) {
                            List<Integer> xy = que.poll();

                            int[] dx = {0, 0, 1, -1};
                            int[] dy = {1, -1, 0, 0};

                            for(int a=0; a<4; a++) {
                                int nx = xy.get(0) + dx[a];
                                int ny = xy.get(1) + dy[a];

                                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || arr2[nx][ny] == 0) continue;

                                que.add(List.of(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }
    }
}
