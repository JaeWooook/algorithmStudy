package Java.BOJ.BinarySearch;
import java.io.*;
import java.util.*;

public class BOJ_3_18870 {

    public static class Main {
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //Binary Search 연습문제 boj 18870
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[] arr1 = readIntArray(n); // 1차원 배열 사용

            /**
             * 1. N개의 좌표에 좌표 압축을 적용하려한다.
             * 2. Xi를 좌표 압축한 결과 Xi의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다?
             * 3. 서로다른 수 중에 자기자신보다 작은 것의 개수이다.
             * 4. -10보다 작은것은 없다.
             * 5. 중복을 제거하기 위해 set에 먼저 저장한다?
             *
             * 5
             * 2 4 -10 4 -9
             * -> -10 -9 4 4 2
             *
             * 2 3 0 3 1
             */
            int[] sortedArr = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(sortedArr);
            Set<Integer> rmDuplication = new TreeSet<>();
            for(int num : sortedArr) {
                rmDuplication.add(num);
            }
            Map<Integer, Integer> ansMap = new HashMap<>();
            int idx = 0;
            for(Integer num : rmDuplication) {
                ansMap.put(num, idx++);
            }

            for(int key : arr1) {
                sb.append(ansMap.get(key)).append(" ");
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
