package Java.BOJ.BinarySearch;
import java.io.*;
import java.util.*;

public class BOJ_7_2467 {

    public static class Main {
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //Binary Search 기본문제 boj 2467
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수
            int[] arr1 = readIntArray(n); // 1차원 배열 사용

            /**
             * 1. 같은 양의 두 용액을 혼합 하여, 용액의 특성값은 혼합된 용액의 특성값의 합으로 정의
             * 2. 혼합 특성 값이 0에 가장 가까운 용액을 만드려 한다.
             * 3. 이미 정렬은 되어 있다.
             * 4. st와 en을 더해서? 그게 0과 기존의 것보다 더 크거나 작다로 가야할 것 같은데 어째건 앞쪽은 음수고 뒷쪽은 양수다.
             * 5.
             *
             * 5
             * -99 -2 -1 4 98
             *
             * -99 98
             */
            int st=0;
            int en=arr1.length-1;
            int min = Integer.MAX_VALUE;
            Deque<List<Integer>> deque = new ArrayDeque<>();

            while(st<en) {
                int sum = arr1[st] + arr1[en];

                if(Math.abs(min) >= Math.abs(sum)) {
                    min = sum;
                    if(deque.isEmpty()) {
                        deque.addLast(List.of(st,en));
                    } else {
                        deque.clear();
                        deque.addLast(List.of(st,en));
                    }
                }

                if(sum < 0) {
                    st++;
                } else {
                    en--;
                }
            }

            List<Integer> answer = deque.pollFirst();
            sb.append(arr1[answer.get(0)]).append(" ").append(arr1[answer.get(1)]);
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
