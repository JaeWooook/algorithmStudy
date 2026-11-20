package Java.BOJ.Hash;
import java.io.*;
import java.util.*;

public class BOJ_8_14425 {

    public static class Main {
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //Hash 기본문제 boj 14425 (하 / 실버4)
            //https://www.acmicpc.net/problem/14425
            //https://testcase.ac/problems/boj/14425
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            /**
             * [문자열 집합] 집합 S에 N개의 문자열, 검사할 문자열 M개 중 S에 포함된 것의 개수 출력
             * 입력: N M / S의 문자열 N줄 / 검사 문자열 M줄 (각 길이 500 이하, 소문자)
             * 포인트: HashSet 또는 HashMap contains
             */
            int[] nm = readInts();
            int n = nm[0], m = nm[1];
            String[] setStr = readStringArray(n);
            String[] query = readStringArray(m);

            // TODO 풀이
            int result = 0;
            Map<String, Integer> map = new HashMap<String, Integer>();

            for(String str : query) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }

            for(String str2 : setStr) {
                if(map.containsKey(str2)) {
                    result += map.get(str2);
                }
            }

            sb.append(result);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        // ===== 공통 입력 메서드 (복붙용) =====
        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine().trim());
        }

        static String readLine() throws IOException {
            return br.readLine();
        }

        static int[] readInts() throws IOException { // 한 줄에 띄어쓰기로 구분된 정수 전부
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[st.countTokens()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            return arr;
        }

        static int[] readIntArray(int size) throws IOException { // 한 줄에 size개
            int[] arr = new int[size];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            return arr;
        }

        static String[] readStringArray(int size) throws IOException { // size줄
            String[] arr = new String[size];
            for (int i = 0; i < size; i++) {
                arr[i] = br.readLine();
            }
            return arr;
        }

        static String[][] readString2DArray(int rows, int cols) throws IOException { // rows줄, 한 줄에 cols개
            String[][] arr = new String[rows][cols];
            for (int i = 0; i < rows; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = st.nextToken();
                }
            }
            return arr;
        }
    }
}
