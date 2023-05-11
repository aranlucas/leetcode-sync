class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList();
    List<Integer> current = new ArrayList();

    Arrays.sort(candidates);
    backtrack(0, candidates, target, result, current);
    return result;
  }

  public void backtrack(
      int start, int[] candidates, int target, List<List<Integer>> result, List<Integer> current) {
    if (target < 0) return;
    if (target == 0) {
      result.add(new ArrayList(current));
    }

    for (int i = start; i < candidates.length; i++) {
      int candidate = candidates[i];
      if (i > start && candidate == candidates[i - 1]) continue; // skip duplicates
      current.add(candidate);
      backtrack(i + 1, candidates, target - candidate, result, current);
      current.remove(current.size() - 1);
    }
  }
}
