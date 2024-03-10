import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * This solution works but with very bad rumtime
 * O(C(n,k)) where k=3 runtime since we want every combination of each element in the array
 * //unknown runtime for the set.contains() method
 * 
 * 
 * each permutation or set where ar[i] + ar[j] + ar[k] = 0 is added to a set to check for duplicates
 * the elements in each permutation need to be unique, regardless of order
 * 
 * ex
 * Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
even tho there exists 2 unique combos that equal zero 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
the elements in each combo are the same, so we only return one of them
we check this using a set

 * 
 * 
 * 
 * this solution is bad!!! O(n^3) runtime worst case
 */

public class threesum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threesum obj = new threesum();
        List<List<Integer>> output = obj.threeSum(nums);
        System.out.println(output);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        List<List<Integer>> output = new ArrayList();
        HashSet<HashSet<Integer>> sets = new HashSet<>(); //set to check for duplicates, set of sets
        HashSet<Integer> setofI = new HashSet<>(); //set of first elements we have already checked


        //iterate starting at first element, we do this n-2 times since we are looking at 3 elements at a time
        for(int i = 0; i < n -2; i++){
            if (setofI.contains(nums[i])) { //if we have already checked this element, skip it
                continue;
            }
            //iterate starting at second element, we do this n-1 times since we are looking at 3 elements at a time
            //start at i+1 since we don't want to repeat the same element (every combination needs to be unique)
            for(int j = i+1; j< n-1; j++) {
                //iterate starting at third element, we do this n times since we are looking at 3 elements at a time
                //start at j+1 since we don't want to repeat the same element (every combination needs to be unique)
                for(int k = j+1; k < n; k++) {
                    
                    Integer[] arrayToCheck = {nums[i],nums[j],nums[k]};
                    HashSet<Integer> arraySet = new HashSet<>(Arrays.asList(arrayToCheck)); //create a set from the array

                    //if the sum of the 3 elements is 0 and the set does not contain the array, add to output
                    if ((nums[i] + nums[j] + nums[k] == 0) && !(sets.contains(arraySet))) {
                        List<Integer> thisCombo = new ArrayList();
                        thisCombo.add(nums[i]);
                        thisCombo.add(nums[j]);
                        thisCombo.add(nums[k]);

                        output.add(thisCombo); //if valid combo, add to output
                        sets.add(arraySet); //add to set to check for duplicates
                    }
                }
            }
            setofI.add(nums[i]); //add the first element to the set of first elements we have already checked
        }
        return output;   
    }
}
