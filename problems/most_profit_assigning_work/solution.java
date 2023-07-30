record Job(int difficulty, int profit) {}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        List<Job> jobs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            jobs.add(new Job(difficulty[i], profit[i]));
        }

        Collections.sort(jobs, (a , b) -> a.difficulty() - b.difficulty());
        Arrays.sort(worker);

        int ans = 0; 
        int i = 0; 
        int best = 0;
        for (int skill: worker) {
            while (i < n && skill >= jobs.get(i).difficulty()) {
                best = Math.max(best, jobs.get(i).profit());
                i++;
            }
            ans += best;
        }
        return ans;
    }
}