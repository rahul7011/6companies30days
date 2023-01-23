class Solution {
    private static int verifyArrangement(int[][] statements, int arrangement) {
        int count = 0;
        int n = statements.length;
        for (int i = 0; i < n; i++) {
            int mask = (1 << i);
            if ((arrangement & mask) == 0) {
                continue;
            }
            count++;
            for (int j = 0; j < n; j++) {
                if (statements[i][j] == 2)
                    continue;
                if ((((arrangement & (1 << j)) != 0) && statements[i][j] == 0)
                        || (((arrangement & (1 << j)) == 0) && statements[i][j] != 0))
                    return -1;
            }
        }
        return count;
    }

    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int binaryArrangements = (1 << n);
        int ans = 0;
        for (int arrangement = 0; arrangement < binaryArrangements; arrangement++) {
            int count = verifyArrangement(statements, arrangement);
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
// https://www.youtube.com/watch?v=UuNlaHRJWfU