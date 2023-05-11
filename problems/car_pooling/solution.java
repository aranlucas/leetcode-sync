class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> timestamp = new TreeMap<>();
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            // Get timestamp for start trip, and add people joining at that point
            int startPassenger = timestamp.getOrDefault(from, 0) + numPassengers;
            timestamp.put(from, startPassenger);

            // Get timestamp for end trip, and remove people joining at that point
            int endPassenger = timestamp.getOrDefault(to, 0) - numPassengers;
            timestamp.put(to, endPassenger);
        }
        int usedCapacity = 0;

        for (int passengerChange : timestamp.values()) {
            usedCapacity += passengerChange;
            if (usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}
