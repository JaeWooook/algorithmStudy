package Java.InflearnAndLeetCode.BinaryTreeDFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeafSimilarTrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static void main(String[] args) {
            TreeNode left9 = new TreeNode(9);
            TreeNode right8 = new TreeNode(8);
            TreeNode right2 = new TreeNode(2, left9, right8);
            TreeNode left4 = new TreeNode(4);
            TreeNode right1 = new TreeNode(1, left4, right2);
            TreeNode right7 = new TreeNode(7);
            TreeNode left6 = new TreeNode(6);
            TreeNode left5 = new TreeNode(5, left6, right7);
            TreeNode root2 = new TreeNode(3, left5, right1);
            //6 7 4 8 9

            TreeNode left1_9 = new TreeNode(9);
            TreeNode right1_8 = new TreeNode(8);
            TreeNode right1_4 = new TreeNode(4);
            TreeNode left1_7 = new TreeNode(7);
            TreeNode right1_2 = new TreeNode(2, left1_7, right1_4);
            TreeNode right1_1 = new TreeNode(1, left1_9, right1_8);
            TreeNode left1_6 = new TreeNode(6);
            TreeNode left1_5 = new TreeNode(5, left1_6, right1_2);
            TreeNode root1 = new TreeNode(3, left1_5, right1_1);
            //6 7 4 8 9

            List<Integer> arr1 = new ArrayList<Integer>();
            List<Integer> arr2 = new ArrayList<Integer>();

            Deque<TreeNode> deq1 = new ArrayDeque<>();
            Deque<TreeNode> deq2 = new ArrayDeque<>();

            deq1.offerFirst(root1);
            while(!deq1.isEmpty()) {
                TreeNode node = deq1.pollLast();
                if(node.right != null) {
                    deq1.offerLast(node.right);
                }
                if(node.left != null) {
                    deq1.offerLast(node.left);
                }

                if(node.left == null && node.right == null) {
                    arr1.add(node.val);
                }
            }

            deq2.offerFirst(root2);
            while(!deq2.isEmpty()) {
                TreeNode node = deq2.pollLast();
                if(node.right != null) {
                    deq2.offerLast(node.right);
                }
                if(node.left != null) {
                    deq2.offerLast(node.left);
                }

                if(node.left == null && node.right == null) {
                    arr2.add(node.val);
                }
            }

            //3, 9, 20, null, null, 15, 7
            //1, null, 2
            for(Integer i : arr1) {
                System.out.print(i + " ");
            }
            System.out.println();
            for(Integer j : arr2) {
                System.out.print(j + " ");
            }
        }
    }
}
