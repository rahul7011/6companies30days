class Solution {
    public int minimumCardPickup(int[] cards) {
        int min=(int)1e9;
        int i=0,j=0,n=cards.length;
        HashMap<Integer,Integer>hm=new HashMap<>();
        while(i<n)
        {
            int ele=cards[i++];
            hm.put(ele,hm.getOrDefault(ele,0)+1);
            if(hm.get(ele)>1)
            {
                while(j<i)
                {
                    min=Math.min(min,i-j);
                    int rm=cards[j++];
                    hm.put(rm,hm.get(rm)-1);
                    if(hm.get(rm)>0)
                    {
                        break;
                    }
                }
            }
        }
        return min==(int)1e9?-1:min;
    }
}