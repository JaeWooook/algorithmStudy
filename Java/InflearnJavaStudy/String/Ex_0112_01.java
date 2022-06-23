package Java.InflearnJavaStudy.String;

import java.util.Scanner;

public class Ex_0112_01 {
    public String solution(String str, int num) {
        //4
        //#****###**#####**#####**##**
        //#****## #**#### #**#### #**##**
        String answer = "";
        int[] DigitArray = new int[num];
        String[] tmpArray = new String[num];
        char[] chaArray = str.toCharArray();
        int len = str.length()/num;
        int i=0;

        //2진수로 변환 && len만큼 잘라서 넣어주기
        for(char x : str.toCharArray()) {
            if(tmpArray[i] == null) { //String배열의 null값을 처리하기위한 조건
                if(x == '#') {
                    tmpArray[i] = String.valueOf('1');
                } else {
                    tmpArray[i] = String.valueOf('0');
                }
            }
            else {
                if(x == '#') {
                    tmpArray[i] += '1';
                } else {
                    tmpArray[i] += '0';
                }
            }
            if(tmpArray[i].length()==len) {
                i++;
            }
        }
        //10진수로 변환
        for(int j=0; j<DigitArray.length; j++) {
            DigitArray[j] = Integer.valueOf(tmpArray[j],2);
        }
        //아스키코드로 문자 변환
        for(int a=0; a<DigitArray.length; a++) {
            char tmp = (char)DigitArray[a];
            answer+=String.valueOf(tmp);
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0112_01 T = new Ex_0112_01();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        String s = in.next();
        System.out.print(T.solution(s, i));
        return ;
    }
}
