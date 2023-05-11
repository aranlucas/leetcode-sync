class Solution {
  public boolean isCircularSentence(String sentence) {
    String[] words = sentence.split(" ");

    boolean isCircular = true;
    // Check: The last character of the last word is equal to the first character of the first word.
    if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
      isCircular = false;
    }

    // Check: The last character of a word is equal to the first character of the next word.
    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];

      if (word1.charAt(word1.length() - 1) != word2.charAt(0)) {
        isCircular = false;
      }
    }

    return isCircular;
  }
}
