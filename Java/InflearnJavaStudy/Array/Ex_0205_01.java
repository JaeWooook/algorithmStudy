package Java.InflearnJavaStudy.Array;

import java.util.Scanner;

public class Ex_0205_01 {
    public int solution(int num) {
        //20
//        ArrayList<Integer> answer= new ArrayList<Integer>();
        int answer=0;
        for(int i=2; i<=num; i++) {
            if(i==2 || i==3 || i==5 || i==7) {
                answer++;
            }
            else {
                if(i%2 != 0 && i%3 != 0 && i%5 != 0 && i%7 != 0) {
                    answer++;
                }
            }
        }
//        for(int i : answer) {
//            System.out.print(i+" ");
//        }
//        System.out.println("");
        return answer;
    }

    public static void main(String[] args){
        Ex_0205_01 T = new Ex_0205_01();
        Scanner in=new Scanner(System.in);
        int i = in.nextInt();
        System.out.print(T.solution(i));
        return ;
    }
}
