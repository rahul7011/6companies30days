class Solution {
    public String getHint(String secret, String guess) {
        int bulls=0,cows=0;
        int[] map=new int[10];
        for(int i=0;i<secret.length();i++)
        {
            char sc=secret.charAt(i);
            char gc=guess.charAt(i);
            if(sc==gc)
            {
                bulls++;
            }else{
                cows+=map[sc-'0']<0?1:0;
                cows+=map[gc-'0']>0?1:0;
                map[sc-'0']++;
                map[gc-'0']--;
            }
        }
        return new StringBuilder().append(bulls).append("A").append(cows+"").append("B").toString();
        
    }
}