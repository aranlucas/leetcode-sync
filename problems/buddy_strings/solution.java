class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            // If we have 2 same characters in string 's',
            // we can swap them and still the strings will remain equal.
            int[] count = new int[26];
            for (int i = 0; i < s.length(); ++i) {
                count[s.charAt(i) - 'a']++;
                if (count[s.charAt(i) - 'a'] == 2) {
                    return true;
                }
            }

            return false;
        } 
        int first = -1;
        int second = -1;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    // We have at least 3 indices with different characters,
                    // thus, we can never make the strings equal with only one swap.
                    return false;
                }
            }
        }

        if (second == -1) {
            // We can't swap if the character at only one index is different.
            return false;
        }

        // All characters of both strings are the same except two indices.
        return s.charAt(first) == goal.charAt(second) &&
                s.charAt(second) == goal.charAt(first);
    }
}