class Solution {
    private static int solve(int[] nums1,int[] nums2)
    {
        int[][] dp=new int[nums1.length][nums2.length];
        int max=0;
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=(nums1[i]==nums2[j])?1:0;
                }else
                {
                    if(nums1[i]==nums2[j])
                    {
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                }
                max=Math.max(dp[i][j],max);
            }
        }
        return max;
    }
    public int findLength(int[] nums1, int[] nums2) {
        return solve(nums1,nums2);
    }
}