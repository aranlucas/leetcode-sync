class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n + 1];

        for (int i = n; i >= 0; i--) {
            answer[i] = count(i);
        }

        return answer;
    }

    private int count(int x) {
        int count = 0;
        while (x != 0) {
            x &= x - 1;
            count++;
        }
        return count;
    }
}
