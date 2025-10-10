package Java.BOJ.Stack;
import java.io.*;
import java.util.*;

public class BOJ_3_1874 {

    public static class Main {
        static BufferedReader br;
        static BufferedWriter bw;
        static Stack<Integer> stack = new Stack<>();

        public static void main(String[] args) throws IOException {
            //stack 응용문제 boj 1874
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[] arr1 = readIntLineByArray(n); // 1차원 배열 사용

            /**
             * 1. 같은 정수가 2번 나오는일은 없다.
             * 2. 4 3 6 8 은 전부 ++++이다. --두개한다면
             * 3. 4 3 이되고, 다시 4 3 7 5 -하나하면
             * 4. 4 3 7 이 되고 2 1 을 넣고
             * 5. 4 3 7 2 1 이된다. 를 전부 마이너스한다?
             * 6. 1부터 N까지 넣어준다. N은 100,000이다.
             *
             * 8
             * 4
             * 3
             * 6
             * 8
             * 7
             * 5
             * 2
             * 1
             */
            Queue<Integer> suyeol = new LinkedList<>();
            for(int i=0; i<n; i++) {
                suyeol.add(arr1[i]);
            }

            int[] arr2 = new int[n];
            int idx = 0;
            for(int i=1; i<=n+1; i++) {
                while(!stack.isEmpty() && stack.peek().equals(suyeol.peek())) {
                    arr2[idx] = stack.pop();
                    suyeol.poll();
                    idx++;
                    sb.append("-").append("\n");
                }
                if(i<=n) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
            }

            for(int i=0; i<n; i++) {
                if(arr2[i] != arr1[i]) {
                    sb.setLength(0);
                    sb.append("NO");
                }
            }

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
