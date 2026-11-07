class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int best = 0, cur = 0;
        for (int x : nums) {
            cur = x == 1 ? cur + 1 : 0;
            best = Math.max(best, cur);
        }
        return best;
    }
}