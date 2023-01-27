class TweetCounts {
    HashMap<String, List<Integer>> hm;

    public TweetCounts() {
        hm = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        List<Integer> set = hm.getOrDefault(tweetName, new ArrayList<>());
        set.add(time);
        hm.put(tweetName, set);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> list = hm.get(tweetName);
        Collections.sort(list);
        int left = startTime;
        int right = 0;
        int factor = 0;
        if (freq.equals("minute") == true) {
            right = Math.min(left + 59, endTime);
            factor = 59;
        } else if (freq.equals("hour") == true) {
            right = Math.min(left + 3599, endTime);
            factor = 3599;
        } else {
            right = Math.min(left + 86399, endTime);
            factor = 86399;
        }
        int lidx = Collections.binarySearch(list, left);
        if (lidx < 0) {
            lidx = Math.abs(lidx) - 1;
        }
        while (left + factor < endTime) {
            int ridx = Collections.binarySearch(list, right);
            int level = 1;
            if (ridx < 0) {
                ridx = Math.abs(ridx) - 1;
                level = 0;
            }
            level += ridx - lidx;
            ans.add(level);

            lidx = ridx;
            left = right + 1;
            right = left + factor;
        }
        int ridx = Collections.binarySearch(list, endTime);
        int level = 1;
        if (ridx < 0) {
            ridx = Math.abs(ridx) - 1;
            level = 0;
        }
        level += ridx - lidx;
        ans.add(level);
        return ans;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 =
 * obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */