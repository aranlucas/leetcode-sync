class Solution {
  public int minStoneSum(int[] piles, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    int totalStones = 0;

    for (int i = 0; i < piles.length; i++) {
      totalStones += piles[i];
      pq.offer(piles[i]);
    }

    for (int i = 0; i < k; i++) {
      int maxPile = pq.poll();
      int newPile = (int) Math.floor(maxPile / 2);
      totalStones -= newPile;
      pq.offer(maxPile - newPile);
    }

    return totalStones;
  }
}
