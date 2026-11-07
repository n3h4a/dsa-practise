class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] % 2 == 0) l++;
            else if (nums[r] % 2 == 1) r--;
            else { int t = nums[l]; nums[l] = nums[r]; nums[r] = t; }
        }
        return nums;
    }
}