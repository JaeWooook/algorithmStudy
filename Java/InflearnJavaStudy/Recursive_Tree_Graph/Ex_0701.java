package Java.InflearnJavaStudy.Recursive_Tree_Graph;

import java.util.Scanner;

public class Ex_0701 {
    public void solution(int n) {
        //3
        if(n!=1) {
            solution(n-1);
        }
        System.out.print(n+" ");
    }
    public static void main(String[] args){
        Ex_0701 T = new Ex_0701();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        T.solution(n);
        return ;
    }
}
