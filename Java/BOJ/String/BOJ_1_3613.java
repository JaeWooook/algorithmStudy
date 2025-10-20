package Java.BOJ.String;
import java.io.*;

public class BOJ_1_3613 {
    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //string 기본문제 boj 3613
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            String str = readLine();

            /**
             * 1. c++은 java형으로 java는 c++형의 변수명으로변환한다.
             * 2. c++는 변수마다 _ 를 이용하여 단어를구분하고, java는 소문자시작이고 대문자로 단어를 구분한다.
             * 3. 우선 c++형이냐 java형이냐를 구분하는 방법이다. 모두가 아니라면 Error!를 출력한다.
             * 4. c++형은 모두 소문자이면서 단어사이에 _를 넣는다. ->바꿔말하면 대문자가 하나라도있고, _가 있다면 탈락 ->에러
             * 5. java형은 시작은 소문자이고, 각 단어사이에 대문자를 넣는다. ->바꿔말하면 첫문자가 대문자면 탈락
             *
             * long_and_mnemonic_identifier
             */
            char[] chars = str.toCharArray();
            String firstUp = String.valueOf(chars[0]).toUpperCase();
            if( !str.contains("_") && !firstUp.equals(String.valueOf(chars[0]))) {//java
                StringBuilder tmp =  new StringBuilder();
                for(int i=0; i<chars.length; i++) {
                    String up = String.valueOf(chars[i]).toUpperCase();
                    if(up.equals(String.valueOf(chars[i]))) {
                        tmp.append("_").append(up.toLowerCase());
                    } else {
                        tmp.append(chars[i]);
                    }
                }
                sb.append(tmp);
            } else if(str.toLowerCase().equals(str) && '_' != chars[0] && '_' != chars[chars.length-1]) {//c언어
                //java로 변환
                if(str.contains("_")) {
                    StringBuilder tmp = new StringBuilder();
                    boolean isError = false;
                    for(int i=0; i<chars.length; i++) {
                        if(chars[i] == '_' && i !=  chars.length - 1 && chars[i+1] != '_') {
                            String up = String.valueOf(chars[i+1]);
                            tmp.append(up.toUpperCase());
                            i++;
                        } else if(i != chars.length -1 && chars[i] == '_' &&chars[i+1] == '_') {
                            isError = true;
                        } else {
                            tmp.append(chars[i]);
                        }
                    }
                    if(isError) {
                        sb.append("Error!");
                    } else {
                        sb.append(tmp);
                    }
                } else {
                    sb.append(str);
                }
            } else {
                sb.append("Error!");
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static String readLine() throws IOException {
            return br.readLine();
        }
    }
}
