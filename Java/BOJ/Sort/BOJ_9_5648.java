package Java.BOJ.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9_5648 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //정렬2 기본문제 boj 5648
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            // 첫 번째 값은 n (전체 원소 개수)
            int n = Integer.parseInt(st.nextToken());

            // 결과를 저장할 배열
            long[] arr = new long[n];
            int idx = 0;

            // 첫 줄에 n 다음 값들부터 처리
            while (st.hasMoreTokens()) {
                arr[idx++] = Long.parseLong(st.nextToken());
            }

            // 이후 줄 입력
            while (idx < n) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    arr[idx++] = Long.parseLong(st.nextToken());
                }
            }

            /**
             * 1. 문자열로 순서를 뒤집고 long타입으로 전환하면서 앞에 0인경우는 알아서 삭제되게된다.
             * 2. 멀티스레드 환경이 아님으로 속도가 가장 빠른 StringBuilder를 사용
             */

            long[] answer = new long[arr.length];
            for(int i=0; i<arr.length; i++) {
                String tmp = String.valueOf(arr[i]);
                char[] trans = tmp.toCharArray();

                StringBuilder sbd = new StringBuilder();
                for(int j=trans.length-1; j>=0; j--) {
                    sbd.append(trans[j]);
                }

                answer[i] = Long.parseLong(sbd.toString());
                sbd.setLength(0);
            }

            Arrays.sort(answer);
            for(long ans : answer) {
                sb.append(ans+"\n");
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
    }
}
