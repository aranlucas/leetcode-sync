class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        boolean canAttend = true;
        
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        
        for (int i = 1; i < intervals.length; i++){
            if (isOverlap(intervals[i-1], intervals[i])){
                return false;
            }
        }
        
        return canAttend;
    }
    
    public boolean isOverlap(int[] a, int[] b) {
        int l = Math.max(a[0], b[0]);
        int r = Math.min(a[1], b[1]);
        return l < r;
    }
}