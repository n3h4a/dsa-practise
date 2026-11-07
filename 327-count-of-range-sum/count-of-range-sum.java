class Solution {
    private int lower, upper;
    private long[] tmp;

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        long[] pre = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) pre[i + 1] = pre[i] + nums[i];
        tmp = new long[pre.length];
        return sortCount(pre, 0, pre.length);
    }

    private int sortCount(long[] s, int lo, int hi) {
        if (hi - lo <= 1) return 0;
        int mid = (lo + hi) / 2;
        int cnt = sortCount(s, lo, mid) + sortCount(s, mid, hi);
        int a = mid, b = mid;
        for (int i = lo; i < mid; i++) {
            while (a < hi && s[a] - s[i] < lower) a++;
            while (b < hi && s[b] - s[i] <= upper) b++;
            cnt += b - a;
        }
        int i = lo, j = mid, k = lo;
        while (i < mid && j < hi) tmp[k++] = s[i] <= s[j] ? s[i++] : s[j++];
        while (i < mid) tmp[k++] = s[i++];
        while (j < hi) tmp[k++] = s[j++];
        System.arraycopy(tmp, lo, s, lo, hi - lo);
        return cnt;
    }
}