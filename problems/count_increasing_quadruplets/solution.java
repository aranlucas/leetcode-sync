class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        int count = 0;
        // countLarger[i][j] means how many numbers between index i and index j (both inclusive) that is larger than nums[i]
        int[][] countLarger = new int[n][n];
        // countSmaller[i][j] means how many numbers between index i and index j (both inclusive) that is smaller than nums[j]
        int[][] countSmaller = new int[n][n];

        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    countLarger[i][j] = ++c;
                } else {
                    countLarger[i][j] = c;
                }
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            int c = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    countSmaller[j][i] = ++c;
                } else {
                    countSmaller[j][i] = c;
                }
            }
        }     
        long res = 0;
        for (int j = 1; j < n - 2; j++) {
            for (int k = j + 1; k < n - 1; k++) {
                if (nums[k] > nums[j]) continue;
                // find the count how many numbers smaller than nums[k] and index smaller than j, and how many numbers larger than nums[j] and index larger than k， than add the product of them into res
                res += (countSmaller[0][k] - countSmaller[j][k]) * (countLarger[j][n - 1] - countLarger[j][k]);
            }
        }
        return res;
    }
}