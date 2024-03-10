import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class threesumOPT {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threesumOPT obj = new threesumOPT();
        List<List<Integer>> output = obj.threeSum(nums);
        System.out.println(output);
    }
    /*
     * This solution is O(n^2) runtime
     * it uses 2 pointers to find the 3 elements that sum to 0
     * we sort the array first, then iterate through the array
     * 
     * 
     */
     public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> sol = new LinkedList<List<Integer>>(); //linked list to add to the front of the list

        //iterate through the array, n-2 times since we are looking at 3 elements at a time
        for (int i = 0; i < nums.length - 2; i++) {

            //Only consider non-duplicate elements for i
            //if first element in array, or if the element is not a duplicate to the previous element
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { //if the element is not a duplicate to the previous element
                int target = 0 - nums[i]; //target is the complement of 0-num[i], or what we would need to add to nums[i] to get 0
                int left = i + 1; //left pointer
                int right = nums.length - 1; //right pointer, start at the end of the array

                //while the left pointer is less than the right pointer, not equal
                while (left < right) {
                    if (nums[left] + nums[right] == target) { //if the sum of the 3 elements is 0
                        ArrayList<Integer> miniSol = new ArrayList<>(); //create a new arraylist to store the 3 elements
                        miniSol.add(nums[i]);
                        miniSol.add(nums[left]);
                        miniSol.add(nums[right]);
                        sol.add(miniSol); //add the arraylist to solution
                        //if the next element is a duplicate, skip it, and while the pointers are not the same
                        while (left < right && nums[left] == nums[left + 1]) {  //iterate to the right until we find a non-duplicate element
                            left++;
                        }
                        //if the next element is a duplicate, skip it, and while the pointers are not the same
                        while (left < right && nums[right] == nums[right - 1]) { //iterate to the left until we find a non-duplicate element
                            right--;
                        }
                        left++; //set the left pointer to the next element
                        right--; //set the right pointer to the previous element

                    } else if (nums[left] + nums[right] > target) { //if the sum of the 3 elements is greater than 0
                        right--; //shift the right pointer to the left, so the sum is smaller
                    } else { //if the sum of the 3 elements is less than 0
                        left++; //shift the left pointer to the right, so the sum is larger
                    }
                }
            }
        }

        return sol;
    }
}
