class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int ans = 2;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int delta = nums[j] - nums[i];
                int cnt = 2;
                int prev = nums[j];
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] - prev != delta) {
                        continue;
                    } else {
                        prev = nums[k];
                        cnt++;
                    }
                }

                ans = Math.max(ans, cnt);
            }
        }

        return ans;
    }
}
