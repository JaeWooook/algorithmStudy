package Java.BOJ.Sort;

import java.io.*;
import java.util.*;

public class BOJ_7_1431 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //정렬2 연습문제 boj 1431
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            // ===== 예시 사용 =====
            int n = readInt(); // 단일 정수 사용
            String[] answer = readStringArray(n); // 문자열 배열

            /**
             * 1. 길이짧은 것 먼저 양수올수있도록 해줘야한다.
             * 2. 길이 같을 때 숫자인 것만 합산한다. Character.isDigit 사용해서 구분하고 덧셈해서 비교
             * 3. 나머지는 사전순비교, 숫자가 알파벳보다 사전순으로 작다.
             *
             * 5
             * ABCD
             * 145C
             * A
             * A910
             * Z321
             */

            Arrays.sort(answer, (a,b) -> {
                if(a.length() != b.length()) {
                    return a.length() - b.length();
                } else {
                    int aSum = 0;
                    int bSum = 0;

                    char[] aChar = a.toCharArray();
                    char[] bChar = b.toCharArray();

                    for(int i=0; i<aChar.length; i++) {
                        if(Character.isDigit(aChar[i])) {
                            aSum+=Integer.parseInt(String.valueOf(aChar[i]));
                        }
                        if(Character.isDigit(bChar[i])) {
                            bSum+=Integer.parseInt(String.valueOf(bChar[i]));
                        }
                    }

                    if(aSum - bSum == 0) { //사전순
                        return a.compareTo(b);
                    }

                    return aSum - bSum;
                }
            });

            for (String s : answer) sb.append(s).append("\n");

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
