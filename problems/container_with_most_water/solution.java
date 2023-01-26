class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while (left < right) {
            int length = Math.min(height[left], height[right]);
            int width = right - left;
            int area = length * width;

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }

            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}