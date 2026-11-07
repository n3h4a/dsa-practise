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
    private int cams;

    public int minCameraCover(TreeNode root) {
        cams = 0;
        if (dfs(root) == 0) cams++;
        return cams;
    }

    // 0 = not covered, 1 = has camera, 2 = covered (no camera)
    private int dfs(TreeNode node) {
        if (node == null) return 2;
        int l = dfs(node.left), r = dfs(node.right);
        if (l == 0 || r == 0) { cams++; return 1; }
        if (l == 1 || r == 1) return 2;
        return 0;
    }
}