package Java.InflearnJavaStudy.String;

import java.util.Collections;
import java.util.Scanner;

public class Ex_0112 {
    public String solution(String str, int num) {
        //4
        //#****###**#####**#####**##**
        //#****## #**#### #**#### #**##**
        String answer = "";
        int[] DigitArray = new int[str.length()];
        String[] tmpArray = new String[num];
        char[] chaArray = str.toCharArray();
        int len = str.length()/num;
        int i=0;

        //2진수로 변환
        for(int a=0; a<str.length(); a++) {
            if(chaArray[a] == '#') {
                DigitArray[a]=1;
            }else {
                DigitArray[a]=0;
            }
        }

        //len만큼 잘라서 넣어주기
        for(char x : str.toCharArray()) {
            if(tmpArray[i] == null) { //String배열의 null값을 처리하기위한 조건
                tmpArray [i] = String.valueOf(x);
            }
            else {
                tmpArray[i] +=x;
            }
            if(tmpArray[i].length()==len) {
                i++;
            }
        }
        
        //10진수로 변환
        
        //아스키코드로 문자 변환

        for(int j=0; j<tmpArray.length; j++) {
            System.out.println(tmpArray[j]);
        }
        System.out.println(len);


        return answer;
    }

    public static void main(String[] args){
        Ex_0112 T = new Ex_0112();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        String s = in.next();
        System.out.print(T.solution(s, i));
        return ;
    }
}
