class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> sMap = new HashMap();

        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        List<Character> characters = new ArrayList<>(sMap.keySet());
        Collections.sort(characters, (a, b) -> sMap.get(b) - sMap.get(a));

        StringBuilder sb = new StringBuilder();
        for (char c : characters) {
            for (int i = 0; i < sMap.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
