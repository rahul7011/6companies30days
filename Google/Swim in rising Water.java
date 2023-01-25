class Solution {
    public static int[][] dir={{0,-1},{0,1},{-1,0},{1,0}};
    private static int solve(int[][] grid)
    {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        pq.add(new int[]{grid[0][0],0,0});
        int max=-(int)1e9;
        while(pq.size()!=0)
        {
            int[] rm=pq.remove();
            if(grid[rm[1]][rm[2]]==-1)
            {
                continue;
            }
            if(rm[1]==grid.length-1 && rm[2]==grid[0].length-1)
            {
                return Math.max(rm[0],max);
            }
            max=Math.max(max,rm[0]);
            grid[rm[1]][rm[2]]=-1;
            for(int d=0;d<dir.length;d++)
            {
                int r=rm[1]+dir[d][0];
                int c=rm[2]+dir[d][1];
                if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]!=-1)
                {
                    pq.add(new int[]{grid[r][c],r,c});
                }
            }
        }
        return -1;
    }
    public int swimInWater(int[][] grid) {
        return solve(grid);
    }
}