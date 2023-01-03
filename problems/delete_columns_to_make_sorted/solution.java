class Solution {
    public int minDeletionSize(String[] strs) {
        int minDel = 0;
        
        for (int i = 0; i < strs[0].length(); i++) {            
            for (int j = 1; j < strs.length; j++) {
                char prev = strs[j - 1].charAt(i);
                char cur = strs[j].charAt(i);
                
                if (cur < prev) {
                    minDel++;
                    break;
                }
            }
        }
        
        return minDel;
    }
}