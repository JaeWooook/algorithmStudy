package Java.BOJ.String;
import java.io.*;
import java.util.*;

public class BOJ_6_6550 {

    public class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //string 기본문제 boj 6550
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            /**
             * 1. 2개의 문자열 s와 t가 있을때, 부분 문자열을 가지고 있는지 판단하는 방법 t에서 몇개의 문자를 제거한다.
             * 2. 순서를 바꾸지않고, 합치는경우 s가되는지 확인
             * 3. s와 t를 한글자씩 char형태로 나눈다. 그리고, 순서대로 각각의 글자들이 있는지를 확인한다.
             * 4. s의 끝까지 갔다면 합격 Yes, s의 끝글자까지 못찾은다면, No
             *
             * sequence subsequence
             * person compression
             * VERDI vivaVittorioEmanueleReDiItalia
             * caseDoesMatter CaseDoesMatter
             */

            String line;
            while((line = br.readLine()) != null) {
                String[] str = line.split(" ");
                String s = str[0];
                String t = str[1];
                char[] sChars = s.toCharArray();
                char[] tChars = t.toCharArray();

                StringBuilder sbt = new StringBuilder();
                int idx = 0;
                for(int i=0; i<tChars.length; i++) {
                    if(sChars[idx] == tChars[i]) {
                        sbt.append(sChars[idx]);
                        idx++;
                        if(idx >= sChars.length) break;
                    }
                }

                if(sbt.toString().equals(s)) {
                    sb.append("Yes").append("\n");
                } else {
                    sb.append("No").append("\n");
                }
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
    }
}
