class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1, len = 0;
        while (i >= 0 && s.charAt(i) == ' ') i--;  // skip trailing spaces
        while (i >= 0 && s.charAt(i) != ' ') { len++; i--; }
        return len;
    }
}