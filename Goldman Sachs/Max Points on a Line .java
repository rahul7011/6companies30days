class Solution {
    public int maxPoints(int[][] points) {
        if(points.length<=2)
        {
            return points.length;
        }
        int max=0;
        for(int[] p1:points)
        {
            HashMap<Double,Integer>hm=new HashMap<>();
            for(int[] p2:points)
            {
                if(p1==p2)
                {
                    continue;
                }
                double slope=0;
                int x1=p1[0];
                int y1=p1[1];
                int x2=p2[0];
                int y2=p2[1];
                if(x2==x1)
                {
                    slope=Double.POSITIVE_INFINITY;
                }else
                {
                    slope=(y2-y1)/(double)(x2-x1);
                }
                hm.put(slope,hm.getOrDefault(slope,0)+1);
                if(hm.get(slope)>max)
                {
                    max=hm.get(slope);
                }
            }
        }
        return max+1;
    }
}