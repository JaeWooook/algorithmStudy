package Java.BOJ.String;
import java.io.*;
import java.util.*;

public class BOJ_9_17413 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //string 기본문제 boj 17413
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            String str = readLine();

            /**
             * 1. 문자열 a~z , 0~9, ' '공백, <,>로 이루어졌다.
             * 2. 시작과 끝은 공백이아니다.
             * 3. <>에서 동일하게 열고닫는다. 길이가 3이상인 부분 문자열이고, 알파벳소문자와 공백만 있다.
             * 4. 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이다.
             * 5. 두단어는 공백 하나로 구분, 태그는 단어가 아니고, 태그와 단어 사이에는 공백이없다.
             * 6. 단어만 뒤집는다. 태그는 뒤집지 않는다.
             * 7. 스택을사용한다. 태그형태는 닫을때까지 그대로 sb에 넣는다.
             * 8. 태그가 아니라면 스택에넣는다. 띄어쓰기를 만나면 스택에있는 단어들을 전부 sb에 넣어준다 빌때까지
             *
             * baekjoon online judge
             */

            boolean isSkip = false;
            boolean skipEnd = false;
            Deque<Character> stack = new ArrayDeque<>();
            char[] word = str.toCharArray();
            for(int i=0; i<word.length; i++) {
                if(word[i] == '<') {
                    isSkip = true;
                }
                if(word[i] == '>') {
                    skipEnd = true;
                }

                if(isSkip) {
                    sb.append(word[i]);
                    if(skipEnd) {
                        isSkip = false;
                        skipEnd = false;
                    }
                } else {//여기는 단어이다.
                    if(word[i] != ' ') {
                        stack.push(word[i]);
                    }
                }

                if((!isSkip && word[i] == ' ') || (!isSkip && i == word.length - 1) || (!isSkip && i+1 < word.length && word[i+1] == '<')
                ) {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }

                    if(word[i] == ' ') sb.append(word[i]);
                }
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static String readLine() throws IOException {
            return br.readLine();
        }
    }
}
