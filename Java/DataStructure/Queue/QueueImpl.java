package Java.DataStructure.Queue;

import java.util.Scanner;

public class QueueImpl {//원형큐 Circular Queue
    int front = 0;//데이터삭제
    int rear = 0;//데이터삽입

    /**
     * 큐에 데이터 추출후 삭제
     * @param que
     * @return
     */
    public int deQueue(int[] que) {
        if(isEmpty()) {
            return -1;
        }
        int outVal = que[front];
        que[front] = 0;//queue값 삭제 초기화
        front = (front + 1) % que.length;
        return outVal;
    }

    /**
     * 큐에 데이터 삽입
     * @param que
     * @param val
     */
    public void enQueue(int[] que, int val) {
        if(isFull(que)) {
            return;
        }
        que[rear] = val;
        rear = (rear + 1) % que.length;
    }

    /**
     * 큐가 꽉찬 상태임을 검증
     * @param que
     * @return
     */
    public boolean isFull(int[] que) {
        if(front == (rear+1) % que.length) {
            System.out.println("Queue is Full");
            return true;
        }
        return false;
    }

    /**
     * 큐가 비었음을 검증
     * @return
     */
    public boolean isEmpty() {
        if(front == rear) {
            System.out.println("Queue is Empty");
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        QueueImpl T = new QueueImpl();
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int[] queue = new int[i];
//        for(int a=0; a<i; a++) {
//            T.enQueue(queue, in.nextInt());
//        }
//
//        for(int a=0; a<=i; a++) {//빈값일때는 -1 노출
//            System.out.println("Queue dequeue value : " + T.deQueue(queue));
//        }
        T.enQueue(queue, 1);
        T.enQueue(queue, 2);
        T.enQueue(queue, 3);
        System.out.println("Queue dequeue value : " + T.deQueue(queue));
        System.out.println("Queue dequeue value : " + T.deQueue(queue));
        T.enQueue(queue, 4);
        T.enQueue(queue, 5);
        System.out.println("Queue dequeue value : " + T.deQueue(queue));
        System.out.println("Queue dequeue value : " + T.deQueue(queue));
        System.out.println("Queue dequeue value : " + T.deQueue(queue));
        System.out.println("Queue dequeue value : " + T.deQueue(queue));
    }
}
