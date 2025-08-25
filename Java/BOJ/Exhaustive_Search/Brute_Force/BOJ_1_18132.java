package Java.BOJ.Exhaustive_Search.Brute_Force;
import java.io.*;
import java.util.*;

public class BOJ_1_18132 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //브루드포스 연습문제 boj 18312
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            /**
             * 1.5시 59분 59초까지 계산 한다.
             * 2.0시 00분 00초 부터 시작한다.
             * 3.시계 카운팅하는 로직을 만들어야한다.
             * 4.3이 들어갔다면, 어떻게 알수있지?
             *
             * 5 3
             */

            int hour = 0;
            int min = 0;
            int sec = 0;
            int kCnt = 0;

            while(hour <= n && min <= 59 && sec <= 59) {

                sec++;

                if(sec == 60) {
                    min++;
                    sec = 0;
                }

                if(min == 60) {
                    hour++;
                    min = 0;
                }

                if(hour == 24) {
                    break;
                }

                int sec1 = sec % 10;
                int sec10 = sec / 10;
                int min1 = min % 10;
                int min10 = min / 10;
                int hour1 = hour % 10;
                int hour10 = hour / 10;

                if(sec1 == m || sec10 == m || min1 == m || min10 == m || hour1 == m || hour10 == m) {
                    kCnt++;
                }
            }

            sb.append(kCnt);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
    }
}
