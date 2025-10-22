package Java.BOJ.String;
import java.io.*;
import java.util.*;

public class BOJ_4_9536 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //string 기본문제 boj 9536
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용

            /**
             * 1. 다른소리를 걸러낸다. 첫째줄엔 테스트케이스 개수 N입력
             * 2. 첫줄에는 몇개의 단어로 이루어진 녹음된 소리가 입력된다. 알파벳소문자로만 이루어져있고, 공백으로 구분
             * 3. 다음줄은 여우를제외한 3줄 동물 goes 소리 형태로 입력된다.
             * 4. 테스트케이스를 우선 고려하지않고, 1다음에 발생하는 첫줄은 우선 전부 ""를 기준으로 배열에 넣어준다 split으로
             * 5. 그다음부터 밑에 다시 숫자가나오기전 say?가 나오기전에 발생한 문자열들을 remove해서 배열에남긴다면된다.
             *
             * 1
             * toot woof wa ow ow ow pa blub blub pa toot pa blub pa pa ow pow toot
             * dog goes woof
             * fish goes blub
             * elephant goes toot
             * seal goes ow
             * what does the fox say?
             *
             * wa pa pa pa pa pa pow
             */
            Map<String, Object> animalSound = new HashMap<>();
            for(int i=0; i<n; i++) {
                String str = readLine();
                String[] answerSound = str.split(" ");
                while(true) {
                    String animal = readLine();
                    if("what does the fox say?".equals(animal)) {
                        break;
                    }
                    //map에 넣는다. key는 소리
                    String[] stringArr = animal.split(" goes ");
                    animalSound.put(stringArr[1], stringArr[0]);
                }

                for(String sound: answerSound) {
                    if(animalSound.containsKey(sound)) continue;
                    sb.append(sound).append(" ");
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static String readLine() throws IOException {
            return br.readLine();
        }
    }
}
