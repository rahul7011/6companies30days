class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] rightMax=new int[nums.length];
        LinkedList<Integer>st=new LinkedList<>();
        for(int i=0;i<nums.length;i++)
        {
            int x=nums[i];
            while(st.size()>0 && nums[st.peekLast()]<x)
            {
                rightMax[st.peekLast()]=i;
                st.removeLast();
            }
            st.addLast(i);
        }
        while(st.size()!=0)
        {
            rightMax[st.peekLast()]=-1;
            st.removeLast();
        }
        for(int i=0;i<nums.length;i++)
        {
            int x=nums[i];
            if(st.size()==2)
            {
                if(st.peekLast()<rightMax[st.peekLast()])
                {
                    return true;
                }
            }
            while(st.size()>0 && nums[st.peekLast()]>x)
            {
                st.removeLast();
            }
            if((st.size()==0)||(st.size()>0 && nums[st.peekLast()]<x))
            {
                st.addLast(i);
            }
        }
        return false;
    }
}