package Java.BOJ.BFS;

import java.io.*;
import java.util.*;

public class BOJ_1_1926 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;
        static boolean[][] visited = new boolean[500][500];

        public static void main(String[] args) throws IOException {
            //bfs 연습문제 boj 1926
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr2 = readInt2DArray(n, m); // 2차원 배열

            /**
             * 1. 각 그림은 가로,세로로만 연결된것의 개수를 실셈한다.
             * 2. 가장큰 그림의 너비값을 구하고, 각 그림의 개수도 구한다.
             * 3. 그림이하나도없는경우 가장 넓은 그림의 넓이는 0이다.
             * 4. 각각의 시작점들을 어떻게 찾을 것인가?
             * 5. bfs는 시작점을 queue에 넣고 그것을기반으로, while을 돌리는 방식이 대부분인 듯하다.
             * 6. visitied를 이용해서 방문하지않은것 중 발견된 1을 체크해서 시작점으로 한다.
             *
             * 6 5
             * 1 1 0 1 1
             * 0 1 1 0 0
             * 0 0 0 0 0
             * 1 0 1 1 1
             * 0 0 1 1 1
             * 0 0 1 1 1
             *
             * 5 5
             * 1 1 1 1 1
             * 0 0 0 0 1
             * 1 1 1 1 1
             * 1 0 0 0 0
             * 1 1 1 1 1
             *
             * 2
             * 13
             *
             * 6 7
             * 1 1 0 0 0 0 1
             * 1 1 0 1 1 0 1
             * 0 0 0 1 1 0 0
             * 0 1 1 0 0 1 0
             * 0 1 0 0 0 1 0
             * 0 1 1 1 1 1 0
             *
             * 3
             * 10
             */
            List<Integer> temp = new ArrayList<>();
            bfs(arr2, n, m, temp);
            int max = 0;
            if(temp.size() > 0) {
                max = Collections.max(temp);
            }
            sb.append(temp.size()).append("\n").append(max);

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
        static void bfs(int[][] arr2, int n, int m, List<Integer> widList) {
            Queue<List<Integer>> queue = new LinkedList<>();
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(!visited[i][j] && arr2[i][j] == 1) {
                        queue.add(List.of(i,j));
                        int width = 0;
                        while(!queue.isEmpty()) {
                            List<Integer> startXY = queue.poll();
                            int startX = startXY.get(0);
                            int startY = startXY.get(1);

                            if(!visited[startX][startY]) {
                                visited[startX][startY] = true;
                                if(arr2[startX][startY] == 1) {
                                    width++;
                                }

                                if(startX+1 < n && arr2[startX+1][startY] == 1 && !visited[startX+1][startY]) {
                                    queue.add(List.of(startX+1, startY));
                                }
                                if(startX-1 >= 0 && arr2[startX-1][startY] == 1 && !visited[startX-1][startY]) {
                                    queue.add(List.of(startX-1, startY));
                                }
                                if(startY+1 < m && arr2[startX][startY+1] == 1 && !visited[startX][startY+1]) {
                                    queue.add(List.of(startX, startY+1));
                                }
                                if(startY-1 >= 0 && arr2[startX][startY-1] == 1 && !visited[startX][startY-1]) {
                                    queue.add(List.of(startX, startY-1));
                                }
                            } else {
                                continue;
                            }
                        }
                        widList.add(width);
                    }
                }
            }
        }

        static int[][] readInt2DArray(int rows, int cols) throws IOException {
            int[][] arr = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            return arr;
        }
    }
}
