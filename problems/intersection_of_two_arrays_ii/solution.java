class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }

        List<Integer> answer = new ArrayList<>();
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                answer.add(n);
                m.put(n, cnt - 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}