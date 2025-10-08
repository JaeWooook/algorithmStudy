package Java.BOJ.BFS;

import java.io.*;
import java.util.*;

public class BOJ_14_6593 {
    public static class Main {
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static boolean[][] visited = new boolean[901][31];
        static int[][] distance = new int[901][31];

        public static void main(String[] args) throws IOException {
            //bfs 기본문제 boj 2468
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            /**
             * 1. m은 층 n은 행, k는 열로 한다.
             * 2. 우선 탈출구 E를 먼저 찾는다.
             * 3. 탈출구의 x,y좌표를 찍고 해당 내역에 distance를 찍어 0이면, Trapped!를 출력한다.
             *
             * 3 4 5
             * S....
             * .###.
             * .##..
             * ###.#
             *
             * #####
             * #####
             * ##.##
             * ##...
             *
             * #####
             * #####
             * #.###
             * ####E
             *
             * 1 3 3
             * S##
             * #E#
             * ###
             *
             * 0 0 0
             */
            while(true) {
                String line;
                while((line = br.readLine()) != null && line.trim().isEmpty()) {
                    // 빈 줄 건너뛰기
                }

                if(line == null) break;

                st = new StringTokenizer(line);
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                if(m == 0 && n == 0 && k == 0) break;

                String[][] arr2 = readString2DArrayIgnoringBlanks(n*m, k); // 2차원 배열
                int exitX = 0;
                int exitY = 0;
                int startX = 0;
                int startY = 0;
                Queue<List<Integer>> queue = new LinkedList<>();

                for(int i=0; i<arr2.length; i++) {
                    for(int j=0; j<arr2[i].length; j++) {
                        if("S".equals(arr2[i][j])) {
                            startX = i;
                            startY = j;
                            queue.add(List.of(i, j));
                            visited[i][j] = true;
                        }

                        if("#".equals(arr2[i][j])) {
                            visited[i][j] = true;
                        }

                        if("E".equals(arr2[i][j])) {
                            exitX = i;
                            exitY = j;
                        }
                    }
                }

                bfs(m, k, n, queue);

                if(distance[exitX][exitY] > 0) {
                    sb.append("Escaped in ").append(distance[exitX][exitY]).append(" minute(s).").append("\n");
                } else {
                    if(exitX == startX && exitY == startY) {
                        sb.append("Escaped in ").append(distance[exitX][exitY]).append(" minute(s).").append("\n");
                    } else {
                        sb.append("Trapped!").append("\n");
                    }
                }

                for(int i=0; i<visited.length; i++) {
                    Arrays.fill(visited[i], false);
                    Arrays.fill(distance[i], 0);
                }
            }


            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void bfs(int n, int m, int k, Queue<List<Integer>> queue) {
            while(!queue.isEmpty()) {
                List<Integer> xy = queue.poll();
                int curX = xy.get(0);
                int curY = xy.get(1);
                int upStairStartX = 0;
                int upStairEndX = 0;
                int downStairStartX = 0;
                int downStairEndX = 0;
                //1층은 0, 3까지 4
                //2층은 4, 7까지 8
                //3층은 8, 11까지 12
                int startX = 0;
                int endX = n;
                while(true) {
                    if(startX <= curX && curX < endX) {
                        upStairStartX = startX + n;
                        upStairEndX = endX + n;
                        downStairStartX = startX - n;
                        downStairEndX = endX - n;
                        break;
                    }

                    startX+=n;
                    endX+=n;
                }

                //현재층이 몇층인지 알아서 x,y를 걸러줘야한다.
                int[] dx = {0, 0, 1, -1, n, -1*n};
                int[] dy = {1, -1, 0, 0, 0, 0};

                for(int i=0; i<6; i++) {
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    if(i < 4 && (ny >= m || ny < 0 || nx >= endX || nx < startX || visited[nx][ny])) continue;//n,m은 맞는데 위에층을 계산하게되닌까 안된다.
                    if(i == 4 && (nx>= n*k || nx < 0 || nx >= upStairEndX || nx < upStairStartX || ny>=m || ny <0 || visited[nx][ny])) continue;
                    if(i == 5 && (nx>= n*k || nx < 0 || nx >= downStairEndX || nx < downStairStartX || ny>=m || ny <0 || visited[nx][ny])) continue;

                    if(distance[nx][ny] > 0) {
                        distance[nx][ny] = Math.min(distance[nx][ny], distance[curX][curY]+1);
                    } else {
                        distance[nx][ny] = distance[curX][curY] + 1;
                    }
                    visited[nx][ny] = true;
                    queue.add(List.of(nx,ny));
                }
            }
        }

        // 🔽 층 사이 빈 줄을 무시하고 n*m줄을 읽는 함수
        static String[][] readString2DArrayIgnoringBlanks(int rows, int cols) throws IOException {
            String[][] arr = new String[rows][cols];
            int count = 0;

            while (count < rows) {
                String line = br.readLine();
                if (line == null) break;           // EOF
                if (line.trim().isEmpty()) continue; // 빈 줄은 무시

                // line의 길이가 cols보다 짧을 수 있으므로 안전하게 처리
                for (int j = 0; j < cols && j < line.length(); j++) {
                    arr[count][j] = String.valueOf(line.charAt(j));
                }
                count++;
            }
            return arr;
        }
    }
}
