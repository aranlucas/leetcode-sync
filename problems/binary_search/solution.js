/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    
    
    return binarySearch(nums, 0, nums.length -1, target)
};

var binarySearch= function(arr,left,right ,target){
    if(right>=left){
         const mid = Math.floor(left + (right - left) / 2);
                // If the element is present at the middle
        // itself
        if (arr[mid] === target)
            return mid;
                // If element is smaller than mid, then
        // it can only be present in left subarray
        if (arr[mid] > target)
            return binarySearch(arr, left, mid - 1, target);
  
        // Else the element can only be present
        // in right subarray
        return binarySearch(arr, mid + 1, right, target);
    }
    
    return -1
}