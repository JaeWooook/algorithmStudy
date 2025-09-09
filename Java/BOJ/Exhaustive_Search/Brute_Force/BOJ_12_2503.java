package Java.BOJ.Exhaustive_Search.Brute_Force;
import java.io.*;
import java.util.*;

public class BOJ_12_2503 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;
        static int cnt = 0;
        static boolean[] visited = new boolean[10];

        public static void main(String[] args) throws IOException {
            //브루드포스 기본문제 boj 2503
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[][] arr2 = readInt2DArray(n, 3); // 2차원 배열

            /**
             * 1.숫자 야구 위치와 숫자가 일치하면 스트라이크, 숫자만 일치하면 볼이다.
             * 2.2가 출력 되는 이유가 뭐지? 남은 경우의 수가 328 324뿐이라서?
             * 3.볼이된 숫자 3개를 기억하고, 스트라이크가된 숫자 3개를 기억 한다.
             * 4.서로다른숫자의 3개를 만들고, 각조건에 부합하는지를 전부 확인하는 경우의 애들만 남기면된다.?
             *
             * 4
             * 123 1 1
             * 356 1 0
             * 327 2 0 -> 3까지는 ok인데 3 7이고 2가 아닐수도?있는거아닌가 하기엔 1차에 2가 볼임을 유추할수있다.
             * 489 0 1
             * -> 2
             */
            int[] comb = new int[3];

            combination(arr2, 0, 3, comb);
            sb.append(cnt);

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void combination(int[][] arr2, int depth, int k, int[] comb) {
            if(depth == k) {//뽑힌 애들로 arr2를 통해서 검증한다. 생존인가? 아닌가
                boolean success = true;
                for(int i=0; i<arr2.length; i++) {
                    //포함되었다면 볼 자리까지 일치한다면 스트라이크 스트라이크 1번, 볼 2번
                    String testNum = String.valueOf(arr2[i][0]);
                    char[] testChar = testNum.toCharArray();
                    int testBall = 0;
                    int testStrike = 0;

                    //포함되면서 자리수는 아닐때 볼처리
                    for(int j=0; j<comb.length; j++) {
                        if(testNum.indexOf(String.valueOf(comb[j])) > -1 && Integer.parseInt(String.valueOf(testChar[j])) != comb[j]) {
                            testBall++;
                        }

                        if(Integer.parseInt(String.valueOf(testChar[j])) == comb[j]) {
                            testStrike++;
                        }
                    }

                    if(testBall != arr2[i][2] || testStrike != arr2[i][1]) {
                        success = false;
                        break;
                    }
                }
                if(success) {
                    cnt++;
                }

                return;
            }

            for(int i=1; i<10; i++) {
                if(!visited[i]) {
                    comb[depth] = i;
                    visited[i] = true;
                    combination(arr2, depth+1, k, comb);
                    visited[i] = false;
                }
            }
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static int[][] readInt2DArray(int rows, int cols) throws IOException {
            int[][] arr = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            return arr;
        }
    }
}
