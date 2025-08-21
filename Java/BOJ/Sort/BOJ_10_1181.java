package Java.BOJ.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class BOJ_10_1181 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //정렬2 기본문제 boj 1181
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            String[] answer = readStringArray(n); // 문자열 배열

            /**
             * 1.Array.sort를 이용해서 조건을 추가해서 정렬한다.
             * 2.길이가 짧은것을 기준으로 오름차순할수있도록 앞의 길이에서 뒤의길이를 빼준다.
             * 3.같은경우는 compareTo를 이용해서 사전순으로 오름차순으로 진행
             * 4.정렬된 값의 중복을 없애기위해 순서를 지킬수 있도록. LinkedHashSet에 저장한다.
             */

            Arrays.sort(answer, (a,b) -> {
               if(a.length() != b.length()) {
                   return a.length() - b.length();
               } else {
                   return a.compareTo(b);
               }
            });

            LinkedHashSet<String> answers = new LinkedHashSet<>();
            for(String ans : answer) {
                answers.add(ans);
            }

            for (String s : answers) sb.append(s).append("\n");

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static String[] readStringArray(int size) throws IOException {
            String[] arr = new String[size];
            for (int i = 0; i < size; i++) {
                arr[i] = br.readLine();
            }
            return arr;
        }
    }
}
