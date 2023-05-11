class Solution {

    private int maxPoints(int num, Map<Integer, Integer> points, Map<Integer, Integer> cache) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return points.getOrDefault(1, 0);
        }

        if (cache.containsKey(num)) {
            return cache.get(num);
        }
        int gain = points.getOrDefault(num, 0);
        int noChoose = maxPoints(num - 1, points, cache);
        int choose = maxPoints(num - 2, points, cache) + gain;
        cache.put(num, Math.max(choose, noChoose));
        return cache.get(num);
    }

    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        HashMap<Integer, Integer> points = new HashMap<>();
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        return maxPoints(maxNumber, points, cache);
    }
}
