package Java.BOJ.Stack;
import java.io.*;
import java.util.*;
public class BOJ_1_10828 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;
        static Stack<Integer> stack = new Stack<>();

        public static void main(String[] args) throws IOException {
            //stack 연습문제 boj 10828
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            /**
             * 1. push x는 정수 x를 스택에 넣는연산
             * 2. pop은 스택에서 가장 위에 있는
             *
             * 14
             * push 1
             * push 2
             * top
             * size
             * empty
             * pop
             * pop
             * pop
             * size
             * empty
             * pop
             * push 3
             * empty
             * top
             */

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                if(a.equals("push")) {
                    int m = Integer.parseInt(st.nextToken());
                    stack.push(m);
                } else if(a.equals("top")) {
                    if(stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
                } else if(a.equals("pop")) {
                    if(stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                } else if(a.equals("size")) {
                    sb.append(stack.size()).append("\n");
                } else if(a.equals("empty")) {
                    if(stack.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                }

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
