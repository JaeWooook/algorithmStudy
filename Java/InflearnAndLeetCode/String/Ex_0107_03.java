package Java.InflearnAndLeetCode.String;

import java.util.Scanner;

public class Ex_0107_03 {
    public String solution(String str) {
        String answer = "NO";
        //StringBuilder를 이용한 문자열 뒤집는 방법
        String temp = new StringBuilder(str).reverse().toString(); // 스트링빌더 객체이기 때문에 다시 String객체로 캐스팅해준다.
//        if(temp.equals(str)) {//그냥 equals는 대소문자를 구분한다.
            //그래서 uppercase를 하던지
            if(temp.equalsIgnoreCase(str)) {//대소문자를 상관없이 그냥 글자만 같으면 같다고 생각하도록 이그노어케이스를 이용한다.
            answer = "YES";
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0107_03 T = new Ex_0107_03();
        Scanner in=new Scanner(System.in);
        String s = in.next();
        System.out.println(T.solution(s));
        return ;
    }
}
