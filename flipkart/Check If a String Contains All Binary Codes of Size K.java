class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String>hs=new HashSet<>();
        StringBuilder ss=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            ss.append(ch);
            if(i>=k)
            {
                ss.deleteCharAt(0);
            }
            if(ss.length()==k)
                hs.add(ss.toString());
        }
        int num=(int)Math.pow(2,k);
        return hs.size()==num;
    }
}