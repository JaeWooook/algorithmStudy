package Java.BOJ.BFS;
import java.io.*;
import java.util.*;
public class BOJ_10_2583 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static boolean[][] visited = new boolean[101][101]; //101 101
        static boolean[][] wall = new boolean[101][101]; //101 101

        public static void main(String[] args) throws IOException {
            //bfs 기본문제 boj 2583
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] arr2 = readInt2DArrayNew(k, 4); // 2차원 배열

            /**
             * 1. 왼쪽아래 꼭짓점 좌표 x,y 오른쪽위 꼭짓점 좌표 x,y
             * 2. 왼쪽아래 꼭짓점좌표는 0,0이고 위꼭짓점 좌표는 n,m이다.
             * 3. 우선 왼쪽 아래 꼭짓점 좌표를 기반, y는 0부터 4까지, x는 2부터 4까지 해서 쭈욱 1넣고 그 1의 추가된 개수 구하는게 넓이
             * 4. 이후에 visited가 false인
             *
             * 5 7 3
             * 0 2 4 4
             * 1 1 2 5
             * 4 0 6 2
             */

            List<Integer> ans = new ArrayList<>();
            bfs(arr2, ans, k, m, n);
            Collections.sort(ans);
            sb.append(ans.size()).append("\n");
            for(Integer answer : ans) {
                sb.append(answer).append(" ");
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void bfs(int[][] arr2, List<Integer> answer, int k, int m, int n) {
            for(int i=0; i<k; i++) {
                int leftY = arr2[i][0];
                int leftX = arr2[i][1];
                int rightY = arr2[i][2];
                int rightX = arr2[i][3];

                Queue<List<Integer>> queue = new LinkedList<>();
                queue.add(List.of(leftY, leftX));
                visited[leftY][leftX] = true;
                wall[leftY][leftX] = true;

                while(!queue.isEmpty()) {
                    List<Integer> yx = queue.poll();
                    int[] dx = {0, 0, 1, -1};
                    int[] dy = {1, -1, 0, 0};

                    for(int j=0; j<4; j++) {
                        int nx = dx[j] + yx.get(1);//1,1 2,1 0,1
                        int ny = dy[j] + yx.get(0);
                        if(nx >= rightX || nx < leftX || ny >= rightY || ny < leftY || visited[ny][nx]) continue;

                        visited[ny][nx] = true;
                        wall[ny][nx] = true;
                        queue.add(List.of(ny, nx));
                    }
                }
                for (int t = 0; t < visited.length; t++) {
                    Arrays.fill(visited[t], false);
                }
            }

            Queue<List<Integer>> queue = new LinkedList<>();
            int cnt = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(!wall[i][j] && !visited[i][j]) {
                        queue.add(List.of(i,j));
                        visited[i][j] = true;
                        cnt++;
                    }

                    while(!queue.isEmpty()) {
                        List<Integer> yx = queue.poll();
                        int[] dx = {0, 0, 1, -1};
                        int[] dy = {1, -1, 0, 0};

                        for(int t=0; t<4; t++) {
                            int nx = dx[t] + yx.get(0);
                            int ny = dy[t] + yx.get(1);

                            if(nx >= n || nx < 0 || ny >= m || ny < 0 || visited[nx][ny] || wall[nx][ny]) continue;

                            cnt++;
                            visited[nx][ny] = true;
                            queue.add(List.of(nx, ny));
                        }
                    }

                    if(cnt > 0) {
                        answer.add(cnt);
                    }
                    cnt = 0;
                }
            }
        }

        //띄어쓰기 없는 2차원일때
        private static int[][] readInt2DArrayNew(int n, int m) throws IOException {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                String line = br.readLine().trim();

                // 공백으로 구분된 경우
                if (line.contains(" ")) {
                    StringTokenizer st = new StringTokenizer(line);
                    for (int j = 0; j < m; j++) {
                        if (!st.hasMoreTokens()) {
                            throw new IllegalArgumentException(
                                "입력 데이터가 부족합니다. line=" + line + " 기대된 길이=" + m
                            );
                        }
                        arr[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                // 붙어있는 문자열인 경우
                else {
                    if (line.length() < m) {
                        throw new IllegalArgumentException(
                            "입력 데이터 길이가 부족합니다. line=" + line + " 기대된 길이=" + m
                        );
                    }
                    for (int j = 0; j < m; j++) {
                        arr[i][j] = line.charAt(j) - '0';
                    }
                }
            }
            return arr;
        }
    }
}
