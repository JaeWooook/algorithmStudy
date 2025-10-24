package Java.BOJ.String;
import java.io.*;

public class BOJ_11_9342 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //string 기본문제 boj 9342
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int n = readInt(); // 단일 정수 사용
            String[] strArr = readStringArray(n); // 문자열

            /**
             * 1. ABCDEF중 0개또는 1개로 시작해야한다.?
             * 2. 그다음에는 A가 1개 또는 그이상
             * 3. 그다음에는 F가 1개또는그이상
             * 4. 그다음에는 C가 하나 또는 그이상
             * 5. 그다음에는 ABCDEF 중 0개 또는 1개가 있으며, 더이상의 문자는없어야한다.
             * 6. 양끝은 없거나, ABCDEF로 되있어한다. ??
             *
             * 15
             * AFC
             * AAFC
             * AAAFFCC
             * AAFCC
             * BAFC
             *
             * QWEDFGHJMNB
             * DFAFCB
             * ABCDEFC
             * DADC
             * SDFGHJKLQWERTYU
             * AAAAAAAAAAAAABBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCDDDDDDDDDDDEEEEEEEEEEEEEEEFFFFFFFFC
             * AAAFFFFFBBBBCCCAAAFFFF
             * ABCDEFAAAFFFCCCABCDEF
             * AFCP
             * AAFFCPP
             *
             * Infected!
             * Infected!
             * Infected!
             * Infected!
             * Infected!
             * Good
             * Good
             * Good
             * Good
             * Good
             * Good
             * Good
             * Good
             * Good
             * Good
             */
            String regex = "^([ABCDEF])?(A)+(F)+(C)+([ABCDEF])?$";
            for(int i=0; i<n; i++) {
                if(strArr[i].matches(regex)) {
                    sb.append("Infected!").append("\n");
                } else {
                    sb.append("Good").append("\n");
                }
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
