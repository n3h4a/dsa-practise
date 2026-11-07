class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(), common = new HashSet<>();
        for (int x : nums1) set1.add(x);
        for (int x : nums2) if (set1.contains(x)) common.add(x);
        int[] res = new int[common.size()];
        int i = 0;
        for (int x : common) res[i++] = x;
        return res;
    }
}