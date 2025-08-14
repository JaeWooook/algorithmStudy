package Java.BOJ.Hash;
import java.io.*;
import java.util.*;

public class BOJ_5_19583 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //해시 기본문제 boj 19583
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine()); //
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();

            ArrayList<String[]> chatList = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                st = new StringTokenizer(line);
                String time = st.nextToken();
                String name = st.nextToken();
                chatList.add(new String[]{time, name});
            }

            // ArrayList → 2차원 배열 변환
            String[][] chatData = chatList.toArray(new String[0][0]);

            /**
             * 아이디어 우선 set에 넣긴해야된다. 중복을 제거하기 위해서
             * 1. 22, 23, 23을 시간으로 변환해야하고 분까지 그냥 시간 으로 표현할수있나? 아 그냥 분으로 전부 바꿔버리면 될듯하다.
             * 2. 1시간은 60분이닌까 포함해야할 분에 대한시간을 b <= target <= c 에 있는 모든 리스트 개수를 Set에 넣고 size()로 호출
             * 3. 시작 이전 시간도 넣어 준다. 우선 넣어 주고,
             * 4. 시작 이전시간에 있는애들 ->
             * 교집합만 추리면된다.
             */

            //시간은 00:00이다
            HashSet<String> inputSet = new HashSet<>();
            HashSet<String> outputSet = new HashSet<>();
            int s = Integer.valueOf(a.split(":")[0]) * 60 + Integer.valueOf(a.split(":")[1]);
            int e = Integer.valueOf(b.split(":")[0]) * 60 + Integer.valueOf(b.split(":")[1]);
            int q = Integer.valueOf(c.split(":")[0]) * 60 + Integer.valueOf(c.split(":")[1]);

            for(String[] chat : chatData) {
                int curr = Integer.valueOf(chat[0].split(":")[0]) * 60 + Integer.valueOf(chat[0].split(":")[1]);

                if(curr <= s) {
                    inputSet.add(chat[1]);
                }

                if(e <= curr && curr <= q) {
                    outputSet.add(chat[1]);
                }
            }

            inputSet.retainAll(outputSet);

            int num = inputSet.size();
            sb.append(num);

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
    }
}
