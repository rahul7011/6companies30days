class Solution {
    public String predictPartyVictory(String senate) {
        int r=0,d=0;
        LinkedList<Integer>qr=new LinkedList<>();
        LinkedList<Integer>qd=new LinkedList<>();
        for(int i=0;i<senate.length();i++)
        {
            char ch=senate.charAt(i);
            if(ch=='R')
            {
               qr.addLast(i);
            }else
            {
               qd.addLast(i);
            }
        }
        int n=senate.length();
        while(qr.size()!=0 && qd.size()!=0)
        {
            int rIdx=qr.removeFirst(),dIdx=qd.removeFirst();
            if(rIdx<dIdx)
            {
                qr.addLast(rIdx+n);
            }else
            {
                qd.addLast(dIdx+n);
            }
        }
        return qr.size()>qd.size()?"Radiant":"Dire";
    }
}