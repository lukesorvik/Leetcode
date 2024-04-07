import java.util.Arrays;

public class singlenumberopt {
    
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

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        singlenumberopt test = new singlenumberopt();
        System.out.println(test.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        
        Arrays.sort(nums); //sort increasing order

        //edge case single size array
        if(nums.length ==1 ) {
            return nums[0];
        }

        //iterate through i looking behind 1
        for (int i =1; i < nums.length-1; i+=2){
            if(nums[i] != nums[i-1]) {
                return nums[i-1];
            }

        }

        //if we reach nums.length-1 and no bad val looking back then the single number must be the last number
        //or if the array is of size 1
        return nums[nums.length-1];


    }
}
