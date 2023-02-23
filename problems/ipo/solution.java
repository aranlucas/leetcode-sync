class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<int[]> pqCapital = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Queue<int[]> pqProfit = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < profits.length; i++) {
            pqCapital.add(new int[] {capital[i], profits[i]});
        }


        for (int i = 0; i < k; i++) {
            while (!pqCapital.isEmpty() && pqCapital.peek()[0] <= w) {
                pqProfit.add(pqCapital.poll());
            }

            if (pqProfit.isEmpty()) {
                break;
            }

            w += pqProfit.poll()[1];
        }

        return w;
    }
}