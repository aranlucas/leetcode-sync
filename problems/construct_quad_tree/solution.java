/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);
    }
    
    public Node solve(int[][] grid, int r, int c, int length) {
        if (isSame(grid, r, c, length)) {
            return new Node(grid[r][c] == 1, true);
        } else {
            int newLength = length / 2;
            Node root = new Node(false, false);
            root.topLeft = solve(grid, r, c, newLength);
            root.topRight = solve(grid, r, c + newLength , newLength);
            root.bottomLeft = solve(grid, r + newLength, c, newLength);
            root.bottomRight = solve(grid, r + newLength, c + newLength, newLength);

            return root;
        }
    }
    
    public boolean isSame(int[][] grid, int i, int j, int length) {       
        for (int r = i; r < i + length; r++) {
            for (int c = j; c < j + length; c++) {
                if (grid[r][c] != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}