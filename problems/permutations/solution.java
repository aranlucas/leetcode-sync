class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> current = new ArrayList();
        
        backtrack(0, nums, result, current);
        
        return result;
    }
    
    public void backtrack(int start, int[] nums, List<List<Integer>> result, List<Integer> current){
        if (current.size() == nums.length){
            result.add(new ArrayList<>(current));
        }
        
        for(int i = 0; i < nums.length; i++){
            if(current.contains(nums[i])) continue; // element already exists, skip
            current.add(nums[i]);
            backtrack(i+1, nums, result, current);
            current.remove(current.size()-1);
        }
    }
}