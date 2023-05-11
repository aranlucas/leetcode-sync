class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        StringBuilder current = new StringBuilder();
        backtrack(ans, current, 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        // Base case
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        // 2 choices. We can start an opening bracket if we still have one (of n) left to place
        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        // We can start a closing bracket if it would not exceed the number of opening brackets.
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
