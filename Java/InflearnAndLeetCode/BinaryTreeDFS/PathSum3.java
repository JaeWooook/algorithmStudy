package Java.InflearnAndLeetCode.BinaryTreeDFS;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {
    static int answer;
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
    }
    public static int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> vis = new HashMap<>();
//        if(targetSum != 0) {
            vis.put(0L,1);
//        }
        dfs(root, targetSum, vis, 0L);
        return answer;
    }

    public static void dfs(TreeNode root, int targetSum, Map<Long, Integer> prefixMap, Long totalSum) {
        if(root == null) {
            return;
        }

        totalSum += root.val;
        answer += prefixMap.getOrDefault(totalSum-targetSum, 0);
        prefixMap.put(totalSum, prefixMap.getOrDefault(totalSum, 0) + 1);
//        if(targetSum == 0 && totalSum - targetSum != targetSum) {
//            answer -= prefixMap.getOrDefault(totalSum-targetSum,0);
//        }

        dfs(root.left, targetSum, prefixMap, totalSum);
        dfs(root.right, targetSum, prefixMap, totalSum);

        prefixMap.put(totalSum, prefixMap.get(totalSum) - 1);
    }

    public static void main(String[] args) {
        TreeNode left9 = new TreeNode(1);
        TreeNode right8 = new TreeNode(-2);
        TreeNode right2 = new TreeNode(3);
        TreeNode left4 = new TreeNode(11);
        TreeNode right1 = new TreeNode(2, null, left9);
        TreeNode right7 = new TreeNode(3, right2, right8);
        TreeNode left6 = new TreeNode(-3, null, left4);
        TreeNode left5 = new TreeNode(5, right7, right1);
        TreeNode root2 = new TreeNode(10, left5, left6);
        //10 5 -3 3 2 11 3 -2 1

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

        TreeNode left3_5 = new TreeNode(1000000000);
        TreeNode left3_4 = new TreeNode(1000000000, left3_5, null);
        TreeNode left3_3 = new TreeNode(1000000000, left3_4, null);
        TreeNode left3_2 = new TreeNode(294967296, left3_3, null);
        TreeNode left3_1 = new TreeNode(1000000000, left3_2, null);
        TreeNode root3 = new TreeNode(1000000000, left3_1, null);
        //[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]


        TreeNode left4_6 = new TreeNode(-1);
        TreeNode left4_5 = new TreeNode(-2);
        TreeNode left4_4 = new TreeNode(3, null, null);
        TreeNode left4_3 = new TreeNode(1, left4_6, null);
        TreeNode left4_2 = new TreeNode(-3, left4_5, null);
        TreeNode left4_1 = new TreeNode(-2, left4_3, left4_4);
        TreeNode root4 = new TreeNode(1, left4_1, left4_2);
        //[1,-2,-3,1,3,-2,null,-1]

        System.out.println(pathSum(root4, 0));
    }
}
