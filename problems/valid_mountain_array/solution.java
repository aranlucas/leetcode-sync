class Solution {
    public boolean validMountainArray(int[] arr) {

        boolean isIncreasing = false;
        boolean isDecreasing = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                return false;
            }
            if (arr[i - 1] < arr[i]) {
                // cannot have a increase after decrease
                if (isDecreasing == true) {
                    return false;
                }
                isIncreasing = true;
            } else if (arr[i - 1] > arr[i]) {
                isDecreasing = true;
            }
        }

        return isIncreasing && isDecreasing;
    }
}
