package Java.InflearnJavaStudy.Recursive_Tree_Graph;

import java.util.Scanner;

public class Ex_0702 {
    public void solution(int n) {
        //11
        if(n/2 >= 1) {
            solution(n/2);
        }
        System.out.print(n%2);
    }
    public static void main(String[] args){
        Ex_0702 T = new Ex_0702();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        T.solution(n);
        return ;
    }
}
