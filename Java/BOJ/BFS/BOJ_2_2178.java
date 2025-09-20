package Java.BOJ.BFS;
import java.io.*;
import java.util.*;
public class BOJ_2_2178 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static boolean[][] visited = new boolean[100][100];
        static int[][] distance = new int[100][100];

        public static void main(String[] args) throws IOException {
            //bfs 연습문제 boj 2178
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr2 = readInt2DArrayNew(n, m); // 2차원 배열

            /**
             * 1. 미로 1은 이동가능 0은 불가 미로는 무조건 1,1 -> 즉 0,0에서 출발해서 n,m 이동하는 최소칸구하라
             * 2. 다른칸으로갈때 인접한칸만 이동.
             * 3. 시작점을 기준으로 더 짧지않은 길? 혹은 막힌길이 있다면 되돌아가야한다. 백트레킹
             * 4. 여러 길들이 존재할 수 있다.4가지 방향이 있기 때문에 4*4로 16가지의 경우의수가 존재한다.
             * 5. 16가지의 조건들을 전부 while문을 할수는 없는데 재귀로 돌려야하나?
             * 6. 지나오는 길들을 전부, queue에 넣고있다. 지나온길중 갈래길이 있는것은 따로 queue에 보관? 해서 막히거나 끝나면
             * 7. 해당 길을 다시 꺼내야하나? 갈림길은 스택으로 관리해야할듯하다.
             *
             * 4 6
             * 101111
             * 101010
             * 101011
             * 111011
             */
            List<Integer> temp = new ArrayList<>();
            bfs(arr2, n, m);
            sb.append(distance[n-1][m-1]);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
        static void bfs(int[][] arr2, int n, int m) {
            Queue<List<Integer>> queue = new LinkedList<>();
            queue.add(List.of(0,0));
            distance[0][0] = 1;

            while(!queue.isEmpty()) {
                List<Integer> startXY = queue.poll();
                int sX = startXY.get(0);
                int sY = startXY.get(1);

                if(visited[sX][sY] || arr2[sX][sY] == 0) continue;
                visited[sX][sY] = true;

                if(sX+1 < n && !visited[sX+1][sY] && arr2[sX+1][sY] == 1) {
                    queue.add(List.of(sX+1, sY));
                    distance[sX+1][sY] = distance[sX+1][sY] == 0 ? distance[sX][sY]+1 : Math.min(distance[sX+1][sY], distance[sX][sY]+1);
                }

                if(sX-1 >= 0 && !visited[sX-1][sY] && arr2[sX-1][sY] == 1) {
                    queue.add(List.of(sX-1, sY));
                    distance[sX-1][sY] = distance[sX-1][sY] == 0 ? distance[sX][sY]+1 : Math.min(distance[sX-1][sY], distance[sX][sY]+1);
                }

                if(sY+1 < m && !visited[sX][sY+1] && arr2[sX][sY+1] == 1) {
                    queue.add(List.of(sX, sY+1));
                    distance[sX][sY+1] = distance[sX][sY+1] == 0 ? distance[sX][sY]+1 : Math.min(distance[sX][sY+1], distance[sX][sY]+1);
                }

                if(sY-1 >= 0 && !visited[sX][sY-1] && arr2[sX][sY-1] == 1) {
                    queue.add(List.of(sX, sY-1));
                    distance[sX][sY-1] = distance[sX][sY-1] == 0 ? distance[sX][sY]+1 : Math.min(distance[sX][sY-1], distance[sX][sY]+1);
                }
            }
        }

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
