package Java.BOJ.Greedy;
import java.io.*;
import java.util.*;

public class BOJ_1_11047 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //그리디 연습문제 boj 11047
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr1 = readIntLineByArray(n); // 1차원 배열 사용

            /**
             * 1. 동전은 N종류이고, 그 가치의 합을 K로 만들려하는데, 동전 개수의 최소값
             * 2. 큰순서대로 큰것부터 먹어가면 최소값이 구해진다. 먼저 역순으로 내림차순으로 정렬한다.
             *
             * 10 4200
             * 1
             * 5
             * 10
             * 50
             * 100
             * 500
             * 1000
             * 5000
             * 10000
             * 50000
             */

            Integer[] tmp = Arrays.stream(arr1)
                    .boxed().toArray(Integer[]::new);

            int k = m;
            int answer = 0;
            Arrays.sort(tmp, (a,b) -> b-a);
            for(int i=0; i<tmp.length; i++) {
                int coinCnt = k/tmp[i];
                if(coinCnt > 0) {
                    k -= coinCnt*tmp[i];
                    answer += coinCnt;
                }
            }

            sb.append(answer);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static int[] readIntLineByArray(int size) throws IOException {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            return arr;
        }
    }
}
