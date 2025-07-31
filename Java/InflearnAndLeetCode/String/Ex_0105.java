package Java.InflearnAndLeetCode.String;

import java.util.Scanner;

public class Ex_0105 {
    public String solution(String str) {
        String answer = "";
        int lt = 0;
        int rt = str.length() - 1;
        //스트링 문자열을 배열형태의 문자열로 만들어준다.
        char[] text = str.toCharArray();
        while (lt < rt) {
            //Character.isAlphabetic(문자) 하면 알파벳이면 true 아니면 false다.
            if (!Character.isAlphabetic(text[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(text[rt])) {
                rt--;
            } else {
                char tmp = text[lt];
                text[lt] = text[rt];
                text[rt] = tmp;
                lt++;
                rt--;
            }
            //아래는 오답
//            if(Character.isAlphabetic(text[lt]) && Character.isAlphabetic(text[rt])) {
//                char tmp = text[lt];
//                text[lt] = text[rt];
//                text[rt] = tmp;
//                lt++;
//                rt--;
//            }
//            else {
//                lt++;
//                rt--;
//            }
        }
        //문자열형태의 배열이기때문에 이것을 다시 문자열로 변환
        answer = String.valueOf(text);

        return answer;
    }
        public static void main(String[] args){
            Ex_0105 T = new Ex_0105();
            Scanner in=new Scanner(System.in);
            String s = in.next();
            System.out.println(T.solution(s));
            return ;
        }
}
