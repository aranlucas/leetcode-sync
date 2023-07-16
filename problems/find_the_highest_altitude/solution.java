class Solution {
    public int largestAltitude(int[] gain) {

        int currentAltitude = 0;
        int maxAltitude = currentAltitude;
        for (int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i];
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }
}
