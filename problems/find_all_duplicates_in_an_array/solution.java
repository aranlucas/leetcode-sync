class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        int i = 0;

        while (i < nums.length) {
            int num = nums[i] - 1;

            // Outside of array and num is not equal to it's index
            if (nums[i] != nums[num]) {
                swap(nums, i, num);
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result.add(nums[j]);
            }
        }
        return result;
    }

    private void swap(int arr[], int first, int second) {
        // simple swap algorithm
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
