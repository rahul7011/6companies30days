class StockPrice {
    TreeMap<Integer,Integer>latest;
    TreeMap<Integer,Set<Integer>>records;
    public StockPrice() {
        this.latest=new TreeMap<>();
        this.records=new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if(latest.containsKey(timestamp)==true)
        {
            int oldPrice=latest.get(timestamp);
            Set<Integer>vals=records.get(oldPrice);
            vals.remove(timestamp);
            if(vals.size()==0)
            {
                records.remove(oldPrice);
            }
        }
        latest.put(timestamp,price);
        records.putIfAbsent(price,new HashSet<>());
        records.get(price).add(timestamp);
    }
    
    public int current() {
        return latest.lastEntry().getValue();
    }
    
    public int maximum() {
        return records.lastKey();
    }
    
    public int minimum() {
        return records.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */