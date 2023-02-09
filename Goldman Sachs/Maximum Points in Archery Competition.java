class Solution {
    private int max=0;
    private List<Integer>list;
    private void solve(int idx,int arrows,int[] check,int csum,List<Integer>smallAns)
    {
        if(idx==12 || arrows==0)
        {
            if(max<csum)
            {
                max=csum;
                list=new ArrayList<>(smallAns);
            }
            return;
        }
        if(arrows-(check[idx]+1)>=0)
        {
            smallAns.add(idx);
            solve(idx+1,arrows-(check[idx]+1),check,csum+idx,smallAns);
            smallAns.remove(smallAns.size()-1);
            solve(idx+1,arrows,check,csum,smallAns);
        }else
        solve(idx+1,arrows,check,csum,smallAns);
    }
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        list=new ArrayList<>();
        max=0;
        solve(0,numArrows,aliceArrows,0,new ArrayList<>());
        int[] res=new int[12];
        for(int x:list)
        {
            numArrows-=(aliceArrows[x]+1);
            res[x]=aliceArrows[x]+1;
        }
        res[11]+=numArrows;
        return res;
    }
}