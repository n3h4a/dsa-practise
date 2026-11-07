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
    private Map<Integer, Integer> inIndex;
    private int[] postorder;
    private int post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        post = postorder.length - 1;
        inIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inIndex.put(inorder[i], i);
        return build(0, inorder.length - 1);
    }

    // postorder read backwards is root, right, left, so build the right subtree first
    private TreeNode build(int lo, int hi) {
        if (lo > hi) return null;
        TreeNode root = new TreeNode(postorder[post--]);
        int mid = inIndex.get(root.val);
        root.right = build(mid + 1, hi);
        root.left = build(lo, mid - 1);
        return root;
    }
}