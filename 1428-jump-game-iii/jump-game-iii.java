class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] seen = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        seen[start] = true;
        while (!q.isEmpty()) {
            int i = q.poll();
            if (arr[i] == 0) return true;
            for (int j : new int[]{i + arr[i], i - arr[i]}) {
                if (j >= 0 && j < n && !seen[j]) {
                    seen[j] = true;
                    q.add(j);
                }
            }
        }
        return false;
    }
}