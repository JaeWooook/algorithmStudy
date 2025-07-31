package Java.InflearnAndLeetCode.Recursive_Tree_Graph;

import java.util.Scanner;

public class Ex_0703 {
    public int solution(int n) {
        //5
        if(n==1) {
           return 1;
        }
        return n*solution(n-1);
    }
    public static void main(String[] args){
        Ex_0703 T = new Ex_0703();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.print(T.solution(n));
        return ;
    }
}
