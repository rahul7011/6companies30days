class Solution {
    static int mod = (int) 1e9 + 7;

    public int numberOfCombinations(String num) {
        char[] cs = num.toCharArray();
        int n = cs.length;
        int[][] rank = new int[n][n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(1, (a, b) -> a[1] - b[1]);
        for (int i = 1; i <= n; ++i) {
            int c = 0, prev = 0;
            for (int j = 0; j + i <= n; ++j)
                pq.add(new int[] { j, rank[j][i - 1] * 10 + cs[i + j - 1] - '0' });
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (cur[1] != prev)
                    c++;
                rank[cur[0]][i] = c;
                prev = cur[1];
            }
        }
        int[][] dp = new int[n][n + 1];
        for (int j = n - 1; 0 <= j; --j) {
            if ('0' == cs[j])
                continue;
            int len = n - j;
            dp[j][len] = 1;
            for (int i = len - 1; 1 <= i; --i) {
                dp[j][i] = dp[j][i + 1];
                int next = i + j;
                if (next >= n || next + i > n)
                    continue;
                if (rank[j][i] <= rank[next][i])
                    dp[j][i] = (dp[j][i] + dp[next][i]) % mod;
                else if (next + i < n)
                    dp[j][i] = (dp[j][i] + dp[next][i + 1]) % mod;
            }
            dp[j][0] = dp[j][1];
        }
        return dp[0][0];
    }
}