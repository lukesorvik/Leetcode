
/*
 * 
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 * 
 * 
 * brute force:
 * could use a hash table to store the elements and their index
 * then iterate through the array and for each element, check if the complement exists in the hash table
 * that is O(2n) runtime
 * best case is O(n) if the first element + the complement = target
 * 
 * we can use the fact that the array is sorted to our advantage
 * we can use two pointers, one starting at the beginning and one at the end
 * if the sum of the elements at the two pointers it > target then we move the right pointer to the left (decrement sum)
 * if the sum of the elements at the two pointers is < target then we move the left pointer to the right (increment sum)
 * if the sum of the elements at the two pointers is == target then we return the indices of the two
 * else we return an empty array
 * worst case runtime is O(n) since iterating through the array once
 * best case is O(1) if the two elements are at the beginning and end of the array
 * 
 */


public class twosumii {
    public static void main(String[] args) {
        //int[] numbers = {2,7,11,15};
        //int target = 9;

        int[] numbers = {2,3,4};
        int target = 6;

        int[] answer = twoSum(numbers, target);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) {
            return new int[0]; //return empty array
        }

        int[] answer = new int[2];
        
        int left = 0; //left pointer
        int right = numbers.length - 1; //right pointer

        while (left<right) { //while we are in bounds 
            while (numbers[left] + numbers[right] > target && left<right) {
                right--;
            }
            while (numbers[left] + numbers[right] < target && left<right) {
                left++;
            }
            if (numbers[left] + numbers[right] == target) {
                answer[0] = left+1;
                answer[1] = right+1;
                return answer;
            }
        }
        return answer;
        
    }
}
