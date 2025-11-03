package Java.BOJ.Greedy;
import java.io.*;
import java.util.*;

public class BOJ_3_2217 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //그리디 연습문제 boj 2217
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            int[] arr1 = readIntLineByArray(n); // 1차원 배열 사용

            /**
             * 1. 로프가 N개, 각 버틸수있는 중량의 무게가 주어 진다.
             * 2. 로프를 병렬로 연결하면 각각 로프에 걸리는 중량을 나눌 수 있다.
             * 3. k개의 로프를 사용해 중량이 w인 물체를 들어 올리면 각각의 로프는 w/k 만큼의 중량이 걸린다.
             * 4. 최대 중량을 구하라 모든 로프를 사용할 필요는 없다.
             * 5. 만약 2개를 겹쳐서 놓는 다면, 10+15 / 2 가 중량인가? 25 / 2 -> 12.5
             * 6. 20 / 2 -> 10이 걸리는거네, 그렇다면 우선 전체의 합
             * 7. 일단 전체의합에서 -1씩하면서 찾는건 맞는거 같은데. 만일 제일 작은것이 걸린다면 예외가 1이 있다면 1은 다안될것
             * 8. 그럼 그 1을 제일작은것을 제외한 개수 w/k-1로 나누어졌을때 모두 통과된다면
             *
             * 2
             * 10
             * 15
             * -> 20
             */
            Integer[] boxedArr = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
            Arrays.sort(boxedArr, (a,b) -> b-a);
            int max = 0;
            int cnt = 0;
            for(int i=0; i<boxedArr.length; i++) {
                if(i==0) {
                    max = boxedArr[0];
                    cnt++;
                } else {
                    cnt++;
                    int afterWeight = cnt*boxedArr[i];
                    if(max < afterWeight) {
                        max = afterWeight;
                    }
                }

            }
            sb.append(max);
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
