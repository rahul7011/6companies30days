class Solution {
    private static int josephusProblem(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return ((josephusProblem(n - 1, k) + k) % n);
    }

    public int findTheWinner(int n, int k) {
        return josephusProblem(n, k) + 1;
    }
}