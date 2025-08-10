package Java.InflearnAndLeetCode.BinaryTreeBFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BinaryTreeRightSideView {
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

    public static void main(String[] args) {
        TreeNode right1 = new TreeNode(4);
        TreeNode right7 = new TreeNode(5);
        TreeNode left6 = new TreeNode(3, null, right1);
        TreeNode left5 = new TreeNode(2, null, right7);
        TreeNode root2 = new TreeNode(1, left5, left6);
        //[1,2,3,null,5,null,4]

        List<Integer> result = rightSideView(root2);
        for(Integer re : result) {
            System.out.print(re + " ");
        }
    }
    static List<Integer> answer = new ArrayList<Integer>();
    public static List<Integer> rightSideView(TreeNode root) {
        bfs(root);
        return answer;
    }

    public static void bfs(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        //인접 노드 순회하고, 오른쪽부터 bfs사용
        Queue<Integer> visDepth = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();

        que.offer(root);
        visDepth.offer(0);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            Integer depth = visDepth.poll();
            if (!vis.contains(depth) && node != null) {
                vis.add(depth);
                answer.add(node.val);
            }

            if (node == null)
                continue;

            if (node.right != null) {
                visDepth.offer(depth+1);
                que.offer(node.right);
            }

            if (node.left != null) {
                visDepth.offer(depth+1);
                que.offer(node.left);
            }
        }

    }
}
