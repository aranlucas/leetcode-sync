class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(sb.isEmpty()) {
                sb.append(current);
            } else if((Math.abs(sb.charAt(sb.length() - 1) - current)) == 32) {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(current);
            }
        }
        return sb.toString();
    }
}