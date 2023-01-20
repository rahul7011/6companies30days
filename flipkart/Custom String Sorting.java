class Solution {
    public String customSortString(String order, String s) {
        int[] map=new int[26];
        for(char x:s.toCharArray())
        {
            map[x-'a']++;
        }
        StringBuilder result=new StringBuilder();
        for(char x:order.toCharArray())
        {
            for(int j=0;j<map[x-'a'];j++)
            {
                result.append((char)(x));
            }
            map[x-'a']=0;
        }
        for(int i=0;i<26;i++)
        {
            for(int j=0;j<map[i];j++)
            {
                result.append((char)(i+'a'));
            }
        }
        return result.toString();
    }
}