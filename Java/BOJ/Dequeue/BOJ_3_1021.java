package Java.BOJ.Dequeue;
import java.io.*;
import java.util.*;

public class BOJ_3_1021 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static Deque<Integer> deck = new ArrayDeque<>();

        public static void main(String[] args) throws IOException {
            //deque 기본문제 boj 1021
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr1 = readIntArray(m); // 1차원 배열 사용

            /**
             * 1. N개의 원소를 포함하고 있는 양방향 순환 큐
             * 2. 왼쪽으로의 한칸 이동은 a2 .. ak, a1이된다.
             * 3. 오른쪽으로 한칸 이동은 ak, a1 ... ak-1
             * 4. 즉, 왼쪽으로한칸이동은 앞에서 뽑아서 뒤로보내기, 오른쪽은 뒤에서 뽑아서 앞으로보내는것
             * 5. 처음에 포함된 수 N 뽑아내려고 하는 수의 개수 M,
             *
             * 10 3
             * 1 2 3 -> 뽑아내려고하는 위치?
             * 2 9 5
             *
             * 1 2 3 4 5 6 7 8 9 10 뽑아내는데 0번?
             *
             * 2 3 4 5 6 7 8 9 10 1
             * 1번
             *
             * 3 4 5 6 7 8 9 10 1 로진행
             * -> 1 3 4 5 6 7 8 9 10 으로한번회전
             * -> 10 1 3 4 5 6 7 8 9 로 2번회전 무조건 맨앞이여야한다?
             * -> 9 10 1 3 4 5 6 7 8
             * 3번
             *
             * 10 1 3 4 5 6 7 8 ->5맨앞으로
             * 1 3 4 5 6 7 8 10
             * 3 4 5 6 7 8 10 1
             * 4 5 6 7 8 10 1 3
             * 5 6 7 8 10 1 3 4
             * => 총 4번
             *
             * 4번
             *
             * 10 10
             * 1 6 3 2 7 9 8 4 10 5
             *
             * 1 2 3 4 5 6 7 8 9 10
             *
             * 1은 0
             * 2 3 4 5 6 7 8 9 10
             * 6은 4 vs 5라 left인데?
             */
            for(int i=0; i<n; i++) {
                deck.addLast(i+1);
            }

            int min = 0;
            int idx = 0;
            while(idx < m) {
                int find = arr1[idx];
                Iterator<Integer> desIt = deck.descendingIterator();
                Iterator<Integer> ascIt = deck.iterator();
                int rightIdx = 0;
                int leftIdx = 0;
                if(find == deck.peekFirst()) {
                    idx++;
                    deck.pollFirst();
                    continue;
                }

                while(desIt.hasNext()) {
                    if(desIt.next().equals(find)) {
                        rightIdx++;
                        break;
                    }
                    rightIdx++;
                }

                while(ascIt.hasNext()) {
                    if(ascIt.next().equals(find)) {
                        break;
                    }
                    leftIdx++;
                }

                if(rightIdx > leftIdx) {//left로 처리
                    for(int i=0; i<leftIdx; i++) {
                        deck.addLast(deck.pollFirst());
                    }
                    deck.pollFirst();
                    min+=leftIdx;
                } else {
                    for(int i=0; i<rightIdx; i++) {
                        deck.addFirst(deck.pollLast());
                    }
                    deck.pollFirst();
                    min+=rightIdx;
                }

                idx++;
            }

            sb.append(min);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
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
