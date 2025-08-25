package Java.BOJ.Exhaustive_Search.Brute_Force;
import java.io.*;
import java.util.*;

public class BOJ_3_2231 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //브루드포스 연습문제 boj 2231
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(st.nextToken());

            /**
             * 1. 198 + 1 + 9 + 8 = 216
             * 2. 1부터 시작해서 그자체와 각각의 자리수를 더하는 로직을 만들고 하면될듯 개수를 정해야하는데 일단.
             * 3. con을 문자열로 변환해서 길이를 구해서 그것만큼의 배열을만든다?
             * 4. 그리고 그 배열 만큼의 반복을 한다?
             * 5. 굳이그렇게 안해도되긴하는데
             * 6. 각각의 나머지를 계속만들어주면된다.
             * 216
             */

            int con = 0;
            int answer = 0;
            int sample = 0;

            while(con<=n) {
                con++;
                sample = 0;

                if(con > 10) {
                    sample += con%10; // 198일때 8이 남지
                    int divVal = con/10; // 19남고
                    sample += con;
                    while(divVal > 10) {
                        sample += divVal % 10; // 다시 9남고
                        divVal /= 10; // 1남고
                    }
                    sample += divVal;
                } else {
                    sample = con + con;
                }

                if(sample == n) {
                    answer = con;
                    break;
                }
            }

            sb.append(answer);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
    }
}
