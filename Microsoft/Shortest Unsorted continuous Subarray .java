class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left=-1,right=-1;
        int max=(int)-1e9,min=(int)1e9;
        for(int i=0;i<nums.length;i++)
        {
            max=Math.max(max,nums[i]);
            if(nums[i]<max)
            {
                left=i;
            }
        }
        if(left==-1)
        {
            return 0;
        }
        for(int i=nums.length-1;i>=0;i--)
        {
            min=Math.min(min,nums[i]);
            if(nums[i]>min)
            {
                right=i;
            }
        }
        return left-right+1;
    }
}