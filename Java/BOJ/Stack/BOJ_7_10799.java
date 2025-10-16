package Java.BOJ.Stack;
import java.io.*;
import java.util.*;

public class BOJ_7_10799 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static Deque<Character> stack = new ArrayDeque<>();

        public static void main(String[] args) throws IOException {
            //stack 기본문제 boj 10799
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            String str = readLine();

            /**
             * 1. 인접한 ()쌍일때만 레이저이다.
             * 2. 쇠막대기의 왼쪽끝은 여는괄호, 오른쪽끝은 닫는괄호이다. 겹겹이쌓을수있다.
             * 3. 잘린 총 쇠막대기의 개수를 출력한다.
             * 4. 레이저를 만난다 stack 에 push하다가, )인데 넣을려는게 peek도 (라면 그건 레이저가된다.
             * 5. 레이저를 만났을때 현재 막대기가 몇개인지 자를? 개수를 해주면된다. (를 만나면 개수를 +1해주고,
             * 6. 레이저를 만나면,stack에 있는 사이즈만큼 해주면될듯하다.?
             * 7. )를 만나면 pop시킬것이기 때문에
             *
             * () ((( () () )( () ) () )) (())
             */
            char[] chars = str.toCharArray();
            int cnt = 0;
            boolean previewOpen = false;
            for(int i=0; i<chars.length; i++) {
                if('(' == chars[i]) {
                    stack.push('(');
                    previewOpen = true;
                } else {
                    if(previewOpen) {
                        stack.pop();
                        cnt+=stack.size();
                    } else {
                        stack.pop();
                        cnt++;
                    }
                    previewOpen = false;
                }
            }

            sb.append(cnt);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static String readLine() throws IOException {
            return br.readLine();
        }
    }
}
