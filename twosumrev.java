import java.util.HashMap;
import java.util.Map;
        /*
         * iterate through the array once, and for each element check if the target minus the current element exists in the hash table
         * if it does, return the indices of the two
         * 
         * 
         * idea:
         * create a map of elements to their index
         * iterate through the array
         * for each element, we are looking for complement = target - element
         * instead of iterating through the array again to find the complement, we can use a hash table to store the elements and their index
         * so if the complement exists such that nums[i] + complement = target, we can return the indices of the two
         * 
         */
public class twosumrev {
     public static int[] twoSum(int[] nums, int target) {


        Map<Integer, Integer> map = new HashMap<>(); //hash table

        //build the hash table, put the element and its index into the hash table <element, index>
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); //put the element and its index into the hash table(element, index)
        }

        //iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; //the value that we are looking for, the complement of the current element(element we would need to add)
            if (map.containsKey(complement) && map.get(complement) != i) { //if the hash table contains the value and the index is not the same as the current index
                return new int[] {i, map.get(complement)}; //return the indices of the two
            }
        }
        
        return new int[] {0,0}; //did not find anything
    }
}
