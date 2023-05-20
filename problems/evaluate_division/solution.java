class Solution {
    // a / b = 2 -> a = 2b
    // b / c = 3 -> b = 3c
    // a = 6c -> a/c = 6
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /** 
            [
                a: [[b, 2]]
                b: [[a, 1/2], [c, 3]]
                c: [[b, 1/3]]
            ]
        */
        Map<String, HashMap<String, Double>> adj = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double weight = values[i];
            String variable1 = equation.get(0);
            String variable2 = equation.get(1);
            adj.putIfAbsent(variable1, new HashMap<>());
            adj.putIfAbsent(variable2, new HashMap<>());

            adj.get(variable1).put(variable2, weight);
            adj.get(variable2).put(variable1, 1 / weight);
        }
        
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);

            HashSet<String> visited = new HashSet<>();
            result[i] = dfs(start, end, visited, adj);
        }

        return result;
    }

    private double dfs(String start, String end, Set<String> visited, Map<String, HashMap<String, Double>> adj) {
        if (adj.containsKey(start) == false) {
            return -1.0;
        }
        
        if (start.equals(end)){
            return 1;
        }

        visited.add(start);
        
        for (Map.Entry<String, Double> neighbor : adj.get(start).entrySet()){
            String newStart = neighbor.getKey();
            if (!visited.contains(newStart)){
                double weight = dfs(newStart, end, visited, adj);
                
                // if weight is not -1.0 (terminate case)
                // then mutliply it 
                // like in querie   a -> c => 2 * 3 = 6
                if (weight != -1.0){
                    return neighbor.getValue() * weight;
                }
            }
        }
        return -1.0;
    }
}