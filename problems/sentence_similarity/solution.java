class Solution {
    public boolean areSentencesSimilar(
            String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (List<String> pair : similarPairs) {
            String s1 = pair.get(0);
            String s2 = pair.get(1);

            if (!map.containsKey(s1)) {
                map.put(s1, new ArrayList<String>());
            }
            if (!map.containsKey(s2)) {
                map.put(s2, new ArrayList<String>());
            }
            map.get(s1).add(s2);
            map.get(s2).add(s1);
        }

        for (int i = 0; i < sentence1.length; i++) {
            String s1 = sentence1[i];
            String s2 = sentence2[i];
            // If the words are equal, continue.
            if (s1.equals(s2)) {
                continue;
            }
            // If the words form a similar pair, continue.
            if (map.containsKey(s1) && map.get(s1).contains(s2)) {
                continue;
            }
            return false;
        }

        return true;
    }
}
