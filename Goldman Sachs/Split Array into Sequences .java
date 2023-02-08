class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer>available=new HashMap<>();
        HashMap<Integer,Integer>want=new HashMap<>();
        int max=0;
        for(int x:nums)
        {
            available.put(x,available.getOrDefault(x,0)+1);
        }
        for(int x:nums)
        {
            if(available.get(x)<=0)
            {
                continue;
            }else if(want.getOrDefault(x,0)>0)
            {
                available.put(x,available.get(x)-1);
                want.put(x,want.get(x)-1);
                want.put(x+1,want.getOrDefault(x+1,0)+1);
            }else if(available.getOrDefault(x,0)>0 && available.getOrDefault(x+1,0)>0 && available.getOrDefault(x+2,0)>0)
            {
                available.put(x,available.get(x)-1);
                available.put(x+1,available.get(x+1)-1);
                available.put(x+2,available.get(x+2)-1);
                want.put(x+3,want.getOrDefault(x+3,0)+1);
            }else
            {
                return false;
            }
        }
        return true;
    }
}