package Java.InflearnAndLeetCode.Recursive_Tree_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Ex_0707 {
    private static class Node{
        int data;
        Node lt, rt;

        public Node(int val){
            this.data = val;
            lt = rt = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        solutionBFS(root);
    }

    private static void solutionBFS(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        int level = 0;

        int len = 0;
        while(!queue.isEmpty()){
            len = queue.size();
//            System.out.print(level + " : ");

            for (int i = 0; i < len; i++) {
                Node currentNode = queue.poll();
                System.out.print(currentNode.data + " ");

                if(currentNode.lt != null){
                    queue.offer(currentNode.lt);
                }

                if (currentNode.rt != null) {
                    queue.offer(currentNode.rt);
                }
            }

//            level++;
//            System.out.println("");
        }
    }
}
