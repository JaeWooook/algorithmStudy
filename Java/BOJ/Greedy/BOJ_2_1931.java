package Java.BOJ.Greedy;
import java.io.*;
import java.util.*;

public class BOJ_2_1931 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //그리디 연습문제 boj 1931
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용

            /**
             * 1. 각회의실이 겹치지않고, 사용할 수 있는 회의의 최대개수를 찾기 끝나는것과 동시에 시작가능
             * 2. 시작하자마자 끝날수도 있다.
             * 3. 우선, 앞의 시작시간으로 정렬을 한번 한다면, 끝은 그걸 기준으로 맞출수 있다.
             * 4. 동일 시작시간이 있다면. 회의시간이 더 짧은 사람을 골라야 많이 넣을수 있을 것이다.
             * 5. 어째거나 브루드포스를 돌리는건 매한가지아닌가?
             * 6. 최대의 시간을 사용하려면 가장 적게 먹는애들부터 먹어야한다. 시작시간과 끝시간이 있기 때문에 시작시간을 기준으로 정렬한다.
             * 7. 첫번째는 일단 시작시간을 기준으로 정렬하고 같으면 시간 더적은애가 앞에있는게 맞다. 그런데
             * 8. 만약 0~6 이라고할때 6까지 0~6사이에 있는 시작값 중에 더빨리 끝나는게 있다면 그녀석을 선택하는게 옳다.
             * 9. 한큐에 이게되나? 조금 궁금한데 결국 브루드 포스 해야되는거 아닌가?
             * 10. 안에 포함되는 것 완벽하게 포게지는것 일 때 더작으면 넣어준다.
             *
             * 11
             * 1 4
             * 3 5
             * 0 6
             * 5 7
             * 3 8
             * 5 9
             * 6 10
             * 8 11
             * 8 12
             * 2 13
             * 12 14
             *
             * 1 4
             * 0 6
             * 3 5
             * 5 7
             * 5 9
             *
             * (1,4) (5,7) (8,11) (12,14)
             * 3,5 5,7 8,11 12,14
             */
            List<List<Integer>> lists = new ArrayList<>();
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                lists.add(List.of(s,e));
            }
            lists.sort((a,b) -> {
                int cmp = Integer.compare(a.get(1), b.get(1));
                if(cmp != 0) return cmp;

                return Integer.compare(a.get(0), b.get(0));
            });

            int cnt = 0;
            boolean first = true;
            List<List<Integer>> selected = new ArrayList<>();
            for(List<Integer> tmp : lists) {
                if(first) {
                    selected.add(tmp);
                    cnt++;
                    first = false;
                } else {
                    List<Integer> test = selected.get(cnt-1);
                    if(tmp.get(0) >= test.get(1)) {
                        selected.add(tmp);
                        cnt++;
                    }
                }
            }

            sb.append(cnt);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }
    }
}
