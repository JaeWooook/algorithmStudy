package Java.BOJ.BFS;
import java.io.*;
import java.util.*;

public class BOJ_6_10026 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static int cnt = 0;
        static int cnt2 = 0;

        static boolean[][] visited = new boolean[100][100];
        static boolean[][] visited2 = new boolean[100][100];

        public static void main(String[] args) throws IOException {
            //bfs 기본문제 boj 10026
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            String[][] strArr2D = readString2DArrayNew(n, n);

            /**
             * 1. 같은색으로 상하좌우 인접하면 같은 구역에 속한다. 색상차이를 느끼지못하는 경우 같은 색이라한다.
             *
             * 5
             * RRRBB
             * GGBBB
             * BBBRR
             * BBRRR
             * RRRRR
             *
             *
             * 색약이아닌사람은 빨강 2 파랑 1 초록 1 -> 총구역수 4개
             * 색약인사람 빨강-초록 2 파랑 1 -> 3개의 구역
             */
            bfs(strArr2D, n);
            sb.append(cnt).append(" ").append(cnt2);

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void bfs(String[][] arr2, int n) {
            Queue<List<Integer>> que = new LinkedList<>();
            Queue<List<Integer>> que2 = new LinkedList<>();

            //정상인
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(!visited[i][j]) {
                        cnt++;
                        que.add(List.of(i,j));
                        while(!que.isEmpty()) {
                            List<Integer> xy = que.poll();
                            int x = xy.get(0);
                            int y = xy.get(1);
                            String target = arr2[x][y];

                            int[] dx = {0, 0, 1, -1};
                            int[] dy = {1, -1, 0, 0};

                            for(int a=0; a<4; a++) {
                                int nx = x+dx[a];
                                int ny = y+dy[a];

                                if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || !arr2[nx][ny].equals(target)) continue;

                                visited[nx][ny] = true;
                                que.add(List.of(nx,ny));
                            }
                        }
                    }
                }
            }

            //적녹색약인
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(!visited2[i][j]) {
                        cnt2++;
                        que2.add(List.of(i,j));
                        while(!que2.isEmpty()) {
                            List<Integer> xy = que2.poll();
                            int x = xy.get(0);
                            int y = xy.get(1);
                            String target = arr2[x][y];

                            int[] dx = {0, 0, 1, -1};
                            int[] dy = {1, -1, 0, 0};

                            for(int a=0; a<4; a++) {
                                int nx = x+dx[a];
                                int ny = y+dy[a];

                                if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited2[nx][ny]
                                    || (("R".equals(target) || "G".equals(target)) && "B".equals(arr2[nx][ny]))
                                    || ("B".equals(target) && ("R".equals(arr2[nx][ny]) || "G".equals(arr2[nx][ny]))) ) continue;

                                visited2[nx][ny] = true;
                                que2.add(List.of(nx,ny));
                            }
                        }
                    }
                }
            }
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static String[][] readString2DArrayNew(int rows, int cols) throws IOException {
            String[][] arr = new String[rows][cols];
            for (int i = 0; i < rows; i++) {
                String line = br.readLine(); // 공백 없는 한 줄 그대로 읽음
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = String.valueOf(line.charAt(j));
                }
            }
            return arr;
        }
    }
}
