class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Use set to count duplicates
        Set<Integer> counts = new HashSet();
        
        for (int num : nums) {
            if (counts.contains(num)) {
                return true;
            }
            counts.add(num);
        }
        return false;
    }
}