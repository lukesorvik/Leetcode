public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] nums = {0,1,0,3,12};
        int[] nums2 = {0};
        Solution.moveZeroes(nums);
        Solution.moveZeroes(nums2);
        print(nums);
        print(nums2);


    }



    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}



class Solution {
    public static void moveZeroes(int[] nums) {
        
        int size = nums.length; //int that is the size of the array

        for (int i = 0; i < size; i++) {
            //runs for the length of the array

            if (nums[i] == 0) {
                //if the current element is a zero
                for (int j = i; j < size; j++) {
                    //NOT J = I+1 SINCE IF THE ARRAY IS ONLY ONCE ELEMENT IT WILL HAVE AN INDEX OUT OF BOUNDS EXCEPTION
                    //creates a for loop that searches the array for the next non zero integer to swap with current zero
                    //starts at j=i since we want to start where the zero was found so we dont swap backwards, or before in array

                    if (nums[j] != 0) {
                        //if the current element is not zero
                        nums[i] = nums[j]; //sets the zero found to the next non zero element
                        nums[j] = 0; //sets the next non zero element to zero
                        break; //once swapped have to end loop or it will keep going
                    }
                }
            }
        }


    }
}


/*
given an integer array nums
move all 0's to the end while maintaing the relative order of the non-zero elements

note you must do this in-place without making a copy of the array


I could just sort the array and then reverse it but then that would change the order

iterate backwards through array




iterate through the array
if found zero
swap next non zero element with zero



pseudo code:



for loop that runs as long as the int array
    if zero is found at current element in array
        for loop that starts at current zero and loops for whole array
            if found nonzero element (first nonzero element found)
                swap the two in the array


*/