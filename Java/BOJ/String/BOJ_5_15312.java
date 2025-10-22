package Java.BOJ.String;
import java.io.*;
import java.util.*;

public class BOJ_5_15312 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //string 기본문제 boj 15312
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            String str = readLine();
            String str2 = readLine();

            /**
             * 1. 첫줄이 내이름, 두번째줄이 그녀이름이다. 각각 첫번째쓰이는건 내이름이다.
             * 2. 각각의 획수를 더한 일의자리를 계속내려서 2개가 될때까지 십의자리가 0이여도 두자리로 출력한다 string으로 출력
             * 3. 우선 각각의 알파벳을 섞은 자리의 풀네임을 구한다?
             * 4. 알파벳을 섞은 배열을 만든다?
             *
             * C H J E M R
             * 1 3 2 3 2 2
             *  4   5   4
             *    9   9
             *
             * CJM
             * HER
             */
            int[] abcStrokes = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
            String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            char[] me = str.toCharArray();
            char[] her = str2.toCharArray();
            int sumLength = me.length + her.length;
            char[] sumWord = new char[sumLength];
            int idx = 0;
            int idx2 = 0;
            for(int i=0; i<sumLength; i++) {
                if(i==0 || i%2 == 0) {
                    sumWord[i] = me[idx];
                    idx++;
                } else {
                    sumWord[i] = her[idx2];
                    idx2++;
                }
            }

            List<Integer> list = new ArrayList<>();
            for(int i=0; i<sumLength; i++) {
                if(abc.indexOf(sumWord[i]) >= 0) {
                    list.add(abcStrokes[abc.indexOf(sumWord[i])]);
                }
            }

            while(true) {
                if(list.size() == 2) break;
                List<Integer> tmp = new ArrayList<>();
                for(int i=0; i<list.size(); i++) {
                    if(i == list.size()-1) break;
                    int a = list.get(i);
                    int b = list.get(i+1);
                    String result = String.valueOf(a+b);
                    char[] chars = result.toCharArray();
                    tmp.add(Integer.parseInt(String.valueOf(chars[chars.length-1])));
                }
                list = List.copyOf(tmp);
            }

            sb.append(list.get(0)).append(list.get(1));

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static String readLine() throws IOException {
            return br.readLine();
        }
    }
}
