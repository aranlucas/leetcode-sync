class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        for (int i = 0; i < capacity.length; i++) {
            capacity[i] -= rocks[i];
        }

        Arrays.sort(capacity);

        int maxBags = 0;
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] > additionalRocks) {
                break;
            }
            additionalRocks -= capacity[i];
            maxBags++;
        }

        return maxBags;
        
    }
}