class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> map = new HashMap<>();

        int maxFruits = 0;

        int left = 0;
        for (int right = 0; right < fruits.length; right++) {
            // 1) add a new value to the sliding window
            int r = fruits[right];
            map.put(r, map.getOrDefault(r, 0) + 1);
            // 2) 'repair' the window if it violates the constraints
            while (map.size() > 2) {
                int l = fruits[left];
                map.put(l, map.get(l) - 1);

                if (map.get(l) == 0) {
                    map.remove(l);
                }

                left++;
            }
            // 3) at this point you know that your sliding window is always valid
            // check condition min/max/whatever
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}