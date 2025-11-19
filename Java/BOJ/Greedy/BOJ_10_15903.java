package Java.BOJ.Greedy;
import java.io.*;
import java.util.*;

public class BOJ_10_15903 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //greedy 기본문제 boj 15903
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long[] arr1 = readLongArray(n);

            /**
             * 1. 자연수 n장, 처음엔 i번 카드엔 ai가 쓰여 있다.
             * 2. x번 카드와 y번 카드를 골라 그 두장에 쓰여진 수를 더한 값을 계산한다.
             * 3. 계산한 값을 x번 카드와 y번 카드 두장에 모두 덮어쓴다.
             * 4. 카드 합체를 총 m번 하면끝 n장 카드에 쓰인 수를 모두 더하면 끝이다. 점수를 가장 작게 만드는것이 목표이다.
             * 5. 우선 정렬을 한번한다. 오름차순 우선순위큐만들고, 정렬된 앞에 것들 더하고 횟수지나면 다더하면된다.
             *
             * 2 20
             * 59 442481
             */
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int i=0; i<n; i++) {
                pq.add(arr1[i]);
            }

            int idx = 0;
            while(idx<m && !pq.isEmpty()) {
                idx++;
                long val1 = pq.poll();
                long val2 = pq.poll();
                long sum = val1+val2;

                pq.add(sum);
                pq.add(sum);
            }

            long totalSum = 0;
            while(!pq.isEmpty()) {
                totalSum+= pq.poll();
            }

            sb.append(totalSum);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static long[] readLongArray(int size) throws IOException {//한칸씩 띄어쓰기 되어있는것
            long[] arr = new long[size];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            return arr;
        }
    }
}
