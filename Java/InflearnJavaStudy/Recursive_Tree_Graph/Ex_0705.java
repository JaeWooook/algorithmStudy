package Java.InflearnJavaStudy.Recursive_Tree_Graph;

import java.util.Scanner;

public class Ex_0705 {
    int count;

    public Ex_0705() {
        count = 0;
    }
    public class Node {
        Object data;
        Node left;
        Node right;

        // 생성시 매개변수를 받아 초기화하는 방법으로만 선언 가능
        public Node(Object data) {
            this.data = data;
            left = null;
            right = null;
        }
        public void addLeft(Node node) {
            left = node;
            count++;
        }
        public void addRight(Node node) {
            right = node;
            count++;
        }
    }
    public Node addNode(Object data) {
        Node n = new Node(data);
        return n;
    }
    public void preOrder(Node node) {//전위순회
        if(node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {//중위순회
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void postOrder(Node node) {//후위순회
        if(node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
    public static void main(String[] args){
        Ex_0705 T = new Ex_0705();
        Node node1 = T.addNode(1);
        Node node2 = T.addNode(2);
        Node node3 = T.addNode(3);
        Node node4 = T.addNode(4);
        Node node5 = T.addNode(5);
        Node node6 = T.addNode(6);
        Node node7 = T.addNode(7);

        // 트리 연결관계 생성
        /*  트리 모양
         *        1
         *     2     3
         *   4  5  6   7
         */
        node1.addLeft(node2);
        node1.addRight(node3);
        node2.addLeft(node4);
        node2.addRight(node5);
        node3.addLeft(node6);
        node3.addRight(node7);

        // 순회
        T.preOrder(node1);
        System.out.println();
        T.inOrder(node1);
        System.out.println();
        T.postOrder(node1);
        System.out.println();
        return ;
    }
}
