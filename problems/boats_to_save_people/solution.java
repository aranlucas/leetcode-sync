class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int lo = 0;
        int hi = people.length - 1;

        int ans = 0;

        while (lo <= hi) {
            ans++;

            if (people[lo] + people[hi] <= limit) {
                lo++;
            }
            hi--;
        }

        return ans;
    }
}
