class Solution {
    public int numberOfSubstrings(String s) {
        int count=0;
        int i=0,j=0;
        int n=s.length();
        int[] map=new int[3];
        while(i<s.length())
        {
            char ch=s.charAt(i);
            map[ch-'a']++;
            if(map[0]>0 && map[1]>0 && map[2]>0)
            {
                while(j<n)
                {
                    count=count+n-i;
                    char rm=s.charAt(j++);
                    map[rm-'a']--;
                    if(map[0]<=0 || map[1]<=0 || map[2]<=0)
                    {
                        break;
                    }
                }
            } 
            i++;
        }
        return count;
    }
}