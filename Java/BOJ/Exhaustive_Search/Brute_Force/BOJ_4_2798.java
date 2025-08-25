package Java.BOJ.Exhaustive_Search.Brute_Force;
import java.io.*;
import java.util.*;

public class BOJ_4_2798 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //브루드포스 연습문제 boj 2798
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr1 = readIntArray(n); // 1차원 배열 사용
            /**
             * 1. 각각을 조합해서? 합할 것인가?
             * 2. 정렬 한 다음에 3포인터?를 사용 할까?
             *
             * 5 21
             * 5 6 7 8 9
             *
             * 10 500
             * 93 181 245 214 315 36 185 138 216 295
             *
             * 497
             * 36 93 138 181 185 214 216 245 295 315
             *
             * lt1개를 잡고 나머지 ct,rt로 2포인터를 돌려야할듯하다.
             */
            int answer = 0;
            Arrays.sort(arr1);
            int lt = 0;
            int ct = 0;
            int rt = 0;
            int len = arr1.length;

            for(int i=0; i<len-2; i++) {
                lt = i;
                ct = i+1;
                rt = len -1;
                int compare = 0;
                while(ct < rt && ct<len && rt<len) {
                    compare = 0;
                    if(ct == rt) continue;
                    compare = arr1[lt] + arr1[ct] + arr1[rt];
                    if(compare <= m) {
                        answer = Math.max(answer, compare);
                        if(m == answer) break;
                        ct++;
                    } else {
                        rt--;
                    }
                }

                if(m == answer) break;
            }

            sb.append(answer);
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
