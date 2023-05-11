class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList();

        List<Integer> current = new ArrayList();
        backtrack(0, nums, result, current);
        return result;
    }

    public void backtrack(int i, int[] nums, List<List<Integer>> ans, List<Integer> current) {
        if (i >= nums.length) {
            ans.add(new ArrayList<>(current));
        } else {
            current.add(nums[i]);
            backtrack(i + 1, nums, ans, current);
            current.remove(current.size() - 1);
            backtrack(i + 1, nums, ans, current);
        }
    }
}
