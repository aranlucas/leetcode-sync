class Solution {
    public int compress(char[] chars) {
        
        int i = 0;
        int ans = 0;
        
        while (i < chars.length) {
            char curr = chars[i];
            int count = 0;
            
            while (i < chars.length && chars[i] == curr) {
                count++;
                i++;
            }
            
            chars[ans++] = curr;
            if (count > 1){
                // for each character in character array, eg: for count=12 character array stores "1","2" separately
                for (char ch: Integer.toString(count).toCharArray()){
                    chars[ans++] = ch;
                }
            }
        }
        
        
        return ans;
    }
}