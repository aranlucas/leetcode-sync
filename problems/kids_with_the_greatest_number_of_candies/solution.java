class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];

        for (int candy : candies) {
            max = Math.max(candy, max);
        }

        Boolean[] answer = new Boolean[candies.length];
        for (int i = 0; i < candies.length; i++) {
            answer[i] = candies[i] + extraCandies >= max;
        }

        return Arrays.asList(answer);
    }
}