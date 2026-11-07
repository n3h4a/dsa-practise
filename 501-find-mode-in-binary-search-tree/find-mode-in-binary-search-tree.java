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
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        Integer prev = null;
        int count = 0, best = 0;
        // iterative inorder: a BST comes out sorted, so equal values are consecutive
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) { stack.push(cur); cur = cur.left; }
            cur = stack.pop();
            count = (prev != null && prev == cur.val) ? count + 1 : 1;
            prev = cur.val;
            if (count > best) {
                best = count;
                modes.clear();
                modes.add(cur.val);
            } else if (count == best) {
                modes.add(cur.val);
            }
            cur = cur.right;
        }
        int[] res = new int[modes.size()];
        for (int i = 0; i < res.length; i++) res[i] = modes.get(i);
        return res;
    }
}