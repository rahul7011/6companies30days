class Solution {
    private static int solve(String s,int i,int j,HashSet<String>hs)
    {
        if(i==s.length() || j==s.length()+1)
        {
            if(i==s.length())
            {
                return hs.size();
            }
            return 0;
        }
        String s1=s.substring(i,j);
        int c1=0,c2=0;
        if(hs.contains(s1)==false)
        {
            hs.add(s1);
            c1=solve(s,j,j+1,hs);
            hs.remove(s1);
        }
        c2=solve(s,i,j+1,hs);
        return Math.max(c1,c2);
    }
    public int maxUniqueSplit(String s) {
        HashSet<String>hs=new HashSet<>();
        return solve(s,0,1,hs);
    }
}