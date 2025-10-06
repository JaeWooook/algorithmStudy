package Java.BOJ.BFS;

import java.io.*;
import java.util.*;

public class BOJ_13_2468 {
    public static class Main {
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;
        static int max = Integer.MIN_VALUE;

        static boolean[][] visited = new boolean[101][101];
        static boolean[][] wall = new boolean[101][101];

        public static void main(String[] args) throws IOException {
            //bfs 기본문제 boj 2468
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            int n = readInt(); // 단일 정수 사용
            int[][] arr2 = readInt2DArrayNew(n, n); // 2차원 배열
            /**
             * 1. 높이정보를 파악한것 일정 높이 이하는 잠긴다.
             * 2. 일정한 높이에서도 잠기지않는 일정한 영역을 구한다.
             * 3. 물에 잠기지않는 일정 높이의 최대 개수를 구하는 프로그램
             * 4. 물의 높이가 1일때 2일때 3...각각 최대의 높이만큼 잠기가한다.
             * 5. 우선 최대물의 높이를 구한다. 그리고 각각을 색칠해서 영역이 가장많은 개수를 구한다.
             *
             *
             * 5
             * 6 8 2 6 2
             * 3 2 3 4 6
             * 6 7 3 3 2
             * 7 2 5 3 6
             * 8 9 5 2 7
             */
            bfs(arr2);
            sb.append(max);

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void bfs(int[][] arr2 ) {
            int groupMax = Integer.MIN_VALUE;
            for(int i=0; i<arr2.length; i++) {
                for(int j=0; j<arr2[i].length; j++) {
                    groupMax = Math.max(arr2[i][j], groupMax);
                }
            }

            Queue<List<Integer>> queue = new LinkedList<>();
            for(int i=0; i<=groupMax; i++) {
                for(int a=0; a<arr2.length; a++) {
                    for(int b=0; b<arr2[a].length; b++) {
                        if(arr2[a][b] == i && !wall[a][b]) {
                            wall[a][b] = true;
                        }
                    }
                }

                int cnt = 0;
                for(int t=0; t<arr2.length; t++) {
                    for(int q=0; q<arr2[t].length; q++) {
                        if(!wall[t][q] && !visited[t][q]) {
                            queue.add(List.of(t,q));
                            visited[t][q] = true;
                            cnt++;
                        }

                        while(!queue.isEmpty()) {
                            List<Integer> xy = queue.poll();

                            int[] dx = {0, 0, 1, -1};
                            int[] dy = {1, -1, 0, 0};

                            for(int k=0; k<4; k++) {
                                int nx = dx[k] + xy.get(0);
                                int ny = dy[k] + xy.get(1);

                                if(nx >= arr2.length || nx < 0 || ny>= arr2.length || ny < 0 || wall[nx][ny] || visited[nx][ny]) continue;
                                visited[nx][ny] = true;
                                queue.add(List.of(nx, ny));
                            }
                        }
                    }
                }

                max = Math.max(max, cnt);

                for(int s=0; s<visited.length; s++) {
                    Arrays.fill(visited[s], false);
                }
            }
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
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
