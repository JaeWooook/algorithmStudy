package Java.BOJ.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12_11656 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //정렬2 기본문제 boj 11656
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            String str = readLine(); // 문자열
            /**
             * baekjoon
             * 1. 접미사를 가지는 배열을 문자열 1차원 배열 생성
             * 2. Arrays.sort 오름차순정렬 하면된다.
             */
            char[] chaArr = str.toCharArray();
            String[] strArr = new String[str.length()];
            String sbd = "";

            for(int i=chaArr.length -1; i >= 0; i--) {
                sbd = chaArr[i] + sbd;
                strArr[i] = sbd;
            }

            Arrays.sort(strArr);

            for(String word : strArr) {
                sb.append(word).append("\n");
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
