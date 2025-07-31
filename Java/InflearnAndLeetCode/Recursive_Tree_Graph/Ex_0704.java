package Java.InflearnAndLeetCode.Recursive_Tree_Graph;

import java.util.Scanner;

public class Ex_0704 {
    public int solution(int n) {
        //10
        if(n <= 1) {
            return n;
        }else {
            return solution(n-2)+solution(n-1);
        }
    }
    public static void main(String[] args){
        Ex_0704 T = new Ex_0704();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=1; i<=n; i++) {
            System.out.print(T.solution(i)+" ");
        }
        return ;
    }
}
