class Solution {
    public double average(int[] salary) {
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        double sum = 0;

        for (int s: salary) {
            max = Math.max(max, s);
            min = Math.min(min, s);
            sum += s;
        }

        return (sum - max - min) / (salary.length - 2);
    }
}