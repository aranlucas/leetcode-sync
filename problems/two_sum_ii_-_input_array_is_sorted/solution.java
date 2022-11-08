class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        for (int i = 0; i < numbers.length; i++){
            int complement = target - numbers[i];
            
            System.out.println(complement);
            
            int res = Arrays.binarySearch(numbers, complement);
            System.out.println(res);

            if (res >= 0) {
                if (i == res){
                    return new int[] { i + 1, res + 2};
                }
                return new int[] { i + 1, res + 1};
            }
        }
        
        return new int[] { 0, 0};
    }
}