package Java.BOJ.Greedy;
import java.io.*;
import java.util.*;

public class BOJ_7_2847 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //greedy 기본문제 boj 2847
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[] arr1 = readIntLineByArray(n);

            /**
             * 1. 게임 레벨은 총 N개, 각레벨 클리어할 때 마다 점수가 주어진다.
             * 2. 플레이어의 점수는 레벨을 클리어하면서 얻은 점수의 합이다., 이 점수를 바탕으로 온라인 순위를 매긴다.
             * 3. 레벨을 난이도 순으로 배치했다. 실수로 쉬운 레벨이 어려운 레벨보다 점수를 많이 받는 경우를 만들었다.
             * 4. 점수는 항상 양수, 1만큼 감소하는것이 1번이다. 정답이 여러 가지인 경우 점수를 내리는것을 최소화한 방법이다.
             * 5. 늘리는것은 없기때문에 끝 점수를 기준으로 하는것이 옳아보인다.
             *
             * 3
             * 5
             * 5
             * 5
             */
            int cnt = 0;
            int target = arr1[arr1.length-1];
            for(int i=arr1.length-2; i>=0; i--) {
                if(target <= arr1[i]) {
                    int newTarget = arr1[i];
                    while(target <= newTarget) {
                        newTarget--;
                        cnt++;
                    }
                    target = newTarget;
                } else {
                    target = arr1[i];
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

        static int[] readIntLineByArray(int size) throws IOException {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            return arr;
        }
    }
}
