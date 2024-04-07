import java.util.HashMap;
import java.util.Map;

/*
 * Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].


My solution:
bruteforce: 
iterate over array A and map all values
then iterate from 1 to A.length + 1 and check if the value is in the hashmap, return the first value that is not in the hashmap

O(2n) = O(n) time complexity
O(n) space complexity (map all values in A)

Potential better solution:
sort the array
iterate over the array and check if the next element is greater than the current element + 1
if it is, return the current element + 1
if no element is found, return A.length + 1
But does not work for negative values
and negative values are allowed in the array


 */

public class codility{
    public static void main(String[] args) {
        codility test = new codility();
        int[] A = {1,3,6,4,1,2};
        System.out.println(test.solution(A));
    }

    public int solution(int[] A) {
        // Implement your solution here

        Map<Integer, Integer> map = new HashMap<>(); //create a hashmap to store the elements
        for(int i = 0; i < A.length; i++) { //iterate through the array
            map.put(A[i], 1); //put the element in the hashmap
        }


        /*
         * worst case we have to iterate over the entire array +1 to find min
         * A = [1,2,....,n] so the min would be n+1
         * 
         * We n+1 times to see if we find a number starting at 1-inf that is not in the hashmap
         * we want the min value that is not in array A
         * Worst case = O(n)
         * Best case = O(1) (if i=1 is not in the hashmap, then 1 is the min value not in the array)
         * 
         * [] -> 1
         * in this case A.length = 0, so we iterate 1 times, and return 1
         * 
         */
        for(int i = 1; i <= A.length + 1; i++) { //iterate through the array
            if(!map.containsKey(i)) { //if the element is not in the hashmap
                return i; //return the element
            }
        }

        return -420; //return -420 if no element is found
    }


}