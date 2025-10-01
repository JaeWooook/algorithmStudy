package Java.BOJ.BFS;
import java.io.*;
import java.util.*;

public class BOJ_9_5427 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;
        static boolean[][] visited = new boolean[1001][1001];
        static int[][] distance = new int[1001][1001];

        public static void main(String[] args) throws IOException {
            //bfs 기본문제 boj 5427
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용

            /**
             * 1. 첫째 줄에 테스트 케이스
             * 2. . 빈공간 # 벽 @ 상근이의 시작 위치 * 불
             * 3. 예전 문제 처럼 탈출구를 찾고 시작한다.
             * 4. 불이 먼저 이동하고, 그다음에 상근이가 이동하도록한다.
             * 5. 우선 상근이의 위치를 먼저찾는다. 불표시를하고, 상근이도 표시한다.
             * 6. 상근이와 탈출구가 일치하는 좌표에 distance를 계산한다.
             *
             * 1
             * 4 3
             * ..#.
             * ...@
             * *...
             */
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                String[][] arr2 = readString2DArrayNew(y,x);
                Queue<List<Integer>> exist = new LinkedList<>();
                boolean byPass = false;

                for(int a=0; a<y; a++) {
                    if(".".equals(arr2[a][0])) {
                        exist.add(List.of(a,0));
                    }
                    if(".".equals(arr2[a][x-1])) {
                        exist.add(List.of(a,x-1));
                    }

                    if("@".equals(arr2[a][0]) || "@".equals(arr2[a][x-1])) {
                        byPass = true;
                        break;
                    }
                }
                for(int b=0; b<x; b++) {
                    if(".".equals(arr2[0][b])) {
                        exist.add(List.of(0,b));
                    }

                    if(".".equals(arr2[y-1][b])) {
                        exist.add(List.of(y-1,b));
                    }

                    if("@".equals(arr2[0][b]) || "@".equals(arr2[y-1][b])) {
                        byPass = true;
                        break;
                    }
                }

                bfs(arr2, x,y);
                int sum = 0;
                int min = Integer.MAX_VALUE;
                while(!exist.isEmpty()) {
                    List<Integer> xy = exist.poll();
                    if(distance[xy.get(0)][xy.get(1)] > 0) {
                        sum += distance[xy.get(0)][xy.get(1)];
                        min = Math.min(distance[xy.get(0)][xy.get(1)], min);
                    }
                }
                if(byPass) {
                    sb.append(1).append("\n");
                } else {
                    if(sum == 0) {
                        sb.append("IMPOSSIBLE").append("\n");
                    } else {
                        sb.append(min).append("\n");
                    }
                }

                //초기화
                for(int a=0; a<distance.length; a++) {
                    for(int b=0; b<distance.length; b++) {
                        distance[a][b] = 0;
                        visited[a][b] = false;
                    }
                }
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void bfs(String[][] arr2, int x, int y) {
            Queue<List<Integer>> sang = new LinkedList<>();
            Queue<List<Integer>> fire = new LinkedList<>();

            for(int a=0; a<arr2.length; a++) {
                for(int b=0; b<arr2[a].length; b++) {
                    if(arr2[a][b].equals("@")) {
                        distance[a][b] = 1;
                        sang.add(List.of(a,b));
                    }

                    if(arr2[a][b].equals("*")) {
                        fire.add(List.of(a,b));
                    }

                    if(arr2[a][b].equals("#")) {
                        visited[a][b] = true;
                    }
                }
            }

            while(!fire.isEmpty() || !sang.isEmpty()) {
                int fireSize = fire.size();
                int sangSize = sang.size();
                int[] dx = {1, -1, 0, 0};
                int[] dy = {0, 0, 1, -1};

                for(int i=0; i<fireSize; i++) {
                    List<Integer> xy = fire.poll();
                    for(int j=0; j<4; j++) {
                        int nx = xy.get(0) + dx[j];
                        int ny = xy.get(1) + dy[j];

                        if(nx>=y || ny >= x || nx<0 || ny<0 || visited[nx][ny] || !".".equals(arr2[nx][ny])) continue;

                        visited[nx][ny] = true;
                        arr2[nx][ny] = "*";
                        fire.add(List.of(nx,ny));
                    }
                }

                for(int i=0; i<sangSize; i++) {
                    List<Integer> xy = sang.poll();
                    for(int j=0; j<4; j++) {
                        int nx = xy.get(0) + dx[j];
                        int ny = xy.get(1) + dy[j];

                        if(nx>=y || ny >= x || nx<0 || ny<0 || visited[nx][ny] || !".".equals(arr2[nx][ny])) continue;

                        visited[nx][ny] = true;
                        arr2[nx][ny] = "@";
                        sang.add(List.of(nx,ny));

                        if(distance[nx][ny] == 0) {
                            distance[nx][ny] = distance[xy.get(0)][xy.get(1)]+1;
                        } else {
                            distance[nx][ny] = Math.min(distance[nx][ny], distance[xy.get(0)][xy.get(1)]+1);
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
