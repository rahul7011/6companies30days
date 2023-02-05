class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum=0,currSum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            currSum+=nums[i]*i;
        }
        int max=currSum;
        for(int i=0;i<nums.length;i++)
        {
            currSum=currSum-sum+nums.length*nums[i];
            max=Math.max(max,currSum);
        }
        return max;
    }
}