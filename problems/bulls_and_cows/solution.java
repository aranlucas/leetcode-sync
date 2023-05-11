class Solution {
  public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;

    Map<Character, Integer> map = new HashMap();

    for (int i = 0; i < guess.length(); i++) {
      char guessChar = guess.charAt(i);
      char secretChar = secret.charAt(i);

      if (secretChar == guessChar) {
        bulls++;
      } else {
        if (map.getOrDefault(secretChar, 0) < 0) cows++;
        if (map.getOrDefault(guessChar, 0) > 0) cows++;
        map.put(secretChar, map.getOrDefault(secretChar, 0) + 1);
        map.put(guessChar, map.getOrDefault(guessChar, 0) - 1);
      }
    }

    StringBuilder sb = new StringBuilder();

    sb.append(bulls);
    sb.append("A");
    sb.append(cows);
    sb.append("B");

    return sb.toString();
  }
}
