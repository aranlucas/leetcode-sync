class UndergroundSystem {
    private Map<String, Pair<Double, Double>> journeyData = new HashMap<>();
    private Map<Integer, Pair<String, Integer>> checkInData = new HashMap<>();

    public UndergroundSystem() {}

    public void checkIn(int id, String stationName, int t) {
        checkInData.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInDataForId = checkInData.get(id);

        String startStation = checkInDataForId.getKey();
        Integer checkInTime = checkInDataForId.getValue();

        String routeKey = stationsKey(startStation, stationName);
        Pair<Double, Double> routeStats = journeyData.getOrDefault(routeKey, new Pair<>(0.0, 0.0));

        Double totalTripTime = routeStats.getKey();
        Double totalTrips = routeStats.getValue();

        double tripTime = t - checkInTime;
        journeyData.put(routeKey, new Pair<>(totalTripTime + tripTime, totalTrips + 1));
        checkInData.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        // Lookup how many times this journey has been made, and the total time.
        String routeKey = stationsKey(startStation, endStation);
        Double totalTime = journeyData.get(routeKey).getKey();
        Double totalTrips = journeyData.get(routeKey).getValue();
        // The average is simply the total divided by the number of trips.
        return totalTime / totalTrips;
    }

    private String stationsKey(String startStation, String endStation) {
        return startStation + "->" + endStation;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
