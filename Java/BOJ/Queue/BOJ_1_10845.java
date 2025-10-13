package Java.BOJ.Queue;
import java.io.*;
import java.util.*;


public class BOJ_1_10845 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;
        static Deque<Integer> que = new ArrayDeque<>();

        public static void main(String[] args) throws IOException {
            //queue 연습문제 boj 10845
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용

            /**
             * 1. pop가장 앞에있는 정수를 빼고, 출력 없는경우 -1
             * 2. front 큐의 가장 앞 정수 출력 없는경우 -1
             * 3. back 큐의 가장 뒤의 정수를 출력, 없는경우 -1
             * 4. 나머지는 아는것과 동일
             *
             * 15
             * push 1
             * push 2
             * front
             * back
             * size
             * empty
             * pop
             * pop
             * pop
             * size
             * empty
             * pop
             * push 3
             * empty
             * front
             */

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                switch (str) {
                    case "push":
                        int x = Integer.parseInt(st.nextToken());
                        que.addLast(x);
                        break;
                    case "front":
                        if(que.isEmpty()) {
                            sb.append(-1).append("\n");
                        } else {
                            sb.append(que.peekFirst()).append("\n");
                        }
                        break;
                    case "back":
                        if(que.isEmpty()) {
                            sb.append(-1).append("\n");
                        } else {
                            sb.append(que.peekLast()).append("\n");
                        }
                        break;
                    case "pop":
                        if(que.isEmpty()) {
                            sb.append(-1).append("\n");
                        } else {
                            sb.append(que.pollFirst()).append("\n");
                        }
                        break;
                    case "size":
                        sb.append(que.size()).append("\n");
                        break;
                    case "empty":
                        if(que.isEmpty()) {
                            sb.append(1).append("\n");
                        } else {
                            sb.append(0).append("\n");
                        }
                        break;
                    default:
                        break;
                }
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }
    }
}
