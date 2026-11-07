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
    private Map<Long, Integer> prefixCount;
    private int target, count;

    public int pathSum(TreeNode root, int targetSum) {
        prefixCount = new HashMap<>();
        prefixCount.put(0L, 1);
        target = targetSum;
        count = 0;
        dfs(root, 0L);
        return count;
    }

    // a downward path ending here sums to target iff some ancestor prefix == sum - target
    private void dfs(TreeNode node, long sum) {
        if (node == null) return;
        sum += node.val;
        count += prefixCount.getOrDefault(sum - target, 0);
        prefixCount.merge(sum, 1, Integer::sum);
        dfs(node.left, sum);
        dfs(node.right, sum);
        prefixCount.merge(sum, -1, Integer::sum);  // backtrack
    }
}