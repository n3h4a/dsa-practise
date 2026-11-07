class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) sb.deleteCharAt(sb.length() - 1);  // removes closest non-digit to the left
            else sb.append(c);
        }
        return sb.toString();
    }
}