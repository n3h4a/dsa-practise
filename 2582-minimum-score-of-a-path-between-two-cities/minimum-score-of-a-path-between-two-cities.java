class Solution {
    private int[] parent;

    public int minScore(int n, int[][] roads) {
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;
        for (int[] r : roads) parent[find(r[0])] = find(r[1]);
        // the path may reuse roads, so the answer is the smallest road in city 1's component
        int best = Integer.MAX_VALUE;
        for (int[] r : roads)
            if (find(r[0]) == find(1)) best = Math.min(best, r[2]);
        return best;
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}