class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }        
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            // look for start of sequence
            if (set.contains(cur - 1)) {
                continue;
            } 
            int lcs = 1;
            while (set.contains(cur + 1)) {
                lcs++;
                cur = cur + 1;
            }

            result = Math.max(result, lcs);
        }

        return result;
    }
}