class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // Priority queue to store pairs with smallest sums, sorted by the sum
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Push the initial pairs into the priority queue
        for (int x : nums1) {
            // The sum and the index of the second element in nums2
            pq.offer(new int[] {x + nums2[0], 0});
        }

        List<List<Integer>> answer = new ArrayList<>();
        while (k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int sum = pair[0]; // Get the smallest sum
            int pos = pair[1]; // Get the index of the second element in nums2
            int num1 = sum - nums2[pos];
            int num2 = nums2[pos];

            answer.add(List.of(num1, num2));
            // If there are more elements in nums2, push the next pair into the priority queue
            if (pos + 1 < nums2.length) {
                pq.offer(new int[] {sum - nums2[pos] + nums2[pos + 1], pos + 1});
            }

            k--; // Decrement k
        }

        return answer;
    }
}
