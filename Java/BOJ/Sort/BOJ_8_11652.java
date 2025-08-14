package Java.BOJ.Sort;
import java.io.*;
import java.util.*;

public class BOJ_8_11652 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //정렬2 연습문제 boj 11652
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = readInt(); // 단일 정수 사용
            long[] arr1 = readLongLineByArray(n);

            /**
             * 1. 제일 많은 카드값을 일단 출력한다.
             * 2. 그 카드값이 중복된다면, 가장 작은 숫자를 출력
             * 3. 그냥 TreeMap으로해서 Map순회하면서 제일큰값의 key넣어주면 어차피 제일 작은 값이 들어가고 동일한값은 추가로안들어오기때문에
             * 4. card의 제일작으면서 동시에 반복된값이 가장 큰값이 key값이 산출된다.
             *
             * 5
             * 1
             * 2
             * 1
             * 2
             * 1
             */

            TreeMap<Long, Integer> countMap = new TreeMap<>();
            for(long nums : arr1) {
                countMap.put(nums, countMap.getOrDefault(nums, 0) +1);
            }

            int max = 0;
            long maxKey = 0;
            for(long key : countMap.keySet()) {
                int cardCount = countMap.get(key);

                if(max < cardCount) {
                    max = cardCount;
                    maxKey = key;
                }
            }
            System.out.print(maxKey);
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static long[] readLongLineByArray(int size) throws IOException {
            long[] arr = new long[size];
            for(int i=0; i<size; i++) {
                arr[i] = Long.parseLong(br.readLine());
            }
            return arr;
        }
    }
}
