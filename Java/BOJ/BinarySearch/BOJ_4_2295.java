package Java.BOJ.BinarySearch;
import java.io.*;
import java.util.*;

public class BOJ_4_2295 {

    public static class Main {
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //Binary Search 연습문제 boj 2295
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[] arr1 = readIntLineByArray(n);

            /**
             * 1. N개의 자연수 집합에서 세 수를 고르고, 그 세수의 합도 자연수 집합에 포함 되는 경우가 있을 수 있다.
             * 2. 이러한 경우들 중에 가장큰 합의 값을 찾아라
             * 3. 세 수를 구하는 것은 중복이 있어도 된다.
             * 4. 세 수를 뽑는 것은 dfs로 해야 하거나 bfs로 해야할 수 있다.
             * 5. 조합은 dfs이다. 중복이 있는 조합 그 수가 여기에 존재 하는지를 바이 너리 서치로 찾는게 올바른 구조인 듯하다.
             */
            int[] tmp = Arrays.copyOf(arr1, arr1.length);
            int[] twoSum = new int[(arr1.length*(arr1.length+1))/2];
            List<Integer> two = new ArrayList<>();
            int idx = 0;
            Arrays.sort(tmp);
            for(int i=0; i<arr1.length; i++) {
                for(int j=i; j<arr1.length; j++) {
                    twoSum[idx++] = arr1[i] + arr1[j];
                }
            }

            Arrays.sort(twoSum);
            boolean byPass = false;
            for(int i=arr1.length-1; i>=0; i--) {
                for(int j=0; j<arr1.length; j++) {
                    if(Arrays.binarySearch(twoSum, tmp[i] - tmp[j]) > -1) {
                        sb.append(tmp[i]);
                        byPass = true;
                        break;
                    }
                }
                if(byPass) break;
            }

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
