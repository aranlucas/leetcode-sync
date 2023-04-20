class Solution {
    public int myAtoi(String s) {
        int start = 0;
        int n = s.length();
        while (start < n && s.charAt(start) == ' ') {
            start++;
        }
        int sign = 1;
        if (start < n && (s.charAt(start) == '-' || s.charAt(start) == '+')) {
            if (s.charAt(start) == '-' ) {
                sign = -1;
            }
            start++;
        }
        
        int result = 0;
        while (start < n && Character.isDigit(s.charAt(start))) {
            int digit = s.charAt(start) - '0';

            // Check overflow and underflow conditions. 
            if ((result > Integer.MAX_VALUE / 10) || 
                (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {     
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.    
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = 10 * result + digit;
            start++;
        }
        return sign * result;
    }
}