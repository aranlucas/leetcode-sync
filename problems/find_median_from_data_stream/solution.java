class MedianFinder {

  PriorityQueue<Integer> lo;
  PriorityQueue<Integer> hi;

  public MedianFinder() {
    lo = new PriorityQueue();
    hi = new PriorityQueue(Collections.reverseOrder());
  }

  public void addNum(int num) {
    lo.offer(num);
    hi.offer(lo.poll());

    if (lo.size() < hi.size()) {
      lo.offer(hi.poll());
    }
  }

  public double findMedian() {
    if (lo.size() > hi.size()) {
      return lo.peek();
    }

    return (lo.peek() + hi.peek()) * 0.5;
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such: MedianFinder obj = new
 * MedianFinder(); obj.addNum(num); double param_2 = obj.findMedian();
 */
