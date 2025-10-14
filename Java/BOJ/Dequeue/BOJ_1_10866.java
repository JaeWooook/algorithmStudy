package Java.BOJ.Dequeue;
import java.io.*;
import java.util.*;

public class BOJ_1_10866 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static Deque<Integer> deck = new ArrayDeque<>();

        public static void main(String[] args) throws IOException {
            //deque 연습문제 boj 10866
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용

            /**
             * 1. pop_front 비엇으면 -1 pop_back도 -1
             * 2. isEmpty 비었으면 1 있으면 0
             *
             * 15
             * push_back 1
             * push_front 2
             * front
             * back
             * size
             * empty
             * pop_front
             * pop_back
             * pop_front
             * size
             * empty
             * pop_back
             * push_front 3
             * empty
             * front
             */
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                switch (a) {
                    case "push_back":
                        int k = Integer.parseInt(st.nextToken());
                        deck.offerLast(k);
                        break;
                    case "push_front":
                        int t = Integer.parseInt(st.nextToken());
                        deck.offerFirst(t);
                        break;
                    case "front":
                        if(deck.isEmpty()) {
                            sb.append(-1).append("\n");
                        } else {
                            sb.append(deck.peekFirst()).append("\n");
                        }
                        break;
                    case "back":
                        if(deck.isEmpty()) {
                            sb.append(-1).append("\n");
                        } else {
                            sb.append(deck.peekLast()).append("\n");
                        }
                        break;
                    case "size":
                        sb.append(deck.size()).append("\n");
                        break;
                    case "empty":
                        if(deck.isEmpty()) {
                            sb.append(1).append("\n");
                        } else {
                            sb.append(0).append("\n");
                        }
                        break;
                    case "pop_front":
                        if(deck.isEmpty()) {
                            sb.append(-1).append("\n");
                        } else {
                            sb.append(deck.pollFirst()).append("\n");
                        }
                        break;
                    case "pop_back":
                        if(deck.isEmpty()) {
                            sb.append(-1).append("\n");
                        } else {
                            sb.append(deck.pollLast()).append("\n");
                        }
                        break;
                    default:
                        break;
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
