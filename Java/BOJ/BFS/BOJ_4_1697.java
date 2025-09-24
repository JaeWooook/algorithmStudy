package Java.BOJ.BFS;
import java.io.*;
import java.util.*;

public class BOJ_4_1697 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;
        static boolean[] visited = new boolean[100001];
        static int[] distance = new int[100001];

        public static void main(String[] args) throws IOException {
            //bfs 연습문제 boj 1697
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            /**
             * 1. 수빈이는 n, 동생은 m 일때 수빈이는 +1, -1, *2 이동할수있다.
             * 2. 수빈이가 더큰지 동생이 더큰지 알아보자
             * 3. 수빈이가 더클때만 -1해준다.
             * 4. *2를해서 빼는게 가장 빠르게 찾는 방법이다.
             * 6. distance배열 1차원 만들어서 최단거리를 찾는다.
             *
             * 5 17
             *
             * 5-10-9-18-17 = 4
             *
             * 5 6 7 8 9 10
             * 0 1 2 3 4  1
             */

            if(n != m) {
                bfs(n,m);
                sb.append(distance[m]);
            } else {
                sb.append(0);
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void bfs(int n, int m) {//1 1023틀림
            Queue<Integer> queue = new LinkedList<>();
            queue.add(n);
            while(!queue.isEmpty()) {
                int current = queue.poll();

                if(current == m) {
                    break;
                }

                if(current < 100000) {
                    if(!visited[current+1]) {
                        plus(current);
                        queue.add(current+1);
                        visited[current+1] = true;
                    }
                }

                if(current > 0) {
                    if(!visited[current-1]) {
                        minus(current);
                        queue.add(current-1);
                        visited[current-1] = true;
                    }
                }

                if(0<current && current <= 100000/2) {
                    if(!visited[current*2]) {
                        multi2(current);
                        queue.add(current*2);
                        visited[current*2] = true;
                    }
                }
            }
        }

        static void plus(int x) {
            if(distance[x+1] > 0) {
                distance[x+1] = Math.min(distance[x+1], distance[x]+1);
            } else {
                distance[x+1] = distance[x]+1;
            }
        }

        static void minus(int x) {
            if(distance[x-1] > 0) {
                distance[x-1] = Math.min(distance[x-1], distance[x]+1);
            } else {
                distance[x-1] = distance[x]+1;
            }
        }

        static void multi2(int x) {
            if(distance[x*2] > 0) {
                distance[x*2] = Math.min(distance[x*2], distance[x]+1);
            } else {
                distance[x*2] = distance[x]+1;
            }
        }
    }
}
