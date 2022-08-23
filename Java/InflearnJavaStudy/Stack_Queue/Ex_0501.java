package Java.InflearnJavaStudy.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Ex_0501 {
    public String solution(String str1) {
        //(()(()))(()
        String answer = "NO";
        Stack<Character> stack = new Stack<Character>();
        for(char x : str1.toCharArray()) {
            if(x == '(') {
                stack.push(x);
            }
            else {
                if(stack.isEmpty()) {//닫는 괄호일때 여는괄호가 없는 경우
                    return answer;
                } else {//짝이 맞아서 여는괄호가 있는 경우는 pop해서 삭제한다.
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()) {
            answer="YES";
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0501 T = new Ex_0501();
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        System.out.print(T.solution(str1));
        return ;
    }
}
