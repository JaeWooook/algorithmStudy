package Java.BOJ.Stack;
import java.io.*;
import java.util.*;

public class BOJ_4_2493 {
    public static class Main {
        static BufferedReader br;
        static BufferedWriter bw;
        static StringTokenizer st;
        static Stack<List<Integer>> stack = new Stack<>();

        public static void main(String[] args) throws IOException {
            //stack 응용문제 boj 2493
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[] arr1 = readIntArray(n); // 1차원 배열 사용

            /**
             * 1. N개의 탑들의 높이가 직선상에 있다.
             * 2. 탑들을 오름차순으로 세우고, 하나의 탑에서 발사된 레이저 신호는 가장먼저 만나는 단1개의 탑에 수신가능
             * 3. 6 9는 어떠한 탑도 수신 하는 탑이 없다.
             * 4. 왼쪽에 더 높은 탑이 있으면 수신이 가능하다. 1번째는 항상 0이다?
             * 5. 4를 pop하고 7peek해서 비교해서 크닌까  stack.size를 넣어준다?
             * 6. distance같은애를 하나만든다.
             * 7. 제일 큰값 찾기? 7이나오고 5가 나온다면 결국 7보다 큰값이 나오는걸 기대해야한다? 근데 6이나온다면
             * 8. 9가아니라 6이라면, 5는그러면 해결이되는건데, 7은 더큰값을 찾아야한다?
             * 9. 엘스에는 항상 더작은 탑이 오기 때문에 가장 큰값보다 더 크면된다.
             * 10. 작은애들이 오면, 다 스택에 넣고, 큰거를 만나면 해당 스택이 empty가 될때까지 전부 넣어준다.
             * 11. 스택이 비었으면 0을 넣어준다.
             * 12. 스택에 있는 peek값을 비교해준다. 기지국순서랑 높이랑
             *
             * 5
             * 6 9 5 7 4
             *
             * 0 0 2 2 4
             *
             * 4
             * 65 33 95 18
             *
             * 0 1 0 3
             */

            for(int i=0; i<n; i++) {
                if(i==0) {
                    stack.push(List.of(i+1, arr1[i]));
                    sb.append(0).append(" ");
                    continue;
                }

                if(stack.isEmpty()) {
                    sb.append(0).append(" ");
                } else {
                    List<Integer> dumy = stack.peek();
                    if( dumy.get(1) > arr1[i]) {
                        sb.append(dumy.get(0)).append(" ");
                        stack.push(List.of(i+1, arr1[i]));
                    } else {
                        while(!stack.isEmpty()) {
                            stack.pop();
                            if(stack.isEmpty()) {
                                sb.append(0).append(" ");
                                stack.push(List.of(i+1, arr1[i]));
                                break;
                            }

                            List<Integer> dumy2 = stack.peek();
                            if(dumy2.get(1) > arr1[i]) {
                                sb.append(dumy2.get(0)).append(" ");
                                stack.push(dumy2);
                                stack.push(List.of(i+1, arr1[i]));
                                break;
                            }
                        }
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
