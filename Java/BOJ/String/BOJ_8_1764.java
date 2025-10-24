package Java.BOJ.String;
import java.io.*;
import java.util.*;

public class BOJ_8_1764 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //string 기본문제 boj 1764
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String[] strArr = readStringArray(n); // 문자열
            String[] strArr2 = readStringArray(m); // 문자열

            /**
             * 1. 듣도 못한사람의 수 N, 보도못한사람의 수 M
             * 2. 듣도 못한사람과 보도못한사람에서 중복되는사람 을 사전순으로 정렬
             * 3. 각각을 집합으로만들어서 TreeSet하고, 교집합 해서 나온결과를 출력
             *
             * 3 4
             * ohhenrie
             * charlie
             * baesangwook
             *
             * obama
             * baesangwook
             * ohhenrie
             * clinton
             */
            Set<String> set1 = new TreeSet<>();
            Set<String> set2 = new TreeSet<>();

            set1.addAll(List.of(strArr));
            set2.addAll(List.of(strArr2));

            set1.retainAll(set2);
            sb.append(set1.size()).append("\n");
            Iterator it = set1.iterator();
            while(it.hasNext()) {
                sb.append(it.next()).append("\n");
            }

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
