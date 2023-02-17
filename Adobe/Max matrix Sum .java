class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int[][] dir={{0,-1},{0,1},{-1,0},{1,0}};
        int max=(int)-1e9;
        long sum=0;
        int count=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                max=Math.max(max,-1*Math.abs(matrix[i][j]));
                if(matrix[i][j]<=0)
                {
                    count++;
                }
                sum+=Math.abs(matrix[i][j]);
            }
        }
        // System.out.println(sum+" "+max+" "+count);
        return count%2==0?sum:sum+2*max;
    }
}