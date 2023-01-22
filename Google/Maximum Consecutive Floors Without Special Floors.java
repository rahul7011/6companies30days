class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        bottom--;
        int max = 0;
        for (int i = 0; i < special.length; i++) {
            int ele = special[i];
            int diff = ele - bottom - 1;
            max = Math.max(max, diff);
            bottom = ele;
        }
        top++;
        max = Math.max(max, top - bottom - 1);
        return max;
    }
}