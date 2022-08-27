package Java.InflearnJavaStudy.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Ex_0504 {
    public int solution(String str) {
        //352+*9-
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for(char ch : str.toCharArray()) {
            if(Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
            } else {
                if(!stack.isEmpty()) {
                    int tmp1 = stack.pop();
                    int tmp2 = stack.pop();
                    if(ch == '+') {
                        stack.push(tmp1 + tmp2);
                    } else if (ch == '-') {
                        if(tmp1 > tmp2) {
                            stack.push(tmp1 - tmp2);
                        }
                        else {
                            stack.push(tmp2-tmp1);
                        }
                    } else if (ch == '*') {
                        stack.push(tmp1 * tmp2);
                    } else {
                        stack.push(tmp1/tmp2);
                    }
                }
            }
        }
        answer = stack.pop();
        return answer;
    }

    public static void main(String[] args){
        Ex_0504 T = new Ex_0504();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.print(T.solution(str));
        return ;
    }
}
