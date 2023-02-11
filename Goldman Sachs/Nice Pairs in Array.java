class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        long ans=0;
        long mod=(long)1e9+7;
        for(int x:nums)
        {
            StringBuilder sb=new StringBuilder(x+"");
            int y=Integer.parseInt(sb.reverse().toString());
            int diff=(x-y);
            ans=(ans+hm.getOrDefault(diff,0))%mod;
            hm.put(diff,hm.getOrDefault(diff,0)+1);
        }
        return (int)ans;
    }
}