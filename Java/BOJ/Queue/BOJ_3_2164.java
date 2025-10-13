package Java.BOJ.Queue;
import java.io.*;
import java.util.*;

public class BOJ_3_2164 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static Deque<Integer> que = new ArrayDeque<>();

        public static void main(String[] args) throws IOException {
            //queue 기본문제 boj 2164
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            /**
             * 1. 1번 카드가 제일 위, N번 카드가 제일 아래 상태로
             * 2. 제일 위에 있는 카드를 바닥에 버린다. 그다음 제일 위에 카드를 제일 아래 카드 밑으로 옮긴다.
             * 3. 1개가 size가 될때까지 하는것이다. 이행동을
             *
             * 6
             */
            for(int i=1; i<=n; i++) {
                que.addLast(i);
            }

            while(que.size() > 1) {
                que.removeFirst();
                int sec = que.removeFirst();
                que.addLast(sec);
            }

            sb.append(que.pollFirst());

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }
    }
}
