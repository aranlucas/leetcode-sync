class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longestConsecutive = 0;
        for (int num: set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int consecutive = 1;
                while (set.contains(currentNum + 1)){
                    consecutive++;
                    currentNum = currentNum + 1;
                }
                longestConsecutive = Math.max(longestConsecutive, consecutive);
            }
        }

        return longestConsecutive;
    }
}