package Java.InflearnJavaStudy.String;

import java.util.Scanner;

public class Ex_0109_02 {
    public int solution(String str) {
        int answer = 0;
        for(char x : str.toCharArray()) {
            if(x >= 48 && x<= 57) {//해당 조건이 아스키코드값으로 숫자 0~9까지의 해당한다.
                answer=answer*10 + (x-48);//해당 로직을 이용하면
                //ex answer가 0이고, 처음에 들어온 x값이 0이라면, 0*10 + (48-48) = 0이된다.
                //1이라면, 0*10+(49-48) = 1이된다.
                //2가 누적된다면, 1*10 + (50-48) 10+2로 12가 되는것을 확인할 수 있다.
                //이러한 방식으로 지속적으로 계산되는 로직이다.
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex_0109_02 T = new Ex_0109_02();
        Scanner in=new Scanner(System.in);
        String s = in.next();
        System.out.println(T.solution(s));
        return ;
    }
}
