package Java.BOJ.Stack;
import java.io.*;
import java.util.*;

public class BOJ_5_9012 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static Deque<Character> stack = new ArrayDeque<>();

        public static void main(String[] args) throws IOException {
            //stack 기본문제 boj 9012
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            String[] strArr = readStringArray(n); // 문자열

            /**
             * 1. 괄호 짝이맞으면 YES 아니면 NO
             * 2. 스택에 넣으면서 하는게 편할듯 하다. 넣으면서 비교한다. isEmpty인경우 YES이고 아닌경우 NO로
             * 3. 넣으면서 짝이 맞는 ")"이 나오면 pop하는것으로한다.
             *
             * 6
             * ( ( ) ) ( ) )
             * (((()())()
             * (()())((()))
             * ((()()(()))(((())))()
             * ()()()()(()()())()
             * (()((())()(
             */

            for(int i=0; i<strArr.length; i++) {
                char[] VPSs = strArr[i].toCharArray();
                boolean byPass = false;
                for(int j=0; j< VPSs.length; j++) {
                    if(j==0 || stack.isEmpty()) {
                        if('(' == VPSs[j]) {
                            stack.push(VPSs[j]);
                        } else {
                            byPass = true;
                            break;
                        }
                    } else {
                        if('(' == VPSs[j]) {
                            stack.push(VPSs[j]);
                        } else {
                            if(stack.peekLast() == '(') {
                                stack.pop();
                            } else {
                                stack.push(VPSs[j]);
                            }
                        }
                    }

                }

                if(byPass) {
                    sb.append("NO").append("\n");
                } else {
                    if(stack.isEmpty()) {
                        sb.append("YES").append("\n");
                    } else {
                        sb.append("NO").append("\n");
                    }
                }
                stack.clear();
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
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
