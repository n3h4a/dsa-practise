class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] seen = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{grid[0][0], 0, 0});
        seen[0][0] = true;
        int[] dirs = {0, 1, 0, -1, 0};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], r = cur[1], c = cur[2];
            if (r == n - 1 && c == n - 1) return t;
            for (int d = 0; d < 4; d++) {
                int nr = r + dirs[d], nc = c + dirs[d + 1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n || seen[nr][nc]) continue;
                seen[nr][nc] = true;
                pq.add(new int[]{Math.max(t, grid[nr][nc]), nr, nc});
            }
        }
        return -1;
    }
}