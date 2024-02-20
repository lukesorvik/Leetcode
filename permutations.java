import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class permutations {
    public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>(); // create a list of lists to store the permutations
    
    if(nums.length == 0) return result; // if the array is empty, return an empty list


    for (int i = 0; i < nums.length; i++) { // for each number in the array
        int n = nums[i]; // get the number
        int[] remaining = new int[nums.length - 1]; // create a new array to store the remaining numbers
        for (int j = i+1;  j < nums.length; j++) { // for each number in the array
           
            remaining[j] = nums[j]; // add the number to the remaining array
            
        }
        List<List<Integer>> perms = permute(remaining); // get the permutations of the array

        for (List<Integer> perm : perms) { // for each permutation
            perm.add(n); // add the number to the permutation
           
        }
        result.add(perms); // add the permutation to the result

    }
    return result; // return the result




}
