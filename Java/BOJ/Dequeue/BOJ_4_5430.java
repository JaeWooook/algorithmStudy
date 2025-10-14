package Java.BOJ.Dequeue;
import java.io.*;
import java.util.*;

public class BOJ_4_5430 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;
        ;
        static Deque<Integer> deck = new ArrayDeque<>();

        public static void main(String[] args) throws IOException {
            //deque 응용문제 boj 5430
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용

            /**
             * 1. 새로운언어 AC 정수 배열을 연산하기 위한 언어. R뒤집기 D버리기
             * 2. 순서를 뒤집는게 R, D는 첫번째 수를 버린다.
             * 3. 배열이 비어있는데 D를사용하면 에러가발생
             * 4. AB는 A를 수행한 다음에 바로이어서 B를 수행하는 함수
             * 5. 첫줄은 테스트케이스 개수, 그다음은 실행할 함수 그다음은 배열의길이
             *
             * 4
             * RDD
             * 4
             * [1,2,3,4]
             * DD
             * 1
             * [42]
             * RRD
             * 6
             * [1,1,2,3,5,8]
             * D
             * 0
             * []
             */
            for(int i=0; i<n; i++) {
                String orders = readLine();
                int m = readInt();
                String arr = readLine();
                int[] arrInt = new int[m];
                int idx = 0;
                StringBuilder sbt = new StringBuilder();
                boolean direction = true;

                for(Character ch : arr.toCharArray()) {
                    if(Character.isDigit(ch)) {
                        sbt.append(ch);
                    }

                    if((ch == ']' || ch == ',') && sbt.length() > 0) {
                        arrInt[idx] = Integer.parseInt(sbt.toString());
                        idx++;
                        sbt.setLength(0);
                    }
                }

                if(arrInt.length == 0) {
                    if(orders.contains("D")) {
                        sb.append("error").append("\n");
                        continue;
                    } else {
                        sb.append("[]").append("\n");
                        continue;
                    }
                }

                for(int num: arrInt) {
                    deck.addLast(num);
                }

                boolean byPass = false;
                for(char order : orders.toCharArray()) {
                    if('R' == order) {
                        if(direction) {
                            direction = false;
                        } else {
                            direction = true;
                        }
                    } else {
                        if(deck.isEmpty()) {
                            sb.append("error").append("\n");
                            byPass = true;
                            break;
                        }
                        if(direction) {
                            deck.pollFirst();
                        } else {
                            deck.pollLast();
                        }
                    }
                }

                if(byPass) continue;
                if(deck.isEmpty()) {
                    sb.append("[]").append("\n");
                } else {
                    Iterator<Integer> ascIt = deck.iterator();
                    Iterator<Integer> descIt = deck.descendingIterator();
                    sb.append("[");
                    if(direction) {
                        while(ascIt.hasNext()) {
                            sb.append(ascIt.next());
                            if(ascIt.hasNext()) {
                                sb.append(",");
                            }
                        }
                    } else {
                        while(descIt.hasNext()) {
                            sb.append(descIt.next());
                            if(descIt.hasNext()) {
                                sb.append(",");
                            }
                        }
                    }
                    sb.append("]").append("\n");
                    deck.clear();
                }
            }

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
