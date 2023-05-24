class Solution {
    public int numTimesAllBlue(int[] flips) {
        int ans = 0;
        int rightMost = 0;
        
        for (int i = 0; i < flips.length; i++) {
            rightMost = Math.max(rightMost, flips[i]);
            if (rightMost == i + 1) {
                ans++;
            }
        }
        
        return ans;
    }
}