import java.util.Arrays;

class Solution {
    public static int removeDuplicates(int[] nums) {
        /*

        given an integer array, sorted in non-decreasing order (increasing order) remove the duplicate numbers inplace, so that each number
        only appears once
        the relative order of the elements should be kept the same
        then return the number of unique elements in nums

        input: integer array in increasing order

        output: remove duplicate integers from array, return number of unique elements in the new array

        How They DID IT:
        Use two pointers i and j to iterate through the array. 
        The variable j is used to keep track of the current index where a unique element should be placed. 
        The initial value of j is 1 since the first element in the array IS ALWAYS UNIQUE and doesn't need to be changed

        */



        int j = 1; //first pointer j is used to keep track of current index of where a unique element should be placed
        //is 1 since the first element of a sorted array is always unique


        for (int i = 1; i < nums.length; i++) { 
            //i =1 because we need to compare each element with its PREVIOUS element to check for duplicates


            if (nums[i] != nums[i - 1]) {
                //if the current element is not equal to the previous element, it means the current element is unique
                
                nums[j] = nums[i]; //since current element is unique we add it to the index[j] which is where the next unique element in array should go
                j++; //add plus one to j because last j value has a unique element in it now
            }
        }
        

        //prints the done array for debug

        System.out.println("call nums to string : " + nums.toString());

        System.out.println("arrays.tostring(nums) : " + Arrays.toString(nums));// prints string of array


        System.out.println("for loop print of nums");

        for (int i = 0; i < nums.length; i++) { 
            System.out.println(nums[i]);
        }


        return j; //returns the amount of unique elements
        //since started at one, if no unique elements were added, there is only one guarenteed unique element
        //if 5 unique elements, we would only add 4 (since we don't add first unique element) meaning j would equal 5





    }
}