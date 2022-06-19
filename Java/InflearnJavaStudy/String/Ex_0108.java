package Java.InflearnJavaStudy.String;

import java.util.Scanner;

public class Ex_0108 {
    public String solution(String str) {
        String answer = "NO";
        str=str.toUpperCase();
        str=str.replaceAll("[^0-9A-Z]","");//replaceAll에서는 정규식을 사용할 수 있다.
        //^를 이용해서 부정한다 해당 정규식이 아니면 대체한다는 의미이다.
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) {
            answer="YES";
        }

        return answer;
    }

    public static void main(String[] args){
        Ex_0108 T = new Ex_0108();
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();// 띄어쓰기도 있기 때문에 next()가 아닌 nextLine()을 이용한다.
        System.out.println(T.solution(s));
        return ;
    }
}
