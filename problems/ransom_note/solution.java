class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {

    if (ransomNote.length() > magazine.length()) {
      return false;
    }

    Map<Character, Integer> magazineCounts = new HashMap<>();

    for (char c : magazine.toCharArray()) {
      int currentCount = magazineCounts.getOrDefault(c, 0);
      magazineCounts.put(c, currentCount + 1);
    }

    for (char c : ransomNote.toCharArray()) {
      int countInMagazine = magazineCounts.getOrDefault(c, 0);

      if (countInMagazine == 0) {
        return false;
      }

      magazineCounts.put(c, countInMagazine - 1);
    }

    return true;
  }
}
