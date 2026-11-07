class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        int[] dirs = {0, 1, 0, -1, 0};
        int minutes = 0;
        while (!q.isEmpty() && fresh > 0) {  // multi-source BFS, one level per minute
            minutes++;
            for (int sz = q.size(); sz > 0; sz--) {
                int[] c = q.poll();
                for (int d = 0; d < 4; d++) {
                    int r = c[0] + dirs[d], col = c[1] + dirs[d + 1];
                    if (r < 0 || col < 0 || r >= m || col >= n || grid[r][col] != 1) continue;
                    grid[r][col] = 2;
                    fresh--;
                    q.add(new int[]{r, col});
                }
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}