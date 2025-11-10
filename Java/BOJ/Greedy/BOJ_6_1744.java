package Java.BOJ.Greedy;
import java.io.*;
import java.util.*;

public class BOJ_6_1744 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //그리디 기본문제 boj 1744
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[] arr1 = readIntLineByArray(n); // 1차원 배열 사용
            /**
             * 1. 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.
             * 2. 자기 자신을 묶는것은 불가능, 묶은 수는 서로곱한후 더한다.
             * 3. ex 0,1,2,4,3,5 일때 묶어서 최대를만든다.
             * 4. 단한번만 묶거나 아니면 묶지 않아야한다.
             * 5. 가장 큰수를 만든다는것은 음수가 아닌 모든 양의정수는 묶는다면?
             * 6. 음수이고 0이면 곱해서 음수를 없앤다. 1이 있다면 1은 * 보다는 덧셈으로 한다. -1이라면 뒤에는 0이 아니라면 덧셈
             * 7. 2이상 양수그룹, 1은 무조건더함 0은 남은 음수를 제거한다. 음수는 오름차순으로만들어서 절대값이 큰값끼리 곱한다.
             *
             * 4
             * -404
             * -152
             * -421
             * 546
             * -> 170478 , 170630
             *
             * 6
             */
            PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minus = new PriorityQueue<>();
            List<Long> sums = new ArrayList<>();

            for(int i=0; i<arr1.length; i++) {
                if(arr1[i] > 0) {
                    plus.add(arr1[i]);
                } else if(arr1[i] <= 0) {
                    minus.add(arr1[i]);
                }
            }

            while(!plus.isEmpty()) {
                int val1 = plus.poll();
                if(plus.isEmpty()) {
                    sums.add(Long.valueOf(val1));
                } else {
                    int val2 = plus.poll();
                    if(val2 == 1) {
                        sums.add(Long.valueOf(val1));
                        sums.add(Long.valueOf(val2));
                    } else {
                        sums.add(Long.valueOf(val1) * Long.valueOf(val2));
                    }
                }
            }

            while(!minus.isEmpty()) {
                int val1 = minus.poll();
                if(minus.isEmpty()) {
                    sums.add(Long.valueOf(val1));
                } else {
                    int val2 = minus.poll();
                    sums.add(Long.valueOf(val1) * Long.valueOf(val2));
                }
            }

            long sum = 0;
            for(Long val : sums) {
                sum += val;
            }
            sb.append(sum);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static int[] readIntLineByArray(int size) throws IOException {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            return arr;
        }
    }
}
