class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String curWord = strs[i];
            String sorted = sortWord(curWord);

            if (map.containsKey(sorted)) {
                map.get(sorted).add(curWord);
            } else {
                map.put(sorted, new ArrayList<>());
                map.get(sorted).add(curWord);
            }
        }
        return new ArrayList(map.values());
    }

    public String sortWord(String s) {
        char[] sChar = s.toCharArray();

        Arrays.sort(sChar);

        return new String(sChar);
    }
}