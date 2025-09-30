package Java.BOJ.BFS;
import java.io.*;
import java.util.*;

public class BOJ_8_7562 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;
        static boolean[][] visited = new boolean[301][301];
        static int[][] distance = new int[301][301];

        public static void main(String[] args) throws IOException {
            //bfs 기본문제 boj 7562
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용

            /**
             * 1. 체스판 나이트는 1번에 이동가능한칸
             * 2. 0,0을 기준으로 2,1 이동, 1,2 이동 2,-1이동 1,-2이동 -2,1 이동 -1, 2이동 -2,-1 이동 -1, -2이동
             * 3. 나이는 몇번움직이면 이칸으로 이동한다? 이칸이뭐지? 첫번째 입력은 테스트케이스다.
             * 4. 첫번째는 체스판의 크기 8은 8*8 체스판을말한다.
             * 5. 0,0이 현재 말이있는공간 7,0을 가기위해서 몇번 움직여야 하는지를 맞춘다.
             * 6. 결국 distance사용하는것
             *
             * 3
             *
             * 8
             * 0 0
             * 7 0
             *
             * $ 0 0 0 0 0
             * 0 1 0 0 0 0
             * 0 0 1 0 1 0
             * 1 0 1 0 0 0 -> 2
             * 0 0 0 1 0 0
             * 0 1 0 0 1 0
             * 0 0 1 0 0 0
             * 1 0 0 0 0 0
             *
             * 100
             * 0 0
             * 30 50
             *
             * 10
             * 1 1
             * 1 1
             */
            for(int i=0; i<n; i++) {
                int m = readInt();
                int[][] inputArr2 = readInt2DArrayNew(2,2);
                if(inputArr2[0][0] == inputArr2[1][0] && inputArr2[0][1] == inputArr2[1][1]) {
                    sb.append(0).append("\n");
                } else {
                    bfs(m, inputArr2);
                    sb.append(distance[inputArr2[1][0]][inputArr2[1][1]]).append("\n");

                    //초기화
                    for(int a=0; a<301; a++) {
                        for(int b=0; b<301; b++) {
                            distance[a][b] = 0;
                            visited[a][b] = false;
                        }
                    }
                }
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
        //2,1 이동, 1,2 이동 2,-1이동 1,-2이동 -2,1 이동 -1, 2이동 -2,-1 이동 -1, -2이동
        static void bfs(int m, int[][] inputXY) {
            Queue<List<Integer>> queue = new LinkedList<>();
            queue.add(List.of(inputXY[0][0], inputXY[0][1]));

            while(!queue.isEmpty()) {
                List<Integer> xy = queue.poll();
                int currentX = xy.get(0);
                int currentY = xy.get(1);
                int[] dx = {2, 1, 2, 1, -2, -1, -2, -1};
                int[] dy = {1, 2, -1, -2, 1, 2, -1, -2};

                for(int i=0; i<8; i++) {
                    int nx = currentX + dx[i];
                    int ny = currentY + dy[i];

                    if(nx >= m || ny >= m || nx < 0 || ny < 0 || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    queue.add(List.of(nx, ny));
                    if(distance[nx][ny] == 0) {
                        distance[nx][ny] = distance[currentX][currentY] + 1;
                    } else {
                        distance[nx][ny] = Math.min(distance[nx][ny], distance[currentX][currentY] + 1);
                    }
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
