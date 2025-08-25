package Java.BOJ.Exhaustive_Search.Brute_Force;
import java.io.*;
import java.util.*;

public class BOJ_5_19532 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //브루드포스 연습문제 boj 19532
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            int[] arr1 = readIntArray(6); // 1차원 배열 사용
            /**
             * 1. x와 y는 -999 부터 999이다. 각각을 전부 대입해서 찾는다?
             * 2. 그게 브루드 포스의 역할이긴한데 나는 왠지 연립방정식을 고민해보고싶은데?
             * 3. 브루드 포스 2가지의 식을 모두 만족하는 x y를 찾아보자
             *
             * 1 3 -1
             * 4 1  7
             *
             */
            int x = -999;
            int y = 999;
            int a = arr1[0];
            int b = arr1[1];
            int c = arr1[2];

            int d = arr1[3];
            int e = arr1[4];
            int f = arr1[5];

            // x + 3y = -1
            // 4x + y = 7

            // 2x + 5y = 8
            // 3x - 4y = -11
            for(int i=-999; i<= 999; i++) {
                for(int j= -999; j<= 999; j++) {
                    if((a*i) + (b*j) == c && (d*i) + (e * j) == f) {
                        x = i;
                        y = j;
                        break;
                    }
                }
            }

            sb.append(x).append(" ").append(y);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int[] readIntArray(int size) throws IOException {//한칸씩 띄어쓰기 되어있는것
            int[] arr = new int[size];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            return arr;
        }
    }
}
