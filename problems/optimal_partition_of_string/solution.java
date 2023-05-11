class Solution {
    public int partitionString(String s) {
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        int count = 1, substringStart = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (lastSeen[curr] >= substringStart) {
                count++;
                substringStart = i;
            }
            lastSeen[curr] = i;
        }

        return count;
    }
}
