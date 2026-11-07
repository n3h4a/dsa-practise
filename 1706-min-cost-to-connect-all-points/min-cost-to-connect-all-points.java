class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, total = 0;
        int[] best = new int[n];
        boolean[] inTree = new boolean[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        best[0] = 0;
        for (int it = 0; it < n; it++) {
            int u = -1;
            for (int i = 0; i < n; i++)
                if (!inTree[i] && (u == -1 || best[i] < best[u])) u = i;
            inTree[u] = true;
            total += best[u];
            for (int v = 0; v < n; v++) {
                if (inTree[v]) continue;
                int d = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                best[v] = Math.min(best[v], d);
            }
        }
        return total;
    }
}