class Solution {
    private static int[] lps(String word)
    {
        int[] lp=new int[word.length()];
        
        int index = 0;
        for(int i = 1; i < word.length();)
        {
            if(word.charAt(i) == word.charAt(index))
            {
                index++;
                lp[i] = index;
                i++;
            }
            else
            {
                if(index != 0)
                    index = lp[index-1];
                else
                    i++;
            }
        }
        
        return lp;
    }

    public String longestPrefix(String s) {
        int[] lp=lps(s);
        return s.substring(0,lp[lp.length-1]);
    }
}