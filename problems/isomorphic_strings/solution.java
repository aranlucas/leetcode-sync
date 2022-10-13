class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sToT = new HashMap();
        Map<Character, Character> tToS = new HashMap();

        for(int i = 0; i < s.length() ; i ++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            // No mapping exists
            if(!sToT.containsKey(c1)){
                sToT.put(c1, c2);
            }
            if(!tToS.containsKey(c2)){
                tToS.put(c2, c1);
            }
            if(sToT.get(c1) != c2 || tToS.get(c2) != c1){
                return false;
            }
        }
        
        return true;
    }
}