class Solution {
    public int maxCoins(int[] piles) {
        int ans=0;
        Arrays.sort(piles);
        for(int i=piles.length-2;i>=piles.length/3;i-=2)
        {
            ans+=piles[i];
        }
        return ans;
    }
}