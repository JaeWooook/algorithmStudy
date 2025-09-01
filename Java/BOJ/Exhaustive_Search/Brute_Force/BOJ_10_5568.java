package Java.BOJ.Exhaustive_Search.Brute_Force;
import java.io.*;
import java.util.*;

public class BOJ_10_5568 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;
        static int cnt = 0;
        static boolean[] visited = new boolean[10];
        static boolean[] duplicated = new boolean[99999999];

        public static void main(String[] args) throws IOException {
            //브루드포스 기본문제 boj 5568
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            int n = readInt(); // 단일 정수 사용
            int m = readInt(); // 단일 정수
            int[] arr1 = readIntLineByArray(n); // 1차원 배열 사용
            /**
             * 1. 4개의 정수가있고 그 4개중에 2개를 이용해서 만들 수 있는 정수의합
             * 2. 일단 순서에 대해 중복 없이 뽑기는 진행 했는데 앞에것을 뽑지못해서 개수가 맞지않는다.
             * 3. 자기자신을 제외하고, 중복 없이 뽑으려면?
             *
             * 4
             * 2
             *
             * 1
             * 2
             * 12
             * 1
             */
            int[] comb = new int[m];
            permutation(arr1, 0, m, comb);
            sb.append(cnt);

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
        static void permutation(int[] arr, int depth, int m, int[] comb) {
            if(depth == m) {
                StringBuilder sbd = new StringBuilder();
                for(int i=0; i<depth; i++) {
                    sbd.append(comb[i]);
                }

                //중복 카운트 되지 않도록
                if(!duplicated[Integer.parseInt(sbd.toString())]) {
                    cnt++;
                    duplicated[Integer.parseInt(sbd.toString())] = true;
                }
                return;
            }

            for(int i=0; i<arr.length; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    comb[depth] = arr[i];
                    permutation(arr, depth+1, m, comb);
                    visited[i] = false;
                }
            }
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
