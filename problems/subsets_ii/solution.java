class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> current = new ArrayList();
        Arrays.sort(nums);

        backtrack(0, nums, result, current);
        return result;
    }
    
    public void backtrack(int start, int[] nums, List<List<Integer>> result, List<Integer> current){
        // If found solution, return answer
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            // Check if valid candidate
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            current.add(nums[i]);
            backtrack(i + 1, nums, result, current);
            current.remove(current.size()-1);
        }
    }
}