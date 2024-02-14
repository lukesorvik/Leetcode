import java.util.*;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] nums = {2,1,2};

        System.out.println(Solution.largestPerimeter(nums));
    }
}






class Solution {
    public static int largestPerimeter(int[] nums) {
        


        Arrays.sort(nums); //sorts in ascending order (min -> max)
        
        
        for (int i = nums.length-1; i > 1; i--) {
            //since arrays start at index 0, a size 3 array has indexes 0,1,2 so nums[3] is out of bounds
            //needs to start at i = nums.length-1 to mean it is at the end of the array

            if (nums[i] < nums[i-1] + nums[i-2]) {
                //if c < a + b then it is a triangle
                //if the length of biggest side (first in array since sorted max to min) is less than two sides combined then it is triangle
                //since sorting max -> min, the first valid triangle found will have the biggest perimeter
                //perimeter = sum of all side lengths, p = a+b+c
                int perimeter = nums[i] + nums[i-1] + nums[i-2];
                return perimeter;

            }
        } 

        //reaches this point if no valid triangles where found
        return 0;



    }
}



/*

given nums[] int array
return the largest perimeter of a triangle with a NON-zero area, formed from three of these lengths
if it is impossible to form any triangle of non zero area
return zero

P = a + b + c

 A = 1/2 × b × h

 need a way to find the height of the triangle




*/