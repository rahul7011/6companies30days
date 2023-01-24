class Solution {
    Random random;
    int[] prefixSum;
    public Solution(int[] W) {
        this.random=new Random();
        for(int i=1;i<W.length;i++)
            W[i]=W[i]+W[i-1];
        this.prefixSum=W;
    }
    
    public int pickIndex() {
        int num=random.nextInt(prefixSum[prefixSum.length-1])+1;//range from 1 to last prefixSum
        int left=0;
        int right=prefixSum.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(prefixSum[mid]==num)
            {
                return mid;
            }else if(prefixSum[mid]>num)
            {
                right=mid-1;
            }else
            {
                left=mid+1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */