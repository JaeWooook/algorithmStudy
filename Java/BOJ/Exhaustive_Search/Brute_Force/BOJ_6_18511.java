package Java.BOJ.Exhaustive_Search.Brute_Force;
import java.io.*;
import java.util.*;

public class BOJ_6_18511 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static int max;

        public static void main(String[] args) throws IOException {
            //브루드포스 기본문제 boj 18511
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr1 = readIntArray(m); // 1차원 배열 사용
            /**
             * 1. N보다 작거나 같은 자연수 중에 집합 K의 원소로만 구성된 가장 큰수 중복 허용이다. 집합에 있는수
             * 2. 아래의 예시로 들면 577
             * 657 3
             * 1 5 7
             *
             * 1. 우선은 10의자리 100의자리 계산은 불편 하기 때문에, 문자열 배열로 변경 한다.
             * 2. 역순으로 정렬하고 이거는 자리수를 알지못한다. m번이여야한다. 3개 인 지난번과 달라서 억지 투포인터불가능
             */
            int idx = 0;
            String size = String.valueOf(n);
            //배열에 받은 값중 제일 작은 값이, n의 첫번째 자리 값보다 크다면 뽑을 사이즈를 -1한다.
            String limitFirtst = size.substring(0,1);
            Arrays.sort(arr1);
            String[] strArr = new String[arr1.length];
            String[] answer = new String[size.length()];
            for(int card : arr1) {
                strArr[idx++] = String.valueOf(card);
            }

            if(Integer.parseInt(limitFirtst) >= arr1[0]) {
                combination(strArr, 0, size.length(), answer, n);
            } else {
                combination(strArr, 0, size.length()-1, answer, n);
            }

            sb.append(max);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static void combination(String[] arr, int depth, int m, String[] answer, int limit) {
            if(depth == m) {
                return;
            }

            for(int i=0; i<arr.length; i++) {
                answer[depth] = arr[i];
                StringBuilder sbd2 = new StringBuilder();
                for(int j=0; j<answer.length; j++) {
                    if(answer[j] == null) break;
                    sbd2.append(answer[j]);
                }

                int sumPrefix = Integer.valueOf(sbd2.toString());
                if(sumPrefix <= limit) {
                    max = Math.max(max, sumPrefix);
                }

                combination(arr, depth+1, m, answer, limit);
            }
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
