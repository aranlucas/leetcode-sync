class Solution {
  public void setZeroes(int[][] matrix) {

    Set<Integer> zeroColumn = new HashSet();
    Set<Integer> zeroRow = new HashSet();

    // Find all the zero's
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          zeroRow.add(i);
          zeroColumn.add(j);
          System.out.println(i + "," + j);
        }
      }
    }

    // Find all the zero's
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (zeroRow.contains(i) || zeroColumn.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}
