/*
 * 
 * rob each houses along a street
 * each house has a certain amount of money stashed
 * only constraint from robbing all of them is that adjacent houses have security systems connected and will
 * automatically contact the police if two adjacent houses were broken into on the same night
 * 
 * given an integer array nums representing the amount of money of each house, return the 
 * MAXIMUM AMOUT OF MONEY YOU CAN ROB TONIGHT WITHOUT ALERTING THE POLICE 
 * 
 * 
 * We use tabulation to calculate the maximum money from any path starting at that current house
 * ex : give houses [1,2,3,1] the table would store [1,2,4,3] mean at house(index) 2 if we decided to end at house 2 out of any possible path
 * we can have a max of 4 buck.
 * 
 * Runtime: O(n) since we only iterate over the array once, Space : O(n) : since we store each value in the table array
 * 
 * two cases for this problem:
 * at any given house you can choose to follow the path 2 houses ago or 3 houses ago
 * so we count the max money we can make from any of those path (from the table)
 * the table stores the max amount of money we can make if we end at any house in the path
 * 
 * so for tabulation the two base cases are 
 * [0,1] (add cash at current house)
 *  and [0,1,2] (only add possible cash from index 0)
 * 
 * from then on we can lookback table[i-2] and table [i-3] without getting out of bounds 
 * 
 */


public class houserobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {1,2,3,1}) + " should be 4");
        System.out.println(rob(new int[] {2,7,9,3,1}) + " should be 12");
        System.out.println(rob(new int[] {2,1,1,2}) + " should be 4");
    }
    public static int rob(int[] nums) {
         int[] table = new int[nums.length]; //table to store the max amount of money that can be robbed at each house
         //each index will represent the max money possible if that house is included in the robbery

         int max = 0; //update the max as we go along 

        //add it up similar to fibinachi
        //
        for (int i =0 ; i< nums.length; i++) {
            //base case, [0,1]
            if(i <= 1) {
                table[i] = nums[i]; //cant look back more than 1 space so just store current house
            }
            //cant look back three spaces, can look back 2 [0,1,2]
            else if (i <= 2) {
                table[i] = nums[i] + nums[i-2]; 
            }
            //we are futher along [0,1,2,3,.....] can lookback 2to 3 values
            //store the max at the current to the previous max value from the table -2 and -3
            else {
                int max2ago = nums[i] + table[i-2];
                int max3ago = nums[i] + table[i-3];
                table[i] = Math.max(max2ago, max3ago); //store the current max money made on path equal to whichever house path we rob will make us richer 
            }

            //if the current path will make us more money
            if (table[i] > max) {
                max = table[i]; //set the max to the current house we can rob
            }
            
        }
        return max;
    }
}
