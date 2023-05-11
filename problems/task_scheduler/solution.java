class Solution {
  public int leastInterval(char[] tasks, int n) {
    // frequencies of the tasks
    int[] frequencies = new int[26];
    for (int t : tasks) {
      frequencies[t - 'A']++;
    }

    Arrays.sort(frequencies);

    int fMax = frequencies[25];
    int idleTime = (fMax - 1) * n;

    for (int i = frequencies.length - 2; i >= 0 && idleTime > 0; i--) {
      idleTime -= Math.min(fMax - 1, frequencies[i]);
    }

    idleTime = Math.max(0, idleTime);

    return idleTime + tasks.length;
  }
}
