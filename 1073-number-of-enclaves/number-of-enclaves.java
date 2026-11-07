class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        // start from land on the border; everything reachable from it can walk off
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && grid[i][j] == 1) {
                    grid[i][j] = 0;
                    q.add(new int[]{i, j});
                }
        int[] dirs = {0, 1, 0, -1, 0};
        while (!q.isEmpty()) {
            int[] c = q.poll();
            for (int d = 0; d < 4; d++) {
                int r = c[0] + dirs[d], col = c[1] + dirs[d + 1];
                if (r < 0 || col < 0 || r >= m || col >= n || grid[r][col] != 1) continue;
                grid[r][col] = 0;
                q.add(new int[]{r, col});
            }
        }
        int count = 0;
        for (int[] row : grid)
            for (int v : row) count += v;
        return count;
    }
}