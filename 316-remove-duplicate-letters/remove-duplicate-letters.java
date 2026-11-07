class Solution {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) last[s.charAt(i) - 'a'] = i;
        boolean[] used = new boolean[26];
        StringBuilder st = new StringBuilder();  // used as a stack
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (used[c - 'a']) continue;
            // pop bigger letters that appear again later
            while (st.length() > 0) {
                char top = st.charAt(st.length() - 1);
                if (top <= c || last[top - 'a'] < i) break;
                used[top - 'a'] = false;
                st.deleteCharAt(st.length() - 1);
            }
            st.append(c);
            used[c - 'a'] = true;
        }
        return st.toString();
    }
}