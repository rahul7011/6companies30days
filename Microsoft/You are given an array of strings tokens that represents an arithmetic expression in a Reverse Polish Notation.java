class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer>st=new LinkedList<>();
        int n=tokens.length;
        int idx=0;
        while(idx<n)
        {
            String s=tokens[idx];
            idx++;
            if(s.length()==1 && (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")))
            {
                int b=st.removeLast();
                int a=st.removeLast();
                if(s.equals("+")==true)
                {
                    st.addLast(a+b);
                }else if(s.equals("-"))
                {
                    st.addLast(a-b);
                }else if(s.equals("*"))
                {
                    st.addLast(a*b);
                }else
                {
                    st.addLast(a/b);
                }
                continue;
            }
            st.addLast(Integer.parseInt(s));
        }
        return st.removeLast();
    }
}