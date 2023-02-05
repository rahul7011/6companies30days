class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        int idx=-1;
        int[] dp=new int[nums.length];
        int[] prev=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            dp[i]=1;
            prev[i]=-1;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i])
                {
                    dp[i]=dp[j]+1;
                    prev[i]=j;
                }
            }
            if(max<dp[i])
            {
                max=dp[i];
                idx=i;
            }
        }
        List<Integer>list=new ArrayList<>();
        while(idx!=-1)
        {
            list.add(nums[idx]);
            idx=prev[idx];
        }
        return list;
    }
}