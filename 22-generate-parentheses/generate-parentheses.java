class Solution {
    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        build(new StringBuilder(), 0, 0, n);
        return res;
    }

    private void build(StringBuilder sb, int open, int close, int n) {
        if (sb.length() == 2 * n) { res.add(sb.toString()); return; }
        if (open < n) {
            sb.append('(');
            build(sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            build(sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}