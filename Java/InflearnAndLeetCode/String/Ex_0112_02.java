package Java.InflearnAndLeetCode.String;

import java.util.Scanner;

public class Ex_0112_02 {
    public String solution(String str, int num) {
        //4
        //#****###**#####**#####**##**
        //#****## #**#### #**#### #**##**
        String answer = "";
        int len = str.length()/num;

        //문자열을 substring을 이용해서 자른다.
        for(int i=0; i<num; i++) {
            String tmpStr=str.substring(0,len).replace('#','1').replace('*', '0');
            //자른부분을 스트링 배열에 넣어준다.
            //replace를 이용해서 #은 1로 *은 0으로 변환시켜준다.
            int tmpDec = Integer.valueOf(tmpStr,2);
            //2진수의 문자열을 10진수로 변환 해준다.
            char tmpChar = (char)tmpDec;
            //Casting을 통해서 10진수의 정수형을 아스키코드를 이용해서 문자형으로 변환한다.
            answer+=String.valueOf(tmpChar);
            //해당 문자형을 String인 문자열로 변환해서 answer에 포함시켜준다.
            str=str.substring(len); // 자르고난 나머지 부분을 str에 저장하면서 초기화 해준다.
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0112_02 T = new Ex_0112_02();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        String s = in.next();
        System.out.print(T.solution(s, i));
        return ;
    }
}
