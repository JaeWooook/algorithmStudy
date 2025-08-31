package Java.BOJ.Exhaustive_Search.Brute_Force;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9_1969 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static int min = Integer.MAX_VALUE;

        public static void main(String[] args) throws IOException {
            //브루드포스 기본문제 boj 1969
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String[] strArr = readStringArray(n);

            /**
             * 1. Adenine, Thymine, Guanine, Cytosine 각각 A T G C 중에 아무거나 가진 m의 길이만큼을 뽑는다.
             * 2. 거기에서 주어진 dna와 비교했을때 해밍거리의 각각의 합이 제일 작은 s를 찾고 거리도 반환
             *
             * 📌 올바른 해결 방향
             *
             * BOJ 1969 DNA 문제는 이렇게 풀어야 합니다:
             * 1. 각 열(j=0..m-1)에 대해 A, C, G, T의 등장 빈도를 센다.
             * 2. 가장 많이 나온 문자를 고른다 (동률이면 사전순 A < C < G < T).
             * 3. 그 문자를 해당 열의 정답 DNA로 삼는다.
             * 4. 총 해밍 거리 = N - (그 열에서 선택한 문자의 빈도) 를 모든 열에 대해 합산한다.
             * 복잡도는 O(N * M) → 최대 1000 * 50 = 50,000, 충분히 빠릅니다.
             *
             * 5 8
             * TATGATAC
             * TAAGCTAC
             * AAAGATCC
             * TGAGATAC
             * TAAGATGT
             */

            char[] answer = new char[m];
            int hd = 0;
            for(int col = 0; col<m; col++) {
                int[] count = new int[4]; // A, C, G, T
                for(int row = 0; row < n; row++) {
                    char ch = strArr[row].charAt(col);
                    if(ch == 'A') count[0] ++;
                    else if(ch == 'C') count[1] ++;
                    else if(ch == 'G') count[2] ++;
                    else count[3] ++;
                }

                int max = -1;
                for(int j=0; j<4; j++) {
                    if(count[j] > max) {
                        max = count[j];
                        if(j == 0) {
                            answer[col] = 'A';
                        } else if(j == 1) {
                            answer[col] = 'C';
                        } else if(j == 2) {
                            answer[col] = 'G';
                        } else {
                            answer[col] = 'T';
                        }
                    }
                }
                hd += n-max;
            }

            sb.append(answer).append("\n").append(hd);

            bw.write(sb.toString());
            bw.flush();
            bw.close();
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
