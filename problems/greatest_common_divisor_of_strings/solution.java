class Solution {
    public String gcdOfStrings(String str1, String str2) {

        for (int i = Math.min(str1.length(), str2.length()); i >= 0 ; i--) {
            if (prefix(i, str1, str2)) {
                return str1.substring(0, i);
            }
        }

        return "";
    }

    public boolean prefix(int i, String str1, String str2) {
        String base = str1.substring(0, i);
        return str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty();
    }
}