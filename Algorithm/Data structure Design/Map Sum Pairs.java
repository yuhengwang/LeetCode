class MapSum {
    HashMap<String, Integer> map = null;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        int v = 0;
        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                v += map.get(key);
            }  
        }
        return v;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
