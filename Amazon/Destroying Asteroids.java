class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long maxx = mass;
        for (int x : asteroids) {
            if (maxx < x) {
                return false;
            }
            maxx += x;
        }
        return true;
    }
}