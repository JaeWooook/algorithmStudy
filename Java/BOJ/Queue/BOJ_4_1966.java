package Java.BOJ.Queue;
import java.io.*;
import java.util.*;

public class BOJ_4_1966 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //queue 기본문제 boj 1966
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int t = readInt(); // 단일 정수 사용
            /**
             * 1. 맨처음에 테스트케이스 개수 받고,
             * 2. 문서의개수 n 몇번째로 인쇄된지 궁금한 문서가 m 그다음줄은 이제 queue의상태인가?
             * 3. 우선순위를 체크하려면, 우선 가장 queue에 넣을때 max값이 무엇인지 체크하고, 해당 max값에 --를 하면서
             * 4. 해당값이 있는지를 contains로 체크를할수있다면, 존재한다면 그보다 작은값들은 전부 뒤로 보낸다.
             *
             * 3
             *
             * 1 0
             * 5
             *
             * 4 2
             * 1 2 3 4
             *
             * 6 0
             * 1 1 9 1 1 1
             *
             * 9 1 1 1 1 1
             *
             * 1
             * 2
             * 5
             */
            for(int i=0; i<t; i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                int[] arr1 = readIntArray(n);
                Deque<List<Integer>> que = new ArrayDeque<>();
                for(int j=0; j<n; j++) {
                    que.addLast(List.of(arr1[j], j));
                }

                int[] descSorted = Arrays.stream(arr1).boxed().sorted((a,b) -> b-a).mapToInt(Integer::intValue).toArray();
                int index = 0;
                int cnt = 0;
                while(!que.isEmpty()) {
                    List<Integer> print = que.pollFirst();
                    int val = print.get(0);
                    int idx = print.get(1);

                    if(val < descSorted[index]) {
                        que.addLast(print);
                        continue;
                    }

                    if(val == descSorted[index]) {
                        index++;
                        cnt++;
                    }

                    if(idx == m) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                }
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
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
