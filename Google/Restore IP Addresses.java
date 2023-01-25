class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String>ans=new ArrayList<>();
        for(int a=1;a<=3;a++)
        {
            for(int b=1;b<=3;b++)
            {
                for(int c=1;c<=3;c++)
                {
                    for(int d=1;d<=3;d++)
                    {
                        if((a+b+c+d)==s.length())
                        {
                            int A=Integer.parseInt(s.substring(0,a));
                            int B=Integer.parseInt(s.substring(a,a+b));
                            int C=Integer.parseInt(s.substring(a+b,a+b+c));
                            int D=Integer.parseInt(s.substring(a+b+c,a+b+c+d));
                            if(A<=255 && B<=255 && C<=255 && D<=255)
                            {
                                String x=A+"."+B+"."+C+"."+D;
                                if(x.length()==s.length()+3)
                                {
                                    ans.add(x);
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}