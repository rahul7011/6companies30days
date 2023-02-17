class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp=new long[n+1];
        long noOfPeopleSharingSecret=0;
        dp[1]=1;    //only day 1 person knows secret initially
        long mod=(long)1e9+7;
        for(int i=2;i<=n;i++)
        {
            long noOfNewPeopleSharingSecret=dp[Math.max(i-delay,0)];
            long noOfNewPeopleForgetingSecret=dp[Math.max(i-forget,0)];
            noOfPeopleSharingSecret=(noOfPeopleSharingSecret+noOfNewPeopleSharingSecret-noOfNewPeopleForgetingSecret+mod)%mod;
            dp[i]=noOfPeopleSharingSecret;
        }
        long res=0;
        for(int i=n-forget+1;i<=n;i++)
        {
            res=(res+dp[i])%mod;
        }
        return (int)res;
    }
}