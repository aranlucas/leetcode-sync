class Solution {
    public boolean isAnagram(String s, String t) {
        return sortWord(s).equals(sortWord(t));
    }

    public String sortWord(String s) {
        char[] sChars = s.toCharArray();

        Arrays.sort(sChars);

        return new String(sChars);
    }
}
