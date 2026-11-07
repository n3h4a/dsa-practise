class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int old = image[sr][sc];
        if (old == color) return image;  // nothing to change (and avoids an infinite loop)
        int m = image.length, n = image[0].length;
        int[] dirs = {0, 1, 0, -1, 0};
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!q.isEmpty()) {
            int[] c = q.poll();
            for (int d = 0; d < 4; d++) {
                int r = c[0] + dirs[d], col = c[1] + dirs[d + 1];
                if (r < 0 || col < 0 || r >= m || col >= n || image[r][col] != old) continue;
                image[r][col] = color;
                q.add(new int[]{r, col});
            }
        }
        return image;
    }
}