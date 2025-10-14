package Java.BOJ.Dequeue;
import java.io.*;
import java.util.*;

public class BOJ_2_2346 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static Deque<List<Integer>> deck = new ArrayDeque<>();

        public static void main(String[] args) throws IOException {
            //deque 기본문제 boj 2346
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[] arr1 = readIntArray(n); // 1차원 배열 사용

            /**
             * 1. 제일 처음 첫번째 풍선을 터트린다.
             * 2. 종이에 적힌값만큼 이동해서 다음 풍선을 터트린다.
             * 3. 양수가 적히면 오른쪽, 아니면 왼쪽으로
             * 4. 터진 풍선 순서대로 번호 나열 poll한것 넣기
             * 5. 음수인지 양수인지 먼저구분, 양수인경우 순서는 더하기 +를하고 % n + 1을 한순서일 것 같다?
             * 6. 3이라면 자기자신을 제외하고 3번이다. 더 수가 크거나 더 작으면 계산해야 된다. 한바퀴 돌리는걸로
             * 7. 그냥 새로 계속 deque 하나만들고 그친구를 기반으로 +면 앞에서빼서 뒤로 넣어주고, -이면  해당것까지 간다음에
             * 8. 뒤에서 빼서 앞을 더해주는 형태로 가야할 듯?
             * 9. 그렇게하고 해당 숫자를 arr에서 찾아서 몇번째인지 넣어주면되는거아닌가?
             *
             * 5
             * 3 2 1 -3 -1
             *
             * 3 2 1 -3 -1
             *
             * 2 1 -3 -1 -> -1당첨
             *
             * -3 -1 2 1 -> 앞으로 3개 옮기면 -3삭제하고, -1 2 1
             *
             * -1 2 1
             *
             * 2 1 -3 -1
             *
             * 만약 6이라면 2가될거 같은데 +6이라면
             * -> 1 4 5 3 2
             */
            for(int i=0; i<n; i++) {
                deck.addLast(List.of(i+1, arr1[i]));
            }
            int[] answer = new int[n];
            answer[0] = 1;
            int idx = 1;
            while(deck.size() > 1) {
                List<Integer> pung = deck.pollFirst();
                if(pung.get(1) > 0) {//양수일때
                    for(int i=0; i<pung.get(1)-1; i++) {
                        deck.addLast(deck.pollFirst());
                    }
                    answer[idx] = deck.peekFirst().get(0);
                } else {//음수일때
                    for(int i=0; i<(pung.get(1)*-1); i++) {
                        deck.addFirst(deck.pollLast());
                    }
                    answer[idx] = deck.peekFirst().get(0);
                }
                idx++;
            }

            for(int i=0; i<n; i++) {
                sb.append(answer[i]).append(" ");
            }

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
