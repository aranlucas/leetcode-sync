class Solution {
    public int pivotInteger(int n) {
        int[] leftSum = new int[n+1];
        int[] rightSum = new int[n+1];
        leftSum[1] = 1;
        rightSum[n] = n;
        for (int i = 2; i <= n; i ++) {
            leftSum[i] = leftSum[i-1] + i;
        }
        
        System.out.println(Arrays.toString(leftSum));
        
        for (int i = n - 1; i > 0; i--) {
            rightSum[i] = rightSum[i+1] + i;
        }
        
        System.out.println(Arrays.toString(rightSum));

        for (int i = 1; i <= n; i++) {
            if (rightSum[i] == leftSum[i]) {
                return i;
            }
        }
        return -1;
    }
}