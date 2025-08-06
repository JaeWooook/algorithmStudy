package Java.InflearnAndLeetCode.BinaryTreeDFS;

import java.util.ArrayList;
import java.util.List;

public class CountGoodNodesInBinaryTree {
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

        public static void DFS(TreeNode root, List<Integer> arr, int preMax) {
            if(root == null) {
                return;
            }

            int max = preMax;
            if(preMax <= root.val) {
                max = root.val;
                arr.add(1);
            }

            DFS(root.left, arr, max);
            DFS(root.right, arr, max);
        }

        public static void main(String[] args) {
//        TreeNode left1_9 = new TreeNode(9);
//        TreeNode right1_8 = new TreeNode(8);
//        TreeNode right1_4 = new TreeNode(4);
            TreeNode left2_1 = new TreeNode(1);
            TreeNode right1_5 = new TreeNode(5);
            TreeNode right1_4 = new TreeNode(4, left2_1, right1_5);
            TreeNode left1_3 = new TreeNode(3);
            TreeNode left1_1 = new TreeNode(1, left1_3, null);
            TreeNode root1 = new TreeNode(3, left1_1, right1_4);
            //good node

//        TreeNode left9 = new TreeNode(9);
//        TreeNode right8 = new TreeNode(8);
//        TreeNode right2 = new TreeNode(2, left9, right8);
//        TreeNode left4 = new TreeNode(4);
//        TreeNode right1 = new TreeNode(1, left4, right2);
            TreeNode right2 = new TreeNode(2);
            TreeNode left4 = new TreeNode(4);
            TreeNode left3 = new TreeNode(3, left4, right2);
            TreeNode root2 = new TreeNode(3, left3, null);
            //6 7 4 8 9

            List<Integer> exam = new ArrayList<Integer>();
            DFS(root1, exam, Integer.MIN_VALUE);

            System.out.println(exam.size());
        }
    }
}
