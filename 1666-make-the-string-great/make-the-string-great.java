class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();  // used as a stack
        for (char c : s.toCharArray()) {
            int n = sb.length();
            if (n > 0 && Math.abs(sb.charAt(n - 1) - c) == 32) sb.deleteCharAt(n - 1);  // same letter, different case
            else sb.append(c);
        }
        return sb.toString();
    }
}