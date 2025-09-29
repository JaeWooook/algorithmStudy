package Java.BOJ.BFS;
import java.io.*;
import java.util.*;
public class BOJ_7_7569 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static int cnt = 0;
        static int cnt2 = 0;

        static boolean[][] visited = new boolean[10001][101];

        public static void main(String[] args) throws IOException {
            //bfs 기본문제 boj 7569
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] arr2 = readInt2DArrayNew(n*k, m); // 2차원 배열

            /**
             * 1. 토마토가 며칠이 지나면 다익는지 최소일수
             * 2. 상자의 수 k이다. 층수,1은 익은토마토, 0은 익지 않은 토마토, -1은 토마토가없음
             * 3. 모든 토마토가 익었다면 0 모두 익지못하는 상황이라면 -1
             * 4. 익지않은 토마토들은 위 아래 왼쪽 오른쪽 앞 뒤를 통해 영향을 받고, 익는다. 대각선은안되고 혼자익는경우는 없다.
             * 5. 3d의 형태를 개념으로 두어야하나? 2중포문으로 2개씩 입력받고하는게 아닌데?
             * 6. 토마토는 각각 시작점이 여러개일수있다. for문으로 일단 1들의 위치를 찾는 것도 필요
             *
             * 5 3 1
             * 0 -1 0 0 0
             * -1 -1 0 1 1
             * 0 0 0 1 1
             *
             * 2 2 3
             *
             * 1 1
             * -1 1
             *
             * 1 -1
             * 0 0 -> 1턴
             *
             * 0 0
             * 0 1
             *
             *
             *
             * 1
             */
            if(!isZero(arr2, m, n, k)) {
                sb.append(cnt);
            } else {
                bfs(arr2, m,n, k);
                if(isZero(arr2, m, n, k)) {
                    sb.append(-1);
                } else {
                    sb.append(cnt-1);
                }
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
        static boolean isZero(int[][] arr2, int m, int n, int h) {
            for(int i=0; i<n*h; i++) {
                for(int j=0; j<m; j++) {
                    if(arr2[i][j] == 0) {
                        return true;
                    }
                }
            }
            return false;
        }

        static void bfs(int[][] arr2, int m, int n, int h) {
            Queue<List<Integer>> que = new LinkedList<>();
            for(int i=0; i<n*h; i++) {
                for(int j=0; j<m; j++) {
                    if(!visited[i][j] && arr2[i][j] == 1) {
                        que.add(List.of(i,j));
                        visited[i][j] = true;
                        cnt2++;
                    }
                }
            }

            while(!que.isEmpty()) {
                List<Integer> xy = que.poll();
                cnt2--;
                int[] dx = {0, 0, 1, -1};
                int[] dy = {1, -1, 0, 0};
                //현재 몇층인지 구하기
                int sx = 0;
                int ex = 0;
                int idx = 0;
                while(idx<=n*h) {
                    if(idx <= xy.get(0) && xy.get(0) < idx+n) {
                        sx = idx;
                        ex = idx+n;
                        break;
                    }
                    idx+=n;
                }

                for(int a=0; a<6; a++) {
                    int nx, ny;
                    boolean currentFloor = false;
                    //위층 아래층
                    if(a == 4) {
                        nx = xy.get(0) + n;
                        ny = xy.get(1);
                    } else if(a == 5) {
                        nx = xy.get(0) - n;
                        ny = xy.get(1);
                    } else {
                        currentFloor = true;
                        nx = xy.get(0) + dx[a];
                        ny = xy.get(1) + dy[a];
                    }
                    if(h == 1) currentFloor = false;

                    if(!currentFloor && (nx >= n*h || ny >= m || nx < 0 || ny < 0 || visited[nx][ny] || arr2[nx][ny] !=0)) continue;
                    if(currentFloor && (nx >= ex || ny >= m || nx < sx || ny < 0 || visited[nx][ny] || arr2[nx][ny] != 0)) continue;

                    visited[nx][ny] = true;
                    if(arr2[nx][ny] == 0) {
                        que.add(List.of(nx, ny));
                        arr2[nx][ny] = 1;
                    }
                }

                if(cnt2 == 0) {
                    cnt2 = que.size();
                    cnt++;
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
