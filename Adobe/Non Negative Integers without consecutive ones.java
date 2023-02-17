class Solution {
 public int findIntegers(int num) {

        // f(k) = f(k-1) + f(k-2), where k>=2, f(0) = 1, f(1) =2;
        // f(k) means the count    without Consecutive Ones, from 0, to 2^k -1;
        // k is the length of binary string , k = len(bin(2^k -1)) for example : f(5) = count( 00000 - 11111),
        // count( 00000 - 11111) = count(00000 - 01111) + count(10000 - 10111) + count(11000 - 11111)
        //                       = count(00000 - 01111) + count(10000 - 10111)
        //                       = f(4) + f(3)
        int[] fn = new int[32];
        fn[0] = 1;
        fn[1] = 2;
        for (int i = 2; i < fn.length; i++) {
            fn[i] = fn[i-1] + fn[i-2];
        }

        char[] binChr = Integer.toBinaryString(num).toCharArray();
        int len = binChr.length -1;
        int ans = 0;
        boolean preBit = false;
        for (int i = 0; i < binChr.length; i++) {
            if(binChr[i] == '1')
            {
                ans += fn[len - i];
                if(preBit)return ans;
                preBit = true;
            }
            else {
                preBit = false;
            }
        }

        // including it's self.
        return ans +1;
    }
}