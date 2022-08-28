package Java.InflearnJavaStudy.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Ex_0505 {
    public int solution(String str) {
        //()(((()())(())()))(())
        //(((()(()()))(())()))(()())
        int answer = 0;
        char beforeTemp = '\n';
        Stack<Character> stack = new Stack<Character>();
        for(char x : str.toCharArray()) {
            if(x == '(') {
                stack.push(x);
            } else {
                if(!stack.isEmpty()) {
                    if(beforeTemp == '(') {//레이저인 경우 판별
                        stack.pop();
                        answer+=stack.size();//레이저로 자를때 현재 존재하는 닫히지 않는 쇠 막대기 개수 포함
                    } else {//쇠 막대기가 끝날때 개수를 포함한다.
                        stack.pop();
                        answer++;
                    }
                }
            }
            beforeTemp = x;
        }

        return answer;
    }

    public static void main(String[] args){
        Ex_0505 T = new Ex_0505();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.print(T.solution(str));
        return ;
    }
}
