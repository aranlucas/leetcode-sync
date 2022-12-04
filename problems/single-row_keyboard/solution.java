class Solution {
    public int calculateTime(String keyboard, String word) {
        
        Map<Character, Integer> index = new HashMap();
        
        int i = 0;
        for (char c : keyboard.toCharArray()) {
            index.put(c, i++);
        }
        
        int totalTime = 0;
        int prev = 0;
        
        for (char c: word.toCharArray()) {
            totalTime += Math.abs(prev - index.get(c));
            prev = index.get(c);
        }
        return totalTime;
    }
}