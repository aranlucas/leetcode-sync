class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) {
      return new ArrayList<>();
    }
    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
      String sorted = sortString(str);

      if (!map.containsKey(sorted)) map.put(sorted, new ArrayList<>());

      map.get(sorted).add(str);
    }

    return new ArrayList<>(map.values());
  }

  public static String sortString(String inputString) {
    char Array1[] = inputString.toCharArray(); // converting input string to char array

    Arrays.sort(Array1);

    return new String(Array1); // return sorted string
  }
}
