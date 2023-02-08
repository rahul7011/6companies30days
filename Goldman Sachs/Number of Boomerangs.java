class Solution {
    private static double distance(int[][] p,int idx,int j){
        int xx=p[j][0]-p[idx][0];
        int yy=p[j][1]-p[idx][1];
        return Math.sqrt(xx*xx+yy*yy);
    }
    public int numberOfBoomerangs(int[][] p) {
        int res=0;
        HashMap<Double,Integer>hm=new HashMap<>();
        for(int i=0;i<p.length;i++)
        {
            for(int j=0;j<p.length;j++)
            {
                double cdist=distance(p,i,j);
                hm.put(cdist,hm.getOrDefault(cdist,0)+1);
            }
            //np2
            for(double key:hm.keySet())
            {
                int val=hm.get(key);
                res+=(val*(val-1));
            }
            hm.clear();
        }
        return res;
    }
}