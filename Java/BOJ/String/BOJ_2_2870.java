package Java.BOJ.String;
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class BOJ_2_2870 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //string 기본문제 boj 2870
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            String[] strArr = readStringArray(n); // 문자열

            /**
             * 1. 숫자와 알파벳 소문자로 되어있는글자, 이숫자를 비내림차순(오름차순)으로 정리한다.
             * 2. 숫자의 앞에 0이 있다면 생략이된다. 즉, 문자앞에 0이면 생략하지않는다.
             * 3. 01a2b3456cde478 -> 숫자를 찾으면 1,2,3456,478이다.
             * 4. 우선 숫자냐 문자냐를 기준으로 문자이면, sb를 초기화한다. 숫자인경우 sb에 넣는다.
             * 5. 다음 문자일때 sb가 size가 > 0보다 크다면 해당문자를 int[]배열에 넣는다.
             * 6. 배열에있는 수들을, arrays.sort로 정렬하고, 오름차순으로
             * 7. 0일때는 0뒤에 숫자인지 문자인지 확인한다. 맨뒤에있는 0이라면 괜찮다.
             * 8. 즉, 007 은 7과 동일하다는 의미이다. 애초에 무시된다. 숫자면 그냥 다 sb에 넣으면된다.
             *
             * 2
             * lo3za4
             * 01
             */
            List<BigInteger> answer = new ArrayList<>();
            for(int i=0; i<strArr.length; i++) {
                char[] chars = strArr[i].toCharArray();
                StringBuilder tmp = new StringBuilder();
                for(int j=0; j<chars.length; j++) {
                    if(Character.isDigit(chars[j])) {
                        tmp.append(chars[j]);
                        if(j==chars.length-1 && tmp.length() > 0) {
                            answer.add(new BigInteger(tmp.toString()));
                        }
                    } else {
                        if(tmp.length() > 0) {
                            answer.add(new BigInteger(tmp.toString()));
                            tmp.setLength(0);
                        }
                    }
                }
            }

            Collections.sort(answer);
            for(int i=0; i<answer.size(); i++) {
                sb.append(answer.get(i)).append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static String[] readStringArray(int size) throws IOException {
            String[] arr = new String[size];
            for (int i = 0; i < size; i++) {
                arr[i] = br.readLine();
            }
            return arr;
        }
    }
}
