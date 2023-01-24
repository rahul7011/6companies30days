class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<ArrayList<Integer>>hs=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            ArrayList<Integer> s=new ArrayList<>();
            int j=i,t=k;
            while(j<nums.length)
            {
                int ele=nums[j++];
                if(ele%p==0)
                    t--;
                if(t<0)
                {
                    break;
                }
                s.add(ele);
                hs.add(new ArrayList<>(s));
            }
        }
        // System.out.println(hs);
        return hs.size();
    }
}