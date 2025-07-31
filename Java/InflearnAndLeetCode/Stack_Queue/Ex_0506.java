package Java.InflearnAndLeetCode.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Ex_0506 {
    public int solution(int n, int k) {
        //8 3
        int answer = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=1; i<=n; i++) {
            queue.add(i);
        }
        for(int i=1; i<n; i++) {
            for(int j=1; j<=n; j++) {
                if(!queue.isEmpty()) {
                    int temp = queue.poll();
                    if(j==k) {
                        break;
                    }
                    queue.add(temp);
                }
            }
        }
        if(!queue.isEmpty()) {
            answer = queue.poll();
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0506 T = new Ex_0506();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.print(T.solution(n, k));
        return ;
    }
}
