class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m=mat.length;
        int n=mat[0].length;
        int[][]LR=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<=K;k++)
                {
                    if(j+k<n)
                    {
                        LR[i][j]+=mat[i][j+k];
                    }                    
                    if(j-k>=0 && k!=0)
                    {
                        LR[i][j]+=mat[i][j-k];
                    }
                }
            }
        }
        int[][]res=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<=K;k++)
                {
                    if(i-k>=0)
                    {
                        res[i][j]+=LR[i-k][j];
                    }
                    if(i+k<m && k!=0)
                    {
                        res[i][j]+=LR[i+k][j];
                    }
                }
            }
        }
        return res;
    }
}