package Java.BigStone.Implement;

public class Ex01 {

    public static void main(String[] args) {
        String abc = "abcde";
        String dopa = " umzunsik";

        System.out.println("Q1. 앞에서부터 3개의 문자열을 출력하라. " + abc.substring(0,3));
        StringBuilder sb = new StringBuilder(abc);
        System.out.println("Q2. 해당문자열을 거꾸로해서 출력하라. " + sb.reverse());
        System.out.println("Q3. 해당 문자열 끝에 \"umzunsik\"이란 문자열을 추가하라. " + abc.concat(dopa));

    }
}
