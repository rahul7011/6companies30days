class Solution {
    public static int m=0;
    public static int n=0;
    private static boolean check(int[] xy)
    {
        int x=xy[0];
        int y=xy[1];
        if(x>=0 && x<m && y>=0 &&y<n)
        {
            return true;
        }
        return false;
    }
    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer>ts=new TreeSet<>((a,b)->{
            return b-a;
        });
        m = grid.length;
        n = grid[0].length;
        int MAX_SIZE = (Math.min(m, n) >> 1) + 1;//max size of diagonal possible

        // single cells
        for(int[] row : grid) 
            for(int el : row) {
                ts.add(el);
            }

        for(int len = 1; len < MAX_SIZE; len++) 
        {
            for(int row = 0; row < m; row++) 
            {
                for(int col = 0; col < n; col++) {                     
                    int[] left=new int[]{row,col-len};
                    int[] right=new int[]{row,col+len};
                    int[] up=new int[]{row-len,col};
                    int[] down=new int[]{row+len,col};
                    if(check(left) && check(right) && check(up) && check(down))
                    {
                        int sum=grid[left[0]][left[1]];
                        sum+=grid[right[0]][right[1]];
                        sum+=grid[up[0]][up[1]];
                        sum+=grid[down[0]][down[1]];
                        for(int i=1;i<len;i++)
                        {
                            //left up
                            sum+=grid[left[0]-i][left[1]+i];
                            //right up
                            sum+=grid[right[0]-i][right[1]-i];
                            //left down
                            sum+=grid[left[0]+i][left[1]+i];
                            //right down
                            sum+=grid[right[0]+i][right[1]-i];
                        }
                        ts.add(sum);
                    }
                }
            }
        }
        int[] ans=new int[Math.min(ts.size(),3)];
        int k=0;
        while(k<3 && ts.size()!=0)
        {
            ans[k++]=ts.pollFirst();
        }
        return ans;
    }
}