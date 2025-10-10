package Java.BOJ.Stack;
import java.io.*;
import java.util.*;
public class BOJ_2_10773 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static Stack<Integer> stack = new Stack<>();

        public static void main(String[] args) throws IOException {
            //stack 기본문제 boj 10773
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            /**
             * 1.
             *
             * 4
             * 3
             * 0
             * 4
             * 0
             */

            for(int i=0; i<n; i++) {
                int result = readInt();
                if(result > 0) {
                    stack.push(result);
                } else {
                    stack.pop();
                }
            }

            if(!stack.isEmpty()) {
                int sum = 0;
                while(!stack.isEmpty()) {
                    int tmp = stack.pop();
                    sum+=tmp;
                }
                sb.append(sum);
            } else {
                sb.append(0);
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }
    }
}
