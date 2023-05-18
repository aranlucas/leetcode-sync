class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff.add(i);
            }
        }

        if (diff.size() == 0) {
            return true;
        }

        if (diff.size() == 2) {
            int index1 = diff.get(0);
            int index2 = diff.get(1);

            return s1.charAt(index1) == s2.charAt(index2) && s1.charAt(index2) == s2.charAt(index1);
        }
        return false;
    }
}