class Solution {
    static int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    private static int solve(int[][] grid,int x,int y)
    {
        int count=0;
        grid[x][y]=0;
        for(int d=0;d<dir.length;d++)
        {
            int r=x+dir[d][0];
            int c=y+dir[d][1];
            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]==1)
            {
                count+=solve(grid,r,c);
            }
        }
        return count+1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                    max=Math.max(max,solve(grid,i,j));
            }
        }
        return max;
    }
}