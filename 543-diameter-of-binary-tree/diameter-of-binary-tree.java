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
    public int diameterOfBinaryTree(TreeNode root) {
        // BFS order; processing it in reverse visits children before parents (no recursion)
        List<TreeNode> order = new ArrayList<>();
        order.add(root);
        for (int i = 0; i < order.size(); i++) {
            TreeNode node = order.get(i);
            if (node.left != null) order.add(node.left);
            if (node.right != null) order.add(node.right);
        }
        Map<TreeNode, Integer> depth = new HashMap<>();  // nodes on the longest downward path
        int best = 0;
        for (int i = order.size() - 1; i >= 0; i--) {
            TreeNode node = order.get(i);
            int l = node.left == null ? 0 : depth.get(node.left);
            int r = node.right == null ? 0 : depth.get(node.right);
            best = Math.max(best, l + r);  // longest path through this node, in edges
            depth.put(node, 1 + Math.max(l, r));
        }
        return best;
    }
}