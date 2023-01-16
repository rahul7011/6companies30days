class Solution {
    private static boolean solve(int cSum, int sSum, int k, int idx, int[] nums, boolean[] visited) {
        if (k == 0) {
            return true;
        }
        if (cSum > sSum)
            return false;
        if (cSum == sSum) {
            return solve(0, sSum, k - 1, 0, nums, visited);
        }
        if (idx == nums.length) {
            return false;
        }
        boolean c1 = false;
        for (int i = idx; i < nums.length; i++) {
            if (cSum + nums[i] <= sSum && visited[i] == false) {
                visited[i] = true;
                c1 = c1 || solve(cSum + nums[i], sSum, k, i + 1, nums, visited);
                visited[i] = false;
            }
        }

        return c1;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum % k != 0)
            return false;
        boolean[] visited = new boolean[nums.length];
        return solve(0, sum / k, k, 0, nums, visited);
    }
}