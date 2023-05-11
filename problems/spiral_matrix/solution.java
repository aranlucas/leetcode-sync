class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();

        int rows = matrix.length;
        int columns = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = columns - 1;
        int down = rows - 1;

        while (result.size() < rows * columns) {

            System.out.println("Traverse from left to right.");
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
                System.out.println("[" + up + "," + i + "]");
            }

            System.out.println("Traverse downwards.");
            for (int i = up + 1; i <= down; i++) {
                result.add(matrix[i][right]);
                System.out.println("[" + i + "," + right + "]");
            }

            System.out.println("up " + up + " down " + down);
            if (up != down) {
                System.out.println("Traverse from right to left.");
                for (int col = right - 1; col >= left; col--) {
                    result.add(matrix[down][col]);
                    System.out.println("[" + down + "," + col + "]");
                }
            }

            System.out.println("left " + left + " right " + right);
            if (left != right) {
                System.out.println("Traverse upwards.");
                for (int row = down - 1; row > up; row--) {
                    result.add(matrix[row][left]);
                    System.out.println("[" + row + "," + left + "]");
                }
            }
            left++;
            right--;
            up++;
            down--;
        }

        return result;
    }
}
