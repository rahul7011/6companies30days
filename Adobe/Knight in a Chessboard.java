class Solution {
    int dx[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
    private double knightProb(int n,int k,int r,int c)
    {
        if(k==0)
        {
            return 1.0;
        }
        double count=0.0;
        for(int d=0;d<8;d++)
        {
            int x=r+dx[d];
            int y=c+dy[d];
            if(x>=0&&y>=0&&x<n&&y<n)
            {
                count+=knightProb(n,k-1,x,y);
            }
        }
        return count/8.0;
    }
    private double knightProb_memo(int n,int k,int r,int c,double[][][] dp)
    {
        if(k==0)
        {
            return dp[k][r][c]=1.0;
        }
        if(dp[k][r][c]!=0.0)
        {
            return dp[k][r][c];
        }
        double count=0.0;
        for(int d=0;d<8;d++)
        {
            int x=r+dx[d];
            int y=c+dy[d];
            if(x>=0&&y>=0&&x<n&&y<n)
            {
                count+=knightProb_memo(n,k-1,x,y,dp);
            }
        }
        return dp[k][r][c]=count/8.0;
    }
    public double knightProbability(int n, int k, int row, int column) {
        // return knightProb(n,k,row,column);
        double[][][] dp=new double[k+1][n+1][n+1];
        return knightProb_memo(n,k,row,column,dp);
    }
}