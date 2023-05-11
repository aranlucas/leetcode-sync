class Solution {
  public int removeDuplicates(int[] nums) {
    int insertIdx = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[insertIdx] = nums[i];
        insertIdx += 1;
      }
    }

    return insertIdx;
  }
}
