package Java.InflearnAndLeetCode.String;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_0104_01 {
    public ArrayList<String> solution(String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        for(String x : str) {
            String temp = new StringBuilder(x).reverse().toString();
            answer.add(temp);
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0104_01 T = new Ex_0104_01();
        Scanner in= new Scanner(System.in);
        int cnt  = in.nextInt();
        String[] str = new String[cnt];
        for(int i=0; i<cnt; i++) {
            str[i]=in.next();
        }
        for(String dap : T.solution(str)) {
            System.out.println(dap);
        }
    }
}
