class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int num = nums[i] - 1;

            if (nums[i] != nums[num]) {
                swap(nums, i, num);
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(nums));
        // search for first missing number using linear search
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return nums[j];
            }
        }
        return nums.length;
    }

    private void swap(int arr[], int first, int second) {
        // simple swap algorithm
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
