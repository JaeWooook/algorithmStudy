package Java.InflearnJavaStudy.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Ex_0502 {

    public String solution(String str1) {
        //(A(BC)D)EF(G(H)(IJ)K)LM(N)
        String answer = "";
        Stack<Character> stack = new Stack<Character>();
        for(char x : str1.toCharArray()) {
            if(x != ')') {
                stack.push(x);
            }
            else {// ')' 짝을 만나게 되면 '('을 만날때 까지 전부 스택 내부를 삭제한다.
                while(!stack.isEmpty()) { // stack을 끝까지 돌리기 위해 while문의 isEmpty를 사용한다.
                    if(stack.pop() == '(') {// 짝이 되지 않는 문자만 남게 된다. 2중 loop를 통해서 기존에 넣어둔 ()짝이 되는 괄호를 전부 삭제한다.
                        break;
                    }
                }
            }
        }
        for(char x: stack) {
            answer += x;
        }
        return answer;
    }

    public static void main(String[] args){
        Ex_0502 T = new Ex_0502();
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        System.out.print(T.solution(str1));
        return ;
    }
}
