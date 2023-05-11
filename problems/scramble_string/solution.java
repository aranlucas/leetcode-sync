class Solution {
    public boolean isScramble(String s1, String s2) {
        Map<String, Boolean> map = new HashMap<>();
        return solve(s1, s2, map);
    }

    public boolean solve(String s1, String s2, Map<String, Boolean> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s2);
        String key = sb.toString();

        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (s1.equals(s2)) {
            map.put(key, true);
            return true;
        }
        int s1Array[] = new int[26];
        int s2Array[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Array[s1.charAt(i) - 'a']++;
            s2Array[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (s1Array[i] != s2Array[i]) {
                map.put(key, false);
                return false;
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            // No swap : x + y
            boolean noSwapPrefix = solve(s1.substring(0, i), s2.substring(0, i), map);
            boolean noSwapSuffix = solve(s1.substring(i), s2.substring(i), map);
            if (noSwapPrefix && noSwapSuffix) {
                map.put(key, true);
                return true;
            }

            boolean swapPrefix = solve(s1.substring(0, i), s2.substring(s1.length() - i), map);
            boolean swapSuffix = solve(s1.substring(i), s2.substring(0, s1.length() - i), map);
            // Swap: y + x
            if (swapPrefix && swapSuffix) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}
