class Solution {
    public static class Pair{
        String s;
        int frq;
        Pair(String s,int frq)
        {
            this.s=s;
            this.frq=frq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            if(a.frq==b.frq)
            {
                return a.s.compareTo(b.s);
            }
            return b.frq-a.frq;
        });
        HashMap<String,Integer>hm=new HashMap<>();
        for(String word:words)
        {
            hm.put(word,hm.getOrDefault(word,0)+1);
        }
        for(String key:hm.keySet())
        {
            pq.add(new Pair(key,hm.get(key)));
        }
        List<String>list=new ArrayList<>();
        while(k-- > 0)
        {
            list.add(pq.remove().s);
        }
        return list;
    }
}