class Solution {
  public int thirdMax(int[] nums) {
    TreeSet<Integer> set = new TreeSet<Integer>();

    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        continue;
      }

      if (set.size() == 3) {
        if (set.first() < nums[i]) {
          // Remove first
          set.pollFirst();
          set.add(nums[i]);
        }
      } else {
        set.add(nums[i]);
      }
    }

    // If sorted set has three elements return the smallest among those 3.
    if (set.size() == 3) {
      return set.first();
    }
    return set.last();
  }
}
