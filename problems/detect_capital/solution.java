class Solution {
  public boolean detectCapitalUse(String word) {
    if (word.toUpperCase().equals(word)) {
      // All letters are capital
      return true;
    } else if (word.toLowerCase().equals(word)) {
      // All letters are not capital
      return true;
    } else if (word.substring(1).toLowerCase().equals(word.substring(1))) {
      // First letter is capital, rest are not
      return true;
    }

    return false;
  }
}
