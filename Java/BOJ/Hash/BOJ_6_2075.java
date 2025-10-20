package Java.BOJ.Hash;
import java.io.*;
import java.util.*;

public class BOJ_6_2075 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //hash 기본문제 boj 2075
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String[] strArr = readStringArray(n); // 문자열
            String[] strArr2 = readStringArray(m); // 문자열

            /**
             * 1. 입력으로 주어지는 m개의 문자열 중에서 집합 S에 포함되는것이 몇개인지 구한다.
             * 2. N개의 문자열로 이루어진 집합 S가 주어진다.
             * 3. N개와 M개를 각각 hashset에 넣고, 교집합의 개수를 찾으면되는게아닐까?
             * 4. 집합에 넣고 하닌까, 개수가 틀리다. 집합은 중복을 허용하지않는다.
             * 5. 사실 map으로하고, key로하고, iterator돌리면서 하면되긴하는데
             *
             * 5 11
             * baekjoononlinejudge
             * startlink
             * codeplus
             * sundaycoding
             * codingsh
             *
             * baekjoon
             * codeplus
             * codeminus
             * startlink
             * starlink
             * sundaycoding
             * codingsh
             * codinghs
             * sondaycoding
             * startrink
             * icerink
             */

            Set<String> set1 = new HashSet<>();
            Map<String, Integer> map1 = new HashMap<>();

            int cnt = 0;
            set1.addAll(List.of(strArr));
            for(int i=0; i<m; i++) {
                map1.put(strArr2[i], map1.getOrDefault(strArr2[i], 0) + 1);
            }

            for(String keySet : map1.keySet()) {
                if(set1.contains(keySet)) {
                    cnt+= map1.get(keySet);
                }
            }

            sb.append(cnt);

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static String[] readStringArray(int size) throws IOException {
            String[] arr = new String[size];
            for (int i = 0; i < size; i++) {
                arr[i] = br.readLine();
            }
            return arr;
        }
    }
}
