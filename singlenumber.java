import java.util.Arrays;

public class singlenumber {
    
    /*
    runtime:
    O(nlogn) since we have to sort the array
    O(n) since iterate over the array
    = O(2nlogn) = O(nlogn)

    Space complexity = o(1) since just the boolean operator, 
    constant space means space used does not change with input size of 


    This solution is not linear
    runtime O(nlogn) > O(n), actual fast solution uses xor!!!
    */
    public int singleNumber(int[] nums) {
        
        Arrays.sort(nums); //sort increasing order

        //edge case single size array
        if(nums.length ==1 ) {
            return nums[0];
        }

        boolean pairAtI = false; //boolean val to keep track of whether current number is a pair

        //11224
        //122
        //iterate through i looking ahead 1
        for (int i =0; i < nums.length-1; i++){
            //if i == i+1 then we have a pair
            if (nums[i] == nums[i+1]) {
                pairAtI= true; //set to a pair
            }

            //if i =! i+1 and there was no pair at i, then return i (since i had no pair, and the pair must be next)
            if ( nums[i] != nums[i+1] && pairAtI == false) {
                return nums[i];
            }

            //if i!=i+1 and there is a pair at i, then reset for new pair starting at i+1
            if ( nums[i] != nums[i+1] && pairAtI == true ) {
                pairAtI = false; //reset
            }

            
            //but if we just reset, and we are at the end of the array then the single number
            //must be i+1, since there is not other number for it to be pairs with 
            if(i == nums.length-2 && pairAtI == false) {
                return nums[i+1];
            }

        }



        return 0; //debugging for compiler


    }
}
