class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

        for (int num : map.keySet()) {
            pq.add(num);

            while (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i] = pq.poll();
            i++;
        }
        return result;
    }
}
