class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int i = 0;

        while (i < nums.length) {
            // account for 1 -> n range
            int correctIdx = nums[i] - 1;

            // Current num is not in the correct Idx
            if (nums[i] != nums[correctIdx]) {
                // swap
                int tmp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = tmp;
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result.add(j + 1);
            }
        }

        return result;
    }
}
