package Java.InflearnAndLeetCode.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_0507 {
    public String solution(String str1, String str2) {
        //CBA
        //CBDAGE
        String answer = "NO";
        Queue<Character> queue = new LinkedList<Character>();
        for(char x  : str1.toCharArray()) {
            queue.offer(x);
        }
        for(char x : str2.toCharArray()) {
            if(!queue.isEmpty()) {
                if(queue.peek() == x) {
                    queue.poll();
                }
            }
        }
        if(queue.isEmpty()) {
            return "YES";
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0507 T = new Ex_0507();
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.print(T.solution(str1, str2));
        return ;
    }
}
