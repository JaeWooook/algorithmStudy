package Java.BOJ.String;
import java.io.*;
import java.util.*;

public class BOJ_3_2999 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //string 기본문제 boj 2999
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            String str = readLine();

            /**
             * 1. 글자의 길이 N개 열이 C개인 행렬을만드는데
             * 2. 행이 R개 R<=C이고, R*C = N인 행렬 근데 R이 더 큰경우를 고른다.
             * 3. 1 <= 3으로시작해야한다. 1*3 = 3이고, 더이상의 나눗셈은 불가하다. 2가되어서 무언갈곱해서 3이되는 수는 없다.
             * 4. koaski로 하면 6개 3*2가 R이 가장크다. 하지만 C가 더커야한다. 2*3이된다.
             * k a k
             * o s i
             *
             * -> kakosi가된다.
             *
             * bok -> bok
             * koaski -> kakosi
             * boudonuimilcbsai -> bombonisuuladici
             */
            int lenN = str.length();
            int r = 1;
            int c = lenN;
            int resultR = 0;
            int resultC = 0;

            while(r<=c) {
                if(r*c == lenN) {
                    resultR = r;
                    resultC = c;
                    r++;
                    c--;
                } else if(r*c > lenN) {
                    c--;
                } else {
                    r++;
                }
            }

            String[][] password = new String[resultR][resultC];
            char[] chars = str.toCharArray();
            int idx=0;
            for(int i=0; i<resultC; i++) {
                for(int j=0; j<resultR; j++) {
                    password[j][i] = String.valueOf(chars[idx]);
                    idx++;
                }
            }

            for(int i=0; i<resultR; i++) {
                for(int j=0; j<resultC; j++) {
                    sb.append(password[i][j]);
                }
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static String readLine() throws IOException {
            return br.readLine();
        }
    }
}
