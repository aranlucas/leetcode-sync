class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        List<String> current = new ArrayList();
        
        backtrack(0 ,s, result, current);
        
        return result;
    }
    
    public void backtrack(int start, String s, List<List<String>> result, List<String> current){
        if(start >= s.length())
            result.add(new ArrayList(current));
        
        for(int i = start; i < s.length(); i++){
            String candidate = s.substring(start, i + 1);
            System.out.println(candidate);
            // Check if valid candidate
            if (isPalindrome(candidate)) {
                current.add(candidate);
                // Given the candidate, explore further.
                backtrack(i + 1, s, result, current);
                // Remove candidate
                current.remove(current.size()-1);         
            }

        } 
    }
    
    public boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    } 
}