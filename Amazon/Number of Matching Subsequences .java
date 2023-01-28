class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<StringBuilder>[]waiting=new ArrayList[128];
        for(char c='a';c<='z';c++)
        {
            waiting[c]=new ArrayList<>();
        }
        for(String word:words)
        {
            waiting[word.charAt(word.length()-1)].add(new StringBuilder(word));
        }
        int count=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            char ch=s.charAt(i);
            List<StringBuilder>advance=waiting[ch];
            waiting[ch]=new ArrayList<>();
            for(StringBuilder nextString:advance)
            {
                nextString.deleteCharAt(nextString.length()-1);
                if(nextString.length()!=0)
                {
                    waiting[nextString.charAt(nextString.length()-1)].add(new StringBuilder(nextString));
                }else
                {
                    count++;
                }
            }
        }
        return count;
    }
}