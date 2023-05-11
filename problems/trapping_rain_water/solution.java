class Solution {
  public int trap(int[] height) {
    int left = 0;
    int right = height.length - 1;

    int maxLeft = 0;
    int maxRight = 0;
    int trappedRain = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        int waterTrappedLeft = maxLeft - height[left];
        if (waterTrappedLeft > 0) {
          trappedRain += waterTrappedLeft;
        }
        maxLeft = Math.max(height[left], maxLeft);
        left++;

      } else {
        int waterTrappedRight = maxRight - height[right];
        if (waterTrappedRight > 0) {
          trappedRain += waterTrappedRight;
        }
        maxRight = Math.max(height[right], maxRight);
        right--;
      }
    }

    return trappedRain;
  }
}
