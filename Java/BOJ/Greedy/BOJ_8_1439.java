package Java.BOJ.Greedy;
import java.io.*;
import java.util.*;

public class BOJ_8_1439 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //greedy 기본문제 boj 1439
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            String str = readLine();

            /**
             * 1. 문자를 뒤집는다. 0과 1만 존재한다.
             * 2. 최소의 개수로 뒤집는 방법을 찾아야한다.
             * 3. 더많이 연속된것의 개수와 더 적은 개수를 찾아야한다 1과 0중에
             *
             * 0001100
             */
            if(isZero(str)) {
                sb.append(0);
            } else {
                int zeroCnt = 0;
                int oneCnt = 0;
                char[] charArr = str.toCharArray();
                char prevChar = charArr[0];

                for(int i=1; i<charArr.length; i++) {
                    if(prevChar != charArr[i]) {
                        if(prevChar == '0') {
                            zeroCnt++;
                        } else {
                            oneCnt++;
                        }
                        prevChar = charArr[i];
                    }

                    if(i == charArr.length-1) {
                        if(charArr[i] == '0') {
                            zeroCnt++;
                        } else {
                            oneCnt++;
                        }
                    }
                }

                sb.append(Math.min(zeroCnt, oneCnt));
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static boolean isZero(String str) {
            char[] chars = str.toCharArray();
            char first = chars[0];
            for(int i=1; i<chars.length; i++) {
                if(first != chars[i]) {
                    return false;
                }
            }

            return true;
        }

        static String readLine() throws IOException {
            return br.readLine();
        }
    }
}
