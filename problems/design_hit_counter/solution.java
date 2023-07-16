class HitCounter {
    LinkedHashMap<Integer, Integer> map;
    final int fiveMin = 300;

    public HitCounter() {
        map =
                new LinkedHashMap<Integer, Integer>() {
                    @Override
                    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                        return map.size() > fiveMin;
                    }
                };
    }

    public void hit(int timestamp) {
        map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
    }

    public int getHits(int timestamp) {
        int start = timestamp - fiveMin;
        int sum = 0;
        for (int tsp : map.keySet()) {
            if (tsp > start) {
                sum += map.get(tsp);
            }
        }
        return sum;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
