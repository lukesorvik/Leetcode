public class twosumiioptimized {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while (nums[l] + nums[r] != target) { //while the sum of the two elements is not equal to the target
            if (nums[l] + nums[r] < target) { //if the sum of the two elements is less than the target increment the left pointer
                l++;
             } 
            else r--; //if the sum of the two elements is greater than the target decrement the right pointer
        }
        //if the sum of the two elements is equal to the target, we should exit the loop with L and R pointing to the two elements
        //return the indices of the two elements
        return new int[] {l+1, r+1}; //+1 because the indices are 1-based
    }
}
