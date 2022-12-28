class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int num : sticks) {
            pq.offer(num);
        }

        int totalCost = 0;
        while (pq.size() > 1) {
            int stick1 = pq.poll();
            int stick2 = pq.poll();

            int newStick = stick1 + stick2;
            totalCost += newStick;
            pq.offer(newStick);
        }

        return totalCost;
    }
}