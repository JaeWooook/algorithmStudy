package Java.BOJ.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13_10825 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //정렬2 기본문제 boj 10825
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine()); // 학생 수 (12)

            // 이름 + 점수 3개 → 총 4칸
            String[][] data = new String[n][4];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                data[i][0] = st.nextToken(); // 이름
                data[i][1] = st.nextToken(); // 국어
                data[i][2] = st.nextToken(); // 영어
                data[i][3] = st.nextToken(); // 수학
            }
            /**
             * 12
             * Junkyu 50 60 100
             * Sangkeun 80 60 50
             * Sunyoung 80 70 100
             * Soong 50 60 90
             * Haebin 50 60 100
             * Kangsoo 60 80 100
             * Donghyuk 80 60 100
             * Sei 70 70 70
             * Wonseob 70 70 90
             * Sanghyun 70 70 80
             * nsj 80 80 80
             * Taewhan 50 60 90
             *
             * 1.국어점수는 내림차순
             * 2.국어점수가 같으면, 영어점수는 오름차순
             * 3.국어점수,영어점수모두가 같으면 수학점수는 내림차순
             * 4.모든점수가 같으면 이름 사전순
             * String인 2차원 배열을 만들어야한다.
             */

            Arrays.sort(data, (a,b) -> {
                int korA = Integer.parseInt(a[1]);
                int korB = Integer.parseInt(b[1]);
                int engA = Integer.parseInt(a[2]);
                int engB = Integer.parseInt(b[2]);
                int mathA = Integer.parseInt(a[3]);
                int mathB = Integer.parseInt(b[3]);

                if(korA != korB) return korB - korA;
                if(engA != engB) return engA - engB;
                if(mathA != mathB) return mathB - mathA;
                return a[0].compareTo(b[0]);
            });

            for(String[] word : data) {
                sb.append(word[0]).append("\n");
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
