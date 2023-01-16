class Solution {
    private static int solve(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int idx,
            int total) {
        if (total == 0) {
            return 0;
        }
        if (idx == special.size()) {
            int cost = 0;
            for (int j = 0; j < price.size(); j++) {
                cost += (needs.get(j) * price.get(j));
            }
            return cost;
        }
        int c1 = (int) 1e9, c2 = (int) 1e9;
        List<Integer> needsCpy = new ArrayList<>();
        int totalCpy = total;
        boolean flag = true;
        for (int j = 0; j < price.size(); j++) {
            totalCpy -= special.get(idx).get(j);
            needsCpy.add(needs.get(j) - special.get(idx).get(j));
            if (needsCpy.get(j) < 0) {
                flag = false;
                break;
            }
        }
        if (flag == true)
            c1 = solve(price, special, needsCpy, idx, totalCpy) + special.get(idx).get(price.size());
        c2 = solve(price, special, needs, idx + 1, total);
        return Math.min(c1, c2);
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int total = 0;
        for (int x : needs)
            total += x;
        return solve(price, special, needs, 0, total);
    }
}