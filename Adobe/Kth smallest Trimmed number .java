class Solution {
    private static class Pair{
        String num;
        int idx;
        Pair(String num,int idx)
        {
            this.num=num;
            this.idx=idx;
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        HashSet<Integer>hs=new HashSet<>();
        HashMap<Integer,List<Pair>>hm=new HashMap<>();
        for(int i=0;i<queries.length;i++)
        {
            hs.add(queries[i][1]);
        }
        Iterator<Integer> it=hs.iterator();
        int len=nums[0].length();
        while(it.hasNext())
        {
            int idx=it.next();
            int start=len-idx;
            List<Pair>list=hm.getOrDefault(idx,new ArrayList<>());
            for(int i=0;i<nums.length;i++)
            {
                String curr=nums[i].substring(start);
                list.add(new Pair(curr,i));
            }
            hm.put(idx,list);
        }
        for(int key:hm.keySet())
        {
            List<Pair>list=hm.get(key);
            Collections.sort(list,(a,b)->{
                return a.num.compareTo(b.num);
            });
        }
        int[] res=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int idx=queries[i][1];
            int k=queries[i][0];
            res[i]=(int)hm.get(idx).get(k-1).idx;
        }
        return res;

    }
}