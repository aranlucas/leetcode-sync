class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 ) {
            return 0;
        }
        var set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longestConsecutive = 1;
        for (int num: set) {
            if (!set.contains(num-1)) {
                int consecutive = 1;
                while (set.contains(num + 1)){
                    consecutive++;
                    num = num + 1;
                    }
                longestConsecutive = Math.max(longestConsecutive, consecutive);
            }
        }

        return longestConsecutive;
    }
}