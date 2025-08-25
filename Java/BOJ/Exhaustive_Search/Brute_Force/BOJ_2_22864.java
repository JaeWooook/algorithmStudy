package Java.BOJ.Exhaustive_Search.Brute_Force;
import java.io.*;
import java.util.*;

public class BOJ_2_22864 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //브루드포스 연습문제 boj 22864
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            /**
             * 1. 1시간 이라도 일하면 피로도 n만큼, 일은 m만큼 처리가능
             * 2. 1시간을 쉬면 c만큼 줄어들고, 피로도는 음수가 아니라 0이다.
             * 3. 피로도가 최대한 d를 넘기지 않게 일하려한다.
             * 4. 초기 피로도는 0이다.
             *
             * 우선 stress가 d가 넘지 않을때까지 일을 시킨다. 넘는다고 판단되면? 1시간씩 쉬게해서 c로 빼준다.
             * 1시간 일하고 5 생기고, 3이쌓이고, 1시간하고 5쌓이고, 다시 일은 6되고, 피로도 10 되고 다음것은 넘게되서 쉬게된다.
             * -2 -2 -2를 하고나서야 2시간일하고 3시간쉬고 반복이네, 24
             * 5 3 2 10
             */
            int hour = 24;
            int jobT = 0;
            int stress = 0;

            while(hour > 0) {
                jobT += m;
                stress += n;

                if(stress > d) {
                    stress -= n;
                    jobT -= m;
                    stress -= c;
                    if(stress < 0) {
                        stress = 0;
                    }
                }
                hour--;
            }

            sb.append(jobT);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
    }
}
