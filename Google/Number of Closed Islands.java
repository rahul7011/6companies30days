class Solution {
    private static void solve(int[][] grid, int[][] dir, int x, int y) {
        grid[x][y] = 1;
        for (int d = 0; d < dir.length; d++) {
            int r = x + dir[d][0];
            int c = y + dir[d][1];
            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 0) {
                solve(grid, dir, r, c);
            }
        }
    }

    public int closedIsland(int[][] grid) {
        int count = 0;
        int[][] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    if (grid[i][j] == 0)
                        solve(grid, dir, i, j);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    solve(grid, dir, i, j);
                }
            }
        }
        return count;
    }
}