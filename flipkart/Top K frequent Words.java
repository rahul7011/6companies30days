class Solution {
    public static class Pair {
        String s;
        int freq;

        Pair(String s, int freq) {
            this.s = s;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq) {
                return b.freq - a.freq;
            } else {
                return a.s.compareTo(b.s);
            }
        });
        HashMap<String, Integer> hm = new HashMap<>();
        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        for (String key : hm.keySet()) {
            pq.add(new Pair(key, hm.get(key)));
        }
        List<String> ans = new ArrayList<>();
        while (k-- > 0) {
            ans.add(pq.remove().s);
        }
        return ans;
    }
}