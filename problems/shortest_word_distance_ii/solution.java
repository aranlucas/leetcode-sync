class WordDistance {
    Map<String, List<Integer>> locations;

    public WordDistance(String[] wordsDict) {
        locations = new HashMap<>();

        for (int i = 0; i < wordsDict.length; i++) {
            List<Integer> loc = locations.getOrDefault(wordsDict[i], new ArrayList<>());
            loc.add(i);
            locations.put(wordsDict[i], loc);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> loc1 = locations.get(word1);
        List<Integer> loc2 = locations.get(word2);

        int minDiff = Integer.MAX_VALUE;
        int l1 = 0;
        int l2 = 0;

        while (l1 < loc1.size() && l2 < loc2.size()) {
            minDiff = Math.min(minDiff, Math.abs(loc1.get(l1) - loc2.get(l2)));
            if (loc1.get(l1) < loc2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }
        return minDiff;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
