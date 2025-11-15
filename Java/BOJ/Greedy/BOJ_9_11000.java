package Java.BOJ.Greedy;
import java.io.*;
import java.util.*;

public class BOJ_9_11000 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            //greedy 기본문제 boj 11000
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[][] arr2 = readInt2DArrayNew(n, 2); // 2차원 배열

            /**
             * 1. s와t제공, N개의 수업이 주어질때 최소의 강의실을 사용해서 모든 수업을 가능하게 한다.
             * 2. 수업끝나고 바로 직후에 수업 가능 하다.
             * 3. 우선 이거는 앞에는 오름차순, 뒤에는 내림차순을 기준으로 정렬?
             * 4. 이거는 강의실 개수를 몇개사용하는지를 카운팅하는것이다. 최소한의 강의실개수
             * 5. 실제 시간이 맞지 않으면 강의실을 추가로 개설하는 느낌 으로 하며되지 않을까? 좀재밋는데이거?
             * 6. 끝 값을
             *
             * 3
             * 1 3
             * 2 4
             * 3 5
             *
             * 4
             * 8 17
             * 8 13
             * 0 6
             * 0 2
             *
             * -> 2 , 3
             *
             * 2
             * 12 21
             * 1 8
             *
             * -> 1, 2
             */
            Integer[][] boxedArr2D = Arrays.stream(arr2).map((arr) -> Arrays.stream(arr).boxed().toArray(Integer[]::new)).toArray(Integer[][]::new);
            Arrays.sort(boxedArr2D, Comparator.comparingInt((Integer[] a) -> a[0]).thenComparingInt(a -> a[1]));
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i=0; i<boxedArr2D.length; i++) {
                if(pq.isEmpty()) {
                    pq.add(boxedArr2D[i][1]);
                } else {
                    int pqLastTime = pq.poll();
                    if(pqLastTime <= boxedArr2D[i][0]) {
                        pq.add(boxedArr2D[i][1]);
                    } else {
                        pq.add(boxedArr2D[i][1]);
                        pq.add(pqLastTime);
                    }
                }
            }

            sb.append(pq.size());

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        //띄어쓰기 없는 2차원일때
        private static int[][] readInt2DArrayNew(int n, int m) throws IOException {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                String line = br.readLine().trim();

                // 공백으로 구분된 경우
                if (line.contains(" ")) {
                    StringTokenizer st = new StringTokenizer(line);
                    for (int j = 0; j < m; j++) {
                        if (!st.hasMoreTokens()) {
                            throw new IllegalArgumentException(
                                    "입력 데이터가 부족합니다. line=" + line + " 기대된 길이=" + m
                            );
                        }
                        arr[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                // 붙어있는 문자열인 경우
                else {
                    if (line.length() < m) {
                        throw new IllegalArgumentException(
                                "입력 데이터 길이가 부족합니다. line=" + line + " 기대된 길이=" + m
                        );
                    }
                    for (int j = 0; j < m; j++) {
                        arr[i][j] = line.charAt(j) - '0';
                    }
                }
            }
            return arr;
        }
    }
}
