class Solution {
    public static char[] gene;
    public static HashSet<String>check;
    private static int solve(StringBuilder sg,StringBuilder eg,HashSet<String>hs)
    {
        if(sg.compareTo(eg)==0)
        {
            return 0;
        }
        int min=(int)1e9;
        for(int i=0;i<sg.length();i++)
        {
            for(int j=0;j<gene.length;j++)
            {
                char store=sg.charAt(i);
                if(store==gene[j]) continue;
                sg.setCharAt(i,gene[j]);
                if(hs.contains(sg.toString())==true && check.contains(sg.toString())==false)
                {
                    check.add(sg.toString());
                    min=Math.min(min,solve(sg,eg,hs)+1);
                    check.remove(sg.toString());
                }
                sg.setCharAt(i,store);
            }
        }
        return min;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        gene=new char[]{'A','C','G','T'};
        check=new HashSet<>();
        check.add(startGene);
        HashSet<String>hs=new HashSet<>();
        for(String x:bank)
        {
            hs.add(x);
        }
        int store=solve(new StringBuilder(startGene),new StringBuilder(endGene),hs);
        return store==(int)1e9?-1:store;
    }
}