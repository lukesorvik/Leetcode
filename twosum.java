import java.util.HashMap;
import java.util.Map;

public class twosum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    //brute force method
    public static int[] twoSum2(int[] nums, int target) {
        //o(n^2) time complexity

        //compare all elements in array and see if they sum up to the value
        //[2,3,4]
        //2 nested for loops

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) { //this iterates through the array, starting from i+1
                //compare with all elements in the array and see if it is the target 
                
                if (nums[i] + nums[j] == target) { //
                    return new int[] {i, j}; //the indices of the two
                }
            }
        }
        return new int[] {0, 0}; //did not find anything
            
    }
    
    //using hash table
    public static int[] twoSum(int[] nums, int target) {
        /*
         * iterate through the array once, and for each element check if the target minus the current element exists in the hash table
         * if it does, return the indices of the two
         */

        Map<Integer, Integer> map = new HashMap<>(); //hash table

        //build the hash table
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); //put the element and its index into the hash table(element, index)
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; //the value that we are looking for, the complement of the current element(element we would need to add)
            if (map.containsKey(complement) && map.get(complement) != i) { //if the hash table contains the value and the index is not the same as the current index
                return new int[] {i, map.get(complement)}; //return the indices of the two
            }
        }
        
        return new int[] {0,0}; //did not find anything
    }
}
        
 