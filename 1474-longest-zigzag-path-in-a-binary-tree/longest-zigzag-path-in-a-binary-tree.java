/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int longestZigZag(TreeNode root) {
        int best = 0;
        // len[0] = zigzag length ending here whose last step went left, len[1] = last step went right
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<int[]> lens = new ArrayDeque<>();
        nodes.push(root);
        lens.push(new int[]{0, 0});
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int[] len = lens.pop();
            best = Math.max(best, Math.max(len[0], len[1]));
            if (node.left != null) { nodes.push(node.left); lens.push(new int[]{len[1] + 1, 0}); }
            if (node.right != null) { nodes.push(node.right); lens.push(new int[]{0, len[0] + 1}); }
        }
        return best;
    }
}