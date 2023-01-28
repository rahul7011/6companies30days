class Solution {
    public static class Pair{
        long tView;
        String id;
        int cView;
        Pair(long tView,String id,int cView)
        {
            this.tView=tView;
            this.id=id;
            this.cView=cView;
        }
    }
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String,Pair>hm=new HashMap<>();
        for(int i=0;i<views.length;i++)
        {
            String cr=creators[i];
            String id=ids[i];
            int view=views[i];
            if(hm.containsKey(cr)==true)
            {
                Pair p=hm.get(cr);
                p.tView+=view;
                if(p.cView<view)
                {
                    p.id=id;
                    p.cView=view;
                }else if(p.cView==view)
                {
                    if(p.id.compareTo(id)>0)
                    {
                        p.id=id;
                    }
                }
            }else
            {
                hm.put(cr,new Pair(view,id,view));
            }
        }
        long maxView=0;
        List<List<String>>list=new ArrayList<>();
        for(String key:hm.keySet())
        {
            String cr=key;
            Pair p=hm.get(key);
            long view=p.tView;
            String id=p.id;
            if(maxView<=view)
            {
                if(maxView!=view)
                    list.clear();
                maxView=view;
                List<String>temp=new ArrayList<>();
                temp.add(cr);
                temp.add(id);
                list.add(temp);
            }
        }
        return list;
    }
}