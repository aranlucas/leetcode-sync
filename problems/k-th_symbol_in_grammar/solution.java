class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int parent = kthGrammar(n - 1, (k + 1) / 2);
        /* notice that first position in pair contains odd k.
                      0
                   /     \
                 0         1
               /   \     /    \
              0     1    1     0
             / \   / \  / \   / \
             0  1  1 0  1  0  0  1
        k=   1  2  3 4  5  6  7  8
        */
        if (parent == 0) {
            if (k % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (k % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
