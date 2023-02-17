class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int r=dungeon.length;
        int c=dungeon[0].length;
        int[][] dp=new int[r][c];
        
        for(int i=r-1;i>=0;--i)
        {
            for(int j=c-1;j>=0;--j)
            {
                if(i==r-1 && j==c-1)    //Bottom-Right cell (Princess Cell)
                    dp[i][j] = Math.min(0,dungeon[i][j]);
                else if(i==r-1)   //last row
                    dp[i][j] = Math.min(0,dungeon[i][j]+dp[i][j+1]);
                else if(j==c-1)   //last col       
                    dp[i][j] = Math.min(0,dungeon[i][j]+dp[i+1][j]);
                else
                    dp[i][j] = Math.min(0,dungeon[i][j]+Math.max(dp[i][j+1],dp[i+1][j]));
            }
        } 
        return Math.abs(dp[0][0])+1;
    }
}