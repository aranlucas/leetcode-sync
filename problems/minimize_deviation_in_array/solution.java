class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> evens = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 0) {
                evens.offer(num);
                min = Math.min(min, num);
            } else {
                evens.offer(num * 2);
                min = Math.min(min, num * 2);
            }
        }

        int minDeviation = Integer.MAX_VALUE;

        while (!evens.isEmpty()) {
            int currentValue = evens.poll();
            minDeviation = Math.min(minDeviation, currentValue - min);

            if (currentValue % 2 == 0) {
                evens.offer(currentValue / 2);
                min = Math.min(min, currentValue / 2);
            } else {
                break;
            }
        }

        return minDeviation;
    }
}