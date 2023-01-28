class Solution {
    public static int mod=(int)1e9+7;
    private static long solve(int curr,int end,int k,long[][] dp)
    {
        if(Math.abs(end-curr)>k)
        {
            return dp[Math.abs(end-curr)][k]=0L;
        }
        if(dp[Math.abs(end-curr)][k]!=-1)
        {
            return dp[Math.abs(end-curr)][k];
        }
        if(k==0)
        {
            if(curr==end)
            {
                return 1L;
            }
            return 0L;
        }
        long c1=solve(curr+1,end,k-1,dp)%mod;
        long c2=solve(curr-1,end,k-1,dp)%mod;
        return dp[Math.abs(end-curr)][k]=(c1+c2)%mod;
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        long[][] dp=new long[1000*2+2][k+1];
        for(long[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return (int)(solve(startPos,endPos,k,dp)%mod);
    }
}