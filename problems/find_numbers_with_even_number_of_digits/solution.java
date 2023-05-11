class Solution {
  public int findNumbers(int[] nums) {
    int answer = 0;
    for (int num : nums) {
      if (countDigits(num) % 2 == 0) {
        answer += 1;
      }
    }
    return answer;
  }

  public int countDigits(int number) {
    int count = 0;
    while (number != 0) {
      number /= 10;
      count += 1;
    }
    return count;
  }
}
