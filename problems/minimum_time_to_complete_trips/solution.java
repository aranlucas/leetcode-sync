class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long result = 0;
        int maxTime = 0;
        
        for (int t : time) {
            maxTime = Math.max(maxTime, t);
        }
        long lo = 1;
        long hi = (long) maxTime * totalTrips;
        
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            
            if (canPass(mid, time, totalTrips)) {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return result;
    }
    
    public boolean canPass(long givenTime, int[] time, int totalTrips) {
        long actualTrips = 0;
        
        for (int t : time) {
            actualTrips += givenTime / t;
        }
        return actualTrips >= totalTrips;
    }
}