class Solution {
  public boolean isPalindrome(String s) {

    int left = 0;
    int right = s.length() - 1;

    while (left <= right) {
      // Check if left is not letter, increase
      if (!Character.isLetterOrDigit(s.charAt(left))) {
        left++;
        continue;
      }

      // Check if right is not letter, decrease
      if (!Character.isLetterOrDigit(s.charAt(right))) {
        right--;
        continue;
      }

      // Check if they right and left are equal to each other
      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      }

      // Incremenet both;
      left++;
      right--;
    }
    return true;
  }
}
