class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                perimeter += 4;
                if (i > 0 && grid[i - 1][j] == 1) perimeter -= 2;  // shared edge with the cell above
                if (j > 0 && grid[i][j - 1] == 1) perimeter -= 2;  // shared edge with the cell to the left
            }
        return perimeter;
    }
}