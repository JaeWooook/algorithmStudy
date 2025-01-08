package Java.DataStructure.Stack;

import java.util.Scanner;

public class StackImpl {
    int top = -1;

    /**
     * 스택에 데이터 추출후 데이터 삭제
     * @param stack
     * @return
     */
    public int pop(int[] stack) {
        if(isEmpty()) {
            return -1;
        }

        int popVal = stack[top];
        stack[top] = 0;//스택값 초기화
        top--;
        return popVal;
    }

    /**
     * 스택에 데이터 삽입
     * @param stack
     * @param val
     */
    public void push(int[] stack, int val) {
        if(isFull(stack)) {
            return;
        }
        top++;
        stack[top] = val;
    }

    /**
     * 스택이 비었는지 검증
     * @return
     */
    public boolean isEmpty() {
        if(top <= -1) {
            System.out.println("Stack is Empty");
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull(int[] stack) {
        if(top == stack.length) {
            System.out.println("Stack is Full");
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        StackImpl T = new StackImpl();
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int[] stack = new int[i];
        for(int a=0; a<i; a++) {
            T.push(stack, in.nextInt());
        }

        for(int a=0; a<=i; a++) {//빈값일때는 -1 노출
            System.out.println("Stack pop value : " + T.pop(stack));
        }
    }
}
