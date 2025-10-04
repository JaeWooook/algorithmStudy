package Java.BOJ.BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12_5014 {
    public static class Main {
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static boolean[] visited = new boolean[1000001];
        static int[] distance = new int[1000001];

        public static void main(String[] args) throws IOException {
            //bfs 기본문제 boj 5014
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            /**
             * 1. f전체층, 스타링크위치 g층, 지금있는곳 s층, u버튼 위로 u층을 가는 버튼, d버튼 아래로 d층을 가는 버튼
             * 2. u층위 or d층 아래 해당층이 없을때는 이동안함
             * 3. 엘리베이터로 이동못하면 use the stairs를 출력
             * 4. s층에서 g층 가기위해 누르는 버튼의 최소값 출력
             * 5. visited에 방문회수를 기록하고 중복된곳은 가지않도록한다.
             * 6. 개수를 1개씩 높여서 최소개수를 실셈한다.
             *
             * 10 1 10 2 1
             * 6
             *
             * 1 ->  3 5 7 9 11 10
             *
             */
            bfs(g, s, u, d, f);
            if(distance[g] == 0) {
                if(g == s) {
                    sb.append(distance[g]);
                } else {
                    sb.append("use the stairs");
                }
            } else {
                sb.append(distance[g]);
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void bfs(int target, int start, int up, int down, int limit) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited[start] = true;

            while(!queue.isEmpty()) {
                int currentStair = queue.poll();

                int[] upAndDown = {up, down*-1};
                for(int i=0; i<2; i++) {
                    int nStair = currentStair + upAndDown[i];

                    if(nStair < 1 || nStair > limit || visited[nStair]) continue;
                    visited[nStair] = true;
                    queue.add(nStair);
                    if(distance[nStair] == 0) {
                        distance[nStair] = distance[currentStair] + 1;
                    } else {
                        distance[nStair] = Math.min(distance[nStair], distance[currentStair]);
                    }
                }
            }
        }
    }
}
