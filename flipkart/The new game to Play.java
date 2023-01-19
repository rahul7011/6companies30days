class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) {
            return 1.0;
        }
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double runningSum = dp[0];
        double res = 0.0;
        for (int i = 1; i <= n; i++) {
            dp[i] += runningSum / (double) maxPts;
            // sliding window below
            if (i < k) {
                // edge cases
                runningSum += dp[i];
            } else {
                res += dp[i];
            }
            if (i - maxPts >= 0) {
                runningSum -= dp[i - maxPts];
            }
        }
        return res;
    }
}