package Java.BOJ.Exhaustive_Search.Brute_Force;
import java.io.*;
import java.util.*;

public class BOJ_7_15721 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        static int max;

        public static void main(String[] args) throws IOException {
            //브루드포스 기본문제 boj 15721
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            int n = readInt(); // 단일 정수 사용
            int m = readInt(); // 단일 정수
            int t = readInt(); // 단일 정수
            /**
             * 1. 뻔 - 데기 - 뻔 - 데기 - 뻔 - 뻔 - 데기 - 데기 (이게 1회차)
             * 2. 뻔 - 데기 - 뻔 - 데기 - 뻔 - 뻔 - 뻔 - 데기 - 데기 - 데기 (이게 2회차)
             * 3. 우선은 1회차의 리스트를 만든다.
             * 4. n회차 가 끝날때 마다 각각의 고유 위치에 뻔과 데기를 추가해준다. while로 돌린다.
             * 5. m번째 외치는순간 게임은 종료되고 그 m번째 사람이 몇번째사람인지 찾는다.
             *
             * 8 게임하는사람
             * 2 번째 사람 이뭔지 -> 2번째에 등장하는 뻔을 부르는 사람이다.
             * 0 0이면 뻔 1이면 데기
             */
            int answer = 0;
            List<String> list = new ArrayList<>(Arrays.asList("뻔", "데기", "뻔", "데기", "뻔", "뻔", "데기", "데기"));

            boolean bbun = t == 0;
            int bbunCnt = 0;
            int daeGiCnt = 0;
            int idx = 0;
            while(true) {
                for(String str : list) {
                    if(bbun && "뻔".equals(str)) {
                        bbunCnt++;
                        if(bbunCnt == m) {
                            break;
                        }
                    }
                    if(!bbun && "데기".equals(str)) {
                        daeGiCnt++;
                        if(daeGiCnt == m) {
                            break;
                        }
                    }
                    idx++;
                    if(idx >= n) {
                        idx = 0;
                    }
                }
                list.add(4, "뻔");
                list.add("데기");

                if(bbun && bbunCnt == m) {
                    answer = idx;
                    break;
                }
                if(!bbun && daeGiCnt == m) {
                    answer = idx;
                    break;
                }
            }

            sb.append(answer);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }
    }
}
