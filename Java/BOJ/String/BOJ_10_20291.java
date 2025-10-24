package Java.BOJ.String;
import java.io.*;
import java.util.*;

public class BOJ_10_20291 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //string 기본문제 boj 20291
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            String[] strArr = readStringArray(n); // 문자열

            /**
             * 1. 확장자별로 몇개가있는지 알려준다.
             * 2. 사전순으로 정렬한다. treemap사용
             *
             * 8
             * sbrus.txt
             * spc.spc
             * acm.icpc
             * korea.icpc
             * sample.txt
             * hello.world
             * sogang.spc
             * example.txt
             */
            Map<String, Integer> map = new TreeMap<>();
            for(int i=0; i<n; i++) {
                String[] str = strArr[i].split("\\.");
                map.put(str[1], map.getOrDefault(str[1],0) +1);
            }

            for(String key : map.keySet()) {
                sb.append(key).append(" ").append(map.get(key)).append("\n");
            }


            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
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
