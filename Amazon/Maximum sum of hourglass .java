class Solution {
    public int maxSum(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length-2;i++)
        {
            for(int j=0;j<grid[0].length-2;j++)
            {
                int curr=grid[i][j+0]+grid[i][j+1]+grid[i][j+2];//top row
                curr+=grid[i+2][j+0]+grid[i+2][j+1]+grid[i+2][j+2];//bottom row
                curr+=grid[i+1][j+1];
                max=Math.max(max,curr);
            }
        }
        return max;
    }
}