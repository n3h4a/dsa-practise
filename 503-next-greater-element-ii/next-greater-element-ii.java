class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();  // indices waiting for a greater element
        for (int i = 0; i < 2 * n; i++) {  // loop twice to handle wrap-around
            int x = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < x) res[stack.pop()] = x;
            if (i < n) stack.push(i);
        }
        return res;
    }
}