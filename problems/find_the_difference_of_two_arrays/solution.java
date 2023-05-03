class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> answer1 = new HashSet<>();
        Set<Integer> answer2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        for (int num : nums1) {
            if (!set2.contains(num)) {
                answer1.add(num);
            }
        }

        for (int num: nums2) {
            if (!set1.contains(num)) {
                answer2.add(num);
            }
        }

        return Arrays.asList(new ArrayList<>(answer1), new ArrayList<>(answer2));
    }
}