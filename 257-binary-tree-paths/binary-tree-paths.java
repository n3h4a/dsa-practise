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
    private List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode node, String path) {
        if (node == null) return;
        path += node.val;
        if (node.left == null && node.right == null) {
            res.add(path);
            return;
        }
        dfs(node.left, path + "->");
        dfs(node.right, path + "->");
    }
}