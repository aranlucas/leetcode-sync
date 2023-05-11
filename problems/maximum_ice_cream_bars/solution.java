class Solution {
  public int maxIceCream(int[] costs, int coins) {
    Arrays.sort(costs);

    int bars = 0;

    for (int i = 0; i < costs.length; i++) {
      if (coins - costs[i] < 0) {
        break;
      }
      bars++;
      coins -= costs[i];
    }

    return bars;
  }
}
