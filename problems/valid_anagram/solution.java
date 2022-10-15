class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        
        var str1 = s.toCharArray();
        var str2 = t.toCharArray();
        
        Arrays.sort(str1);
        Arrays.sort(str2);
        
        return Arrays.equals(str1, str2);
    }
}