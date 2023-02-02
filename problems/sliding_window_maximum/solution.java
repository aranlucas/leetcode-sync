class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];

            // [currentNum, index]
            pq.add(new int[]{ currentNum, right });

            while (right - left + 1 == k) { 
                int[] max = pq.peek();

                while (!pq.isEmpty() && max[1] < left){
                    pq.poll();
                    max = pq.peek();
                }
                answer[left] = max[0];
                left++;
            }
        }


        return answer;
    }
}