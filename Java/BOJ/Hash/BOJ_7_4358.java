package Java.BOJ.Hash;
import java.io.*;
import java.util.*;

public class BOJ_7_4358 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //hash 기본문제 boj 4358
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            /**
             * 1. 각종이 전체에서 몇%를 차지하는지를 구하는 문제다.
             * 2. 사전순으로 출력해야한다 키를 기준으로하는 treeMap추천, String.format사용해서 출력
             * 3. 우선 map이용해서 개수를 새는건 기본 이고,이걸 어떻게 받는지 부터가 문제 인데
             *
             * Red Alder
             * Ash
             * Aspen
             * Basswood
             * Ash
             * Beech
             * Yellow Birch
             * Ash
             * Cherry
             * Cottonwood
             * Ash
             * Cypress
             * Red Elm
             * Gum
             * Hackberry
             * White Oak
             * Hickory
             * Pecan
             * Hard Maple
             * White Oak
             * Soft Maple
             * Red Oak
             * Red Oak
             * White Oak
             * Poplan
             * Sassafras
             * Sycamore
             * Black Walnut
             * Willow
             */
            String line;
            int cnt = 0;
            Map<String, Integer> map = new TreeMap<>();
            while ((line = br.readLine()) != null) {
                cnt++;
                map.put(line, map.getOrDefault(line, 0)+1);
            }

            for(String keySet : map.keySet()) {
                int val = map.get(keySet);
                double result = (val*100.0)/cnt;
                sb.append(keySet).append(" ").append(String.format("%.4f", result)).append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
    }
}
