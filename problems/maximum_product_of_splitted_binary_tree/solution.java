class Solution {
    public int maxProduct(TreeNode root) {
        List<Long> sums = new ArrayList<Long>();
        
        var magic = new Object(){
            public long sum(TreeNode node){
                if (node == null) {
                    return 0;
                }
                long currentSum = node.val + sum(node.left) + sum(node.right);
                sums.add(currentSum);
                return currentSum;
            }
        };
        
        long totalSum = magic.sum(root);
        long best = 0;

        for (long sum : sums) {
            best = Math.max(best, sum * (totalSum - sum));
        }
        return (int) (best % 1000000007);
    }
}