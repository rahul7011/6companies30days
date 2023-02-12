class Solution {
    public int magicalString(int n) {
        StringBuilder magicString=new StringBuilder("122");
        int idx=2;
        while(magicString.length()<n)
        {
            int repeat=magicString.charAt(idx)-'0';
            char nextChar=(((magicString.charAt(magicString.length()-1)-'0')^3)+"").charAt(0);//basically toggling btw 1 and 2
            while(repeat-- > 0)
            {
                magicString.append(nextChar);
            }
            idx++;
        }   
        int count=0;
        for(int i=0;i<n;i++)
        {
            char x=magicString.charAt(i);
            if(x=='1')
                count++;
        }   
        return count;
    }
}