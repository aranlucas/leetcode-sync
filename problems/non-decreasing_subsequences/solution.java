class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> sequence = new ArrayList<>();

        backtrack(0, nums, sequence, result);

        return new ArrayList<>(result);
    }

    private void backtrack(int i, int[] nums, List<Integer> sequence, Set<List<Integer>> result) {
        if (i == nums.length) {
            if (sequence.size() >= 2) {
                result.add(new ArrayList<>(sequence));
            }
            return;
        }

        // 2 choices - append or not append current number

        // Append if increasing
        if (sequence.isEmpty() || sequence.get(sequence.size() - 1) <= nums[i]) {
               sequence.add(nums[i]);
               backtrack(i + 1, nums, sequence, result);
               sequence.remove(sequence.size() - 1);
        }
 
        // Don't append
        backtrack(i + 1, nums, sequence, result);
    }
}