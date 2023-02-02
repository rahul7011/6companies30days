class Solution {
    private static void solve(int idx,int k,int n,int cSum,List<Integer>smallAns,List<List<Integer>>ans)
    {
        if(idx>9||k==0||cSum>=n)
        {
            if(cSum==n && k==0)
            {
                ans.add(new ArrayList<>(smallAns));
            }
            return;
        }
        smallAns.add(idx);
        solve(idx+1,k-1,n,cSum+idx,smallAns,ans);
        smallAns.remove(smallAns.size()-1);
        solve(idx+1,k,n,cSum,smallAns,ans);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>smallAns=new ArrayList<>();
        solve(1,k,n,0,smallAns,ans);
        return ans;
    }
}