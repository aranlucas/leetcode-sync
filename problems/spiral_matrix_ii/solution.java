class Solution {
    // [row][column]
    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];

        int count = 1;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        while (top <= bottom && left <= right) {
            // column changes
            // [top, left]
            // [0, 0]
            // [0, 1]
            // [0, 2]
            for (int col = left; col <= right; col++) {
                answer[top][col] = count;
                count++;
            }

            // row changes
            // [top][right]
            // [1, 3]
            // [2, 3]
            for (int row = top + 1; row <= bottom; row++) {
                answer[row][right] = count;
                count++;
            }
            right--;
            
                // col changes
                // [bottom][right]
                // [2, 2]
                // [2, 1]
                // [2, 0]
                for (int col = right; col >= left; col--) {
                    answer[bottom][col] = count;
                    count++;
                }
            
            bottom--;
                for (int row = bottom; row > top; row--) {
                    answer[row][left] = count;
                    count++;
                }
            
            top++;
            left++;
        }
        return answer;
    }

}