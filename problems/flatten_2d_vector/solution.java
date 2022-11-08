class Vector2D {
    // Constructor will put all the nums into this list.
    private List<Integer> nums = new ArrayList<>();
    // Keep track of where the Iterator is up to.
    private int position = 0;
    
    public Vector2D(int[][] vec) {
        for (int [] innerVector: vec){
            for (int num : innerVector){
                nums.add(num);
            }
        }
    }
    
    public int next() {        
        int result = nums.get(position);
        // Move the position pointer forward by 1, so that it's ready for
        // the next call to next, and gives a correct hasNext result.
        position++;
        return result;
    }
    
    public boolean hasNext() {
        return position < nums.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */