class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            if (bigger(words[i - 1], words[i], map)) {
                return false;
            }
        }

        return true;
    }

    boolean bigger(String s1, String s2, Map<Character, Integer> mapping) {
        int n = s1.length();
        int m = s2.length();
        for (int i = 0; i < Math.min(m, n); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                return mapping.get(c1) > mapping.get(c2);
            }
        }
        return n > m;
    }
}
