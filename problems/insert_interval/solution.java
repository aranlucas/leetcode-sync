class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        
        
        int idx = 0;
        int n = intervals.length;
        
        LinkedList<int[]> output = new LinkedList<int[]>();
        
        // add all intervals before newInterval
        while (idx < n && newStart > intervals[idx][0])
            output.add(intervals[idx++]);
        
        // add newInterval
        int[] interval = new int[2];
        // if there is no overlap, just add the interval
        if (output.isEmpty() || output.getLast()[1] < newStart)
            output.add(newInterval);
        // if there is an overlap, merge with the last interval
        else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }

        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0];
            int end = interval[1];
            
            // No overlap
            if (output.getLast()[1] < start){
                output.add(interval);
            } else {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][2]);
    }
}