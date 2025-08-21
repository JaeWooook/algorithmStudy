package Java.BOJ.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class BOJ_11_2910 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //정렬2 기본문제 boj 2910
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine()); //1줄에 2개의 정수입력
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr1 = readIntLineTrimByArray(n); // 1차원 배열 사용

            /**
             * 1.빈도를 확인하기 위해서는 hash가 필요하다 map
             * 2.먼저 나온 숫자가 무엇인지를 인지해야한다. LinkedHashMap을 이용?
             * 3.제일 많이 나온 숫자가 앞에 들어오는것은 맞다.
             * 4.빈도가 같은 경우 앞에 먼저나온수를 넣는다.
             * 5.sorts 함수를 이용해서 같은 경우 순서를 지키게하고, 다른 경우 더많이 나온값을 넣게 하면된다.
             * 6.2차원 integer 배열로 순서는 말그대로 index로하고 arr2[0][0] 중복된 key값
             * , arr2[0][1]에 개수로 비교하면된다.
             * 5 2
             * 2 1 2 1 2
             */
            LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
            for(int num : arr1) {
                map.put(num, map.getOrDefault(num, 0) +1);
            }

            Integer[][] nums2D = new Integer[map.size()][2];
            int idx = 0;
            for(Integer key : map.keySet()) {
                nums2D[idx][0] = key;
                nums2D[idx][1] = map.get(key);
                idx++;
            }

            Arrays.sort(nums2D, (a, b) -> {
                if(a[1] == b[1]) { //개수가 같을때는 인덱스 그대로 유지
                    return 0;
                } else {
                    return b[1] - a[1];//내림차순
                }
            });

            for(Integer[] numArr : nums2D) {
                int length = numArr[1];
                for(int i=0; i<length; i++) {
                    sb.append(numArr[0]).append(" ");
                }
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int[] readIntLineTrimByArray(int size) throws IOException {
            int[] arr = new int[size];
            StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄 읽고 토큰화
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            return arr;
        }
    }
}
