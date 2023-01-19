class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        // count occurrence
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : barcodes)
            map.put(x, map.getOrDefault(x, 0) + 1);
        // sort by occurrence - max heap
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int x : map.keySet()) {
            queue.add(new int[] { x, map.get(x) });
        }

        // poll from queue - put into res array
        int[] res = new int[barcodes.length];
        int i = 0;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            while (tmp[1]-- > 0) { // smart way of doing:instead of depending on indx,we are depending on freq
                res[i] = tmp[0];
                i += 2;
                if (i >= barcodes.length)
                    i = 1; // good way of resetting without harming the freq
            }
        }
        return res;
    }
}