class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < address.length(); i++) {
            char charA = address.charAt(i);
            if (charA == '.') {
                sb.append("[.]");
            } else {
                sb.append(charA);
            }
        }
        return sb.toString();
    }
}