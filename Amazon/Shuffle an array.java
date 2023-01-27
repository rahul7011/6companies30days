class Solution {
    int[] copy;
    int[] original;
    Random random;

    public Solution(int[] nums) {
        random = new Random();
        copy = new int[nums.length];
        original = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
            original[i] = nums[i];
        }
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        int idx1 = random.nextInt(copy.length);
        int idx2 = random.nextInt(copy.length);
        int temp = copy[idx1];
        copy[idx1] = copy[idx2];
        copy[idx2] = temp;
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */