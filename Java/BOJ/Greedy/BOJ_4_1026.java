package Java.BOJ.Greedy;
import java.io.*;
import java.util.*;

public class BOJ_4_1026 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //그리디 연습문제 boj 1026
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[] arr1 = readIntArray(n);
            int[] arr2 = readIntArray(n);

            /**
             * 1. S = A[0] * B[0] + ... + A[N-1] * B[N-1]
             * 2. S의 값을 가장 작게 만들기 위해 A의 수를 재배열한다. B는 재배열하면안된다.
             * 3. S의 최솟 값을 출력
             * 4. A랑 B랑 들어있는 것을 일단 list로 만들어서, B가 제일 큰 곳에 A의 가장 작은 값이 가도록 정렬한다.
             *
             * 5
             * 1 1 1 6 0 -> A
             * 2 7 8 3 1 -> B
             *
             * 1 1 0 1 6
             * 2 7 8 3 1
             * -> 2 + 7 + 0 + 3 + 6 = 18
             */
            Integer[] arrB = Arrays.stream(arr2).boxed().toArray(Integer[]::new);
            Arrays.sort(arrB, (a,b) -> b-a);
            Arrays.sort(arr1);
            int result = 0;
            for(int i=0; i<arr1.length; i++) {
                result += arr1[i] * arrB[i];
            }

            sb.append(result);
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
