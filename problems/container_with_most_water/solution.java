class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int maxArea = 0;
        while (left < right){
            int width = right - left;
            int length = Math.min(height[left], height[right]);
            int currentArea = width * length;
            maxArea = Math.max(currentArea, maxArea);
            
            if (height[left] > height[right]){
                right--;
            } else {
                left++;
            }
        }
        
        return maxArea;
    }
}