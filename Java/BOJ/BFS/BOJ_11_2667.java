package Java.BOJ.BFS;

import java.io.*;
import java.util.*;


public class BOJ_11_2667 {
    public static class Main {
        static BufferedReader br;
        static BufferedWriter bw;

        static boolean[][] visited = new boolean[26][26];

        public static void main(String[] args) throws IOException {
            //bfs 기본문제 boj 2667
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[][] arr2 = readInt2DArrayNew(n, n); // 2차원 배열

            /**
             * 1. 1은 집이 있는곳, 0은 집이 없는곳
             * 2. 각 집이 모여있는곳을 그룹핑한다. 각 단지내의 집의 수를 오름차순으로 정렬한다.
             *
             * 7
             * 0110100
             * 0110101
             * 1110101
             * 0000111
             * 0100000
             * 0111110
             * 0111000
             */
            List<Integer> result = new ArrayList<>();
            bfs(arr2, n, result);
            sb.append(result.size()).append("\n");
            Collections.sort(result);
            for(Integer ans : result) {
                sb.append(ans).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void bfs(int[][] arr2, int n, List<Integer> result) {
            Queue<List<Integer>> home = new LinkedList<>();
            Queue<List<Integer>> group = new LinkedList<>();
            int cnt = 0;

            //그룹별 벽 생성
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(!visited[i][j] && arr2[i][j] == 1) {
                        visited[i][j] = true;
                        home.add(List.of(i,j));
                        cnt++;
                    }

                    while(!home.isEmpty()) {
                        List<Integer> xy = home.poll();
                        int[] dx = {0, 0, 1, -1};
                        int[] dy = {1, -1, 0, 0};

                        for(int a=0; a<4; a++) {
                            int nx = dx[a] + xy.get(0);
                            int ny = dy[a] + xy.get(1);

                            if(nx >= n || nx<0 || ny>=n || ny<0 || visited[nx][ny] || arr2[nx][ny] == 0) continue;

                            cnt++;
                            visited[nx][ny] = true;
                            home.add(List.of(nx,ny));
                        }
                    }

                    if(cnt > 0) {
                        result.add(cnt);
                    }
                    cnt = 0;
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
