class Solution {
    public static boolean[] sieve;

    private static void sieveEra(int right) {
        for (int i = 2; i * i <= right; i++) {
            if (sieve[i] == true) {
                for (int j = i * i; j <= right; j += i) {
                    sieve[j] = false;
                }
            }
        }
    }

    public int[] closestPrimes(int left, int right) {
        sieve = new boolean[right + 6];
        Arrays.fill(sieve, true);// initially sab true hai
        sieveEra(right);
        sieve[0] = false;
        sieve[1] = false;
        int[] res = { -1, -1 };
        int p = -1; // initially my prime is -1
        int check = (int) 1e9;
        while (left <= right) {
            if (sieve[left] == true) {
                if (p == -1) {
                    p = left;
                } else {
                    int diff = left - p;
                    if (check > diff) {
                        check = diff;
                        res[0] = p;
                        res[1] = left;
                    }
                    p = left;
                }
            }
            left++;
        }
        return res;
    }
}