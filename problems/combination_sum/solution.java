class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList();

    List<Integer> current = new ArrayList();

    backtrack(0, candidates, target, result, current);

    return result;
  }

  public void backtrack(
      int start, int[] candidates, int target, List<List<Integer>> ans, List<Integer> current) {
    if (target == 0) {
      ans.add(new ArrayList<>(current));
    }
    for (int i = start; i < candidates.length; i++) {
      if (target > 0) {
        int candidate = candidates[i];
        current.add(candidate);
        backtrack(i, candidates, target - candidate, ans, current);
        current.remove(current.size() - 1);
      }
    }
  }
}
