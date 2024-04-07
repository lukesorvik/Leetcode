public class findminRotate {
    public static void main(String[] args) {
        findminRotate test = new findminRotate();
        int[] nums = {3,4,5,1,2};
        System.out.println(test.findMin(nums));
    }

    public int findMin(int[] nums) {
        int left = 0; //left pointer
        int right = nums.length - 1; //right pointer
        while(left < right) { //while left pointer is less than right pointer, not equal
            int mid = (left + right) / 2; //set mid pointer
            if(nums[mid] > nums[right]) { //if the mid is greater than the rightmost element then we know everything to the right must be smaller than mid
                left = mid + 1;
            } else { //mid ele <= right ele this means everything to the right is greater than it, so what we are looking for must be to the left
                right = mid;
            }
        }
        return nums[left]; //ends with left pointer on the element
    }
}
