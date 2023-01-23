class Solution {
    private static int solve(int[] fruits) {
        int i = 0, j = 0, count = 2;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        while (i < fruits.length) {
            int ele = fruits[i++];
            if (hm.containsKey(ele) == false) {
                count--;
            }
            hm.put(ele, hm.getOrDefault(ele, 0) + 1);
            if (count == -1) {
                while (count == -1) {
                    int rm = fruits[j++];
                    // System.out.println(rm+" "+hm);
                    hm.put(rm, hm.get(rm) - 1);
                    if (hm.get(rm) == 0) {
                        count++;
                        hm.remove(rm);
                    }
                }
                // System.out.println(hm);
            }
            max = Math.max(max, i - j);
        }
        return max;
    }

    public int totalFruit(int[] fruits) {
        return solve(fruits);
    }
}