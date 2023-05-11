class SmallestInfiniteSet {
    Set<Integer> set;
    PriorityQueue<Integer> pq;
    Integer currentInteger;

    public SmallestInfiniteSet() {
        set = new HashSet<>();
        pq = new PriorityQueue<>();
        currentInteger = 1;
    }

    public int popSmallest() {
        if (!pq.isEmpty()) {
            int smallest = pq.poll();
            set.remove(smallest);
            return smallest;
        }

        return currentInteger++;
    }

    public void addBack(int num) {
        if (currentInteger <= num || set.contains(num)) {
            return;
        }
        set.add(num);
        pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
