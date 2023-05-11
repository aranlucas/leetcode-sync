class Solution {
  public boolean isIsomorphic(String s, String t) {
    var sToT = new HashMap<Character, Character>();
    var tToS = new HashMap<Character, Character>();

    for (int i = 0; i < s.length(); i++) {
      var c1 = s.charAt(i);
      var c2 = t.charAt(i);

      // No mapping exists
      if (!sToT.containsKey(c1)) {
        sToT.put(c1, c2);
      }
      if (!tToS.containsKey(c2)) {
        tToS.put(c2, c1);
      }
      if (sToT.get(c1) != c2 || tToS.get(c2) != c1) {
        return false;
      }
    }

    return true;
  }
}
