package Java.BOJ.Queue;
import java.io.*;
import java.util.*;

public class BOJ_2_1158 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;
        static Deque<Integer> que = new ArrayDeque<>();

        public static void main(String[] args) throws IOException {
            //queue 기본문제 boj 1158
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            /**
             * 1. 요세푸스 문제, 1번부터 N번까지 원을 이루어 앉았다.
             * 2. 이제 순서대로 K번째 사람을 제거한다. 한사람이 제거되면 남은사람들로 이루어진 원을 따라 이 과정을 계속
             * 3. 1 2 3 4 5 6 7 -> 3 6 2 ... 각각의 3번째를 다추출한다. 이게 빌때까지 인거닌까.
             * 4. queue를 이용해서 isEmpty가 될때까지 while문을 통해서 poll poll poll3번하는데 마지막 poll에만 값을 배열에 넣고,
             * 5. 나머지 2개 poll은 다시 뒤로 넣으면된다.
             *
             * 7 3
             * <3, 6, 2, 7, 5, 1, 4>
             */

            int[] arr = new int[n];
            for(int i=1; i<=n; i++) {
                que.add(i);
            }
            int idx = 0;

            while(!que.isEmpty()) {
                for(int i=0; i<m-1; i++) {
                    int back = que.pollFirst();
                    que.addLast(back);
                }
                arr[idx] = que.pollFirst();
                idx++;
            }

            sb.append("<");
            for(int i=0; i<n; i++) {
                sb.append(arr[i]);
                if(i < n-1) {
                    sb.append(", ");
                }
            }
            sb.append(">");

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
    }
}
