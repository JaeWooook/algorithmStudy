package Java.InflearnJavaStudy.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_0206_01 {
    // 소수판별 함수
    // 1~N까지 반복하여 나누면서 나누어떨어지면 count를 증가시킨다.
    public static boolean isPrime(int N){
        // 위의 명제에서 "1보다 큰 자연수"이므로 1은 소수가 아니다.
        if( N == 1 ) return false;

        int count = 0;
        for(int i = 1; i <= N; i++){
            if( N % i == 0 ){
                count += 1;
            }
        }
        return count == 2;
    }
    public ArrayList<Integer> solution(int[] array) {
        //9
        //32 55 62 20 250 370 200 30 100
        ArrayList<Integer> answer = new ArrayList<Integer>();
        String[] strArr = new String[array.length+1];
        for(int i=0; i<array.length; i++) {
            strArr[i]=String.valueOf(array[i]);
        }
        for(int i=0; i<array.length; i++) {//문자열 뒤집기
            strArr[i]=new StringBuilder(strArr[i]).reverse().toString();
        }
        int[] digitArr = new int[array.length+1];
        for(int i=0; i<array.length; i++) {
            digitArr[i]=Integer.parseInt(strArr[i]);
        }
        for(int i=0; i<array.length; i++) {
            if(isPrime(digitArr[i])) {
                answer.add(digitArr[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0206_01 T = new Ex_0206_01();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        int[] array = new int[i];
        for(int a=0; a<i; a++) {
            array[a] = in.nextInt();
        }
        for(int x : T.solution(array)) {
            System.out.print(x+" ");
        }
        return ;
    }
}
