package Java.BOJ.Greedy;
import java.io.*;
import java.util.*;

public class BOJ_5_11399 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //그리디 기본문제 boj 11399
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[] arr1 = readIntArray(n);

            /**
             * 1. 각사람이 필요한 시간의 합 구하는 프로그램. 그냥 오름차순 정렬하고, 더하면끝?
             *
             * 5
             * 3 1 4 3 2
             */
            Arrays.sort(arr1);
            int[] answer = new int[arr1.length];

            int tmp = 0;
            for(int i=0; i<answer.length; i++) {
                tmp+= arr1[i];
                answer[i] = tmp;
            }
            int sum = Arrays.stream(answer).sum();
            sb.append(sum);

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
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
