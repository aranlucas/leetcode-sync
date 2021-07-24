class Solution {
    public int[] twoSum(int[] nums, int target) {
        var answer = new int[2];
        var map = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                answer[1] = i;
                answer[0] = map.get(target - nums[i]);
                return answer;
            }
            map.put(nums[i], i);
        }
        return answer;
    }
}