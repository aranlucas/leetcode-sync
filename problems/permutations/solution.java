class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(nums, result, new LinkedHashSet<>());
        
        return result;
    }
    
    public void backtrack(int[] nums, List<List<Integer>> result, Set<Integer> current){
        if (current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if (current.contains(nums[i])) {
                continue; // element already exists, skip
            }
            current.add(nums[i]);
            backtrack(nums, result, current);
            current.remove(nums[i]);
        }
    }
}