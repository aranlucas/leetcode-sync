class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int lo = 0;
        int hi = piles[piles.length - 1];

        while (lo <= hi) {
            int mid = (lo + hi) /2;
            if (canEatAllBananas(piles, h, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public boolean canEatAllBananas(int [] piles, int maxHours, int k) {
        int hours = 0;

        for (int i = 0; i < piles.length; i++) {
            hours += Math.ceil((double) piles[i] / k);
        }

        return hours <= maxHours;
    }
}