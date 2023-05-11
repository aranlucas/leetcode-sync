class Solution {
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

    for (int num : nums) {
      if (counts.containsKey(num)) {
        int prevCount = counts.get(num);

        counts.put(num, prevCount + 1);

      } else {
        counts.put(num, 1);
      }
    }

    Map.Entry<Integer, Integer> majorityEntry = null;
    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {

      if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
        majorityEntry = entry;
      }
    }

    return majorityEntry.getKey();
  }
}
