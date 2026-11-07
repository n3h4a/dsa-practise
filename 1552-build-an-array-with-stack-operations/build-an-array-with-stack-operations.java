class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ops = new ArrayList<>();
        int next = 1;
        for (int t : target) {
            while (next < t) {  // push and pop the numbers we don't want
                ops.add("Push");
                ops.add("Pop");
                next++;
            }
            ops.add("Push");
            next++;
        }
        return ops;
    }
}