/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();  // LinkedList allows null entries
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) { sb.append("#,"); continue; }
            sb.append(node.val).append(',');
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] t = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(t[0]));
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (!t[i].equals("#")) { node.left = new TreeNode(Integer.parseInt(t[i])); q.add(node.left); }
            i++;
            if (!t[i].equals("#")) { node.right = new TreeNode(Integer.parseInt(t[i])); q.add(node.right); }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));