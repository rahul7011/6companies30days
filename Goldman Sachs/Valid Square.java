class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p=new int[4][2];
        p[0]=p1;
        p[1]=p2;
        p[2]=p3;
        p[3]=p4;
        HashMap<Double,Integer>hm=new HashMap<>();
        for(int i=0;i<4;i++)
        {
            for(int j=i+1;j<4;j++)
            {
                int xx=p[j][0]-p[i][0];
                int yy=p[j][1]-p[i][1];
                double distance=Math.sqrt(xx*xx+yy*yy);
                if(distance==0) return false;
                hm.put(distance,hm.getOrDefault(distance,0)+1);
            }
        }
        return hm.size()==2;
    }
}