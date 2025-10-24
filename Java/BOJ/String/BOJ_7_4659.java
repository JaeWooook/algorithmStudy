package Java.BOJ.String;
import java.io.*;
import java.util.*;

public class BOJ_7_4659 {

    public static class Main {

        static BufferedReader br;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            //string 기본문제 boj 4659
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            /**
             * 1. 모음 aeiou는 1개는 반드시 포함
             * 2. 모음이 3개연속 자음이 3개연속 오면 안된다.
             * 3. 같은글자가 연속 2번은 안된다.
             *
             * a
             * tv
             * ptoui
             * bontres
             * zoggax
             * wiinq
             * eep
             * houctuh
             * end
             */

            while(true) {
                String password = readLine();
                if(password.equals("end")) break;

                char[] passwords = password.toCharArray();
                String vowel = "aeiou";
                int includeVowel = 0;
                int limitConsonant = 0;
                int limitVowel = 0;
                boolean pass = true;

                for(int i=0; i< passwords.length; i++) {
                    if(vowel.indexOf(passwords[i]) > -1) {
                        includeVowel++;
                        limitVowel++;
                        limitConsonant = 0;
                    } else {
                        limitConsonant++;
                        limitVowel = 0;
                    }

                    if(i != 0 && passwords[i] != 'e' && passwords[i] != 'o' && passwords[i] == passwords[i-1]) {
                        pass = false;
                        break;
                    }

                    if(limitVowel > 2 || limitConsonant > 2) {
                        pass = false;
                        break;
                    }
                }

                if(includeVowel < 1) {
                    pass = false;
                }

                if(pass) {
                    sb.append("<").append(password).append(">").append(" is acceptable.").append("\n");
                } else {
                    sb.append("<").append(password).append(">").append(" is not acceptable.").append("\n");
                }
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
