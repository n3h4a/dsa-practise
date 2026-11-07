class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sToT = new int[256], tToS = new int[256];  // stored as char + 1, 0 = unmapped
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (sToT[a] == 0 && tToS[b] == 0) {
                sToT[a] = b + 1;
                tToS[b] = a + 1;
            } else if (sToT[a] != b + 1 || tToS[b] != a + 1) {
                return false;
            }
        }
        return true;
    }
}