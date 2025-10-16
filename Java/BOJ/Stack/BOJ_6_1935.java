package Java.BOJ.Stack;
import java.io.*;
import java.util.*;

public class BOJ_6_1935 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static Deque<Double> stack = new ArrayDeque<>();

        public static void main(String[] args) throws IOException {
            //stack 기본문제 boj 1935
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용

            String str = readLine();

            /**
             * 1. 후위 표기식
             * 2. 셋째줄부터 N+2까지 각 피연산자에 대응하는 값이 주어진다.
             * 3. 세번째는 A에 해당하는값 4번째는 B에 대응값은 100보다 작거나 같다.
             * 4. 출력은 소숫점 2째자리까지
             * 5. A,1 B,2를 어떻게 매칭시킬 것인가.
             * 6. 배열에 A,B,C .. Z까지 알파벳을 넣고
             * 7. 다른 배열은 1,2,3,4,5,6,7,8.. 26을 넣자
             *
             * 5
             * ABC*+DE/-
             * 1
             * 2
             * 3
             * 4
             * 5
             *
             * ABC * 왔으닌까 BC꺼내서 계산 매칭 해서 -> 이 BC계산값을 다시 넣어줘야하는데
             *
             * -> 6.20
             */
            String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            double[] matching = new double[n];
            for(int i=0; i<n; i++) {
                matching[i] = readInt();
            }
            double result = 0;
            char[] alphabet = str.toCharArray();

            for(int i=0; i<alphabet.length; i++) {
                if('*' == alphabet[i] || '+' == alphabet[i] || '/' == alphabet[i] || '-' == alphabet[i]) {
                    double val2 = stack.pop();
                    double val1 = stack.pop();
                    double tmp = 0;

                    switch (alphabet[i]) {
                        case '*' :
                            tmp = val1*val2;
                            break;
                        case '+' :
                            tmp = val1+val2;
                            break;
                        case '/' :
                            tmp = val1/val2;
                            break;
                        case '-':
                            tmp = val1-val2;
                            break;
                        default:
                            break;
                    }
                    stack.push(tmp);
                }

                if(Character.isAlphabetic(alphabet[i])) {
                    int idx = abc.indexOf(alphabet[i]);
                    stack.push(matching[idx]);
                }
            }

            result = stack.pop();
            sb.append(String.format("%.2f", result));

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static String readLine() throws IOException {
            return br.readLine();
        }
    }
}
