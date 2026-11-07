class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1;
        for (int even = 0; even < nums.length; even += 2) {
            if (nums[even] % 2 == 0) continue;
            while (nums[odd] % 2 == 1) odd += 2;  // find an even number sitting at an odd index
            int t = nums[even]; nums[even] = nums[odd]; nums[odd] = t;
        }
        return nums;
    }
}