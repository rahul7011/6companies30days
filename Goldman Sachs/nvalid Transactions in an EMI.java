class Solution {
    public class Pair{
        int idx;
        int time;
        String city;
        Pair(int idx,int time,String city)
        {
            this.idx=idx;
            this.time=time;
            this.city=city;
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<String>ans=new ArrayList<>();
        HashSet<Integer>hs=new HashSet<>();
        HashMap<String,List<Pair>>hm=new HashMap<>();
        for(int i=0;i<transactions.length;i++)
        {
            String x=transactions[i];
            String[] trans=x.split(",");
            if(Integer.parseInt(trans[2])>1000)
            {
                hs.add(i);
            }
            List<Pair>check=hm.getOrDefault(trans[0],new ArrayList<>());
            for(Pair p:check)
            {
                if(trans[3].equals(p.city)==false && Math.abs(p.time-Integer.parseInt(trans[1]))<=60)
                {
                    hs.add(p.idx);
                    hs.add(i);
                }
            }
            List<Pair>temp=hm.getOrDefault(trans[0],new ArrayList<>());
            temp.add(new Pair(i,Integer.parseInt(trans[1]),trans[3]));
            hm.put(trans[0],temp);
        }
        Iterator<Integer> it=hs.iterator();
        while(it.hasNext())
        {
            ans.add(transactions[it.next()]);
        }
        return ans;
    }
}