public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int result = 0;
        int row = intervals.length;

        int end = intervals[0][1];
        int start = intervals[0][0];

        for (int i = 1; i < row; i++){
            if (intervals[i][0] < end){
                end = Math.min(end, intervals[i][1]);
                result++;
            } else {
                end = intervals[i][1];
            }
        }
 
       
        return result;
    }
}