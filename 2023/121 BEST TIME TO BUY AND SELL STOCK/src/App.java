public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");



        int[] prices = {7,1,5,3,6,4};

        System.out.println(Solution.maxProfit(prices));
    }
}




class Solution {
    public static int maxProfit(int[] prices) {
        
      
        int low = Integer.MAX_VALUE; //initialized at the highest number possible so that anything inputed IS LESS and min WILL BE SET TO LOWEST IN LIST
        int currentProfit= 0;
        int bestProfit = 0;

        for (int i = 0 ; i < prices.length; i++){

            if (prices[i] < low) {
                //if the current price is lower than the lowest price found
                low = prices[i]; //set low to current price
            }
            

            currentProfit = prices[i] - low; //the current profit is the current price today minus the lowest
            //does not keep track of a high, keeps track of a profit
            //this way as time moves on it calculates and remembers the highest profit possible for the lowest number found

            if (bestProfit < currentProfit) { 
                //if the best profit found is less than the current profit possible today
                
            bestProfit = currentProfit;
            }
        }

        return bestProfit;
    }
}


/*
 * 
 * given an array of prices where prices[i] is the price of a given stock on the i^th day
 * you want to maximize your profit by choosing a SINGLE DAY to buy one stock and choosing A DIFFERENT DAY IN THE FUTURE TO SELL THAT STOCK
 * 
 * RETURN THE MAXIMUM PROFIT YOU CAN ACHIEVE FROM THIS TRANSACTION. IF YOU CANNOT ACHIEVE ANY PROFIT RETURN 0
 * 
 * 
 * 
 * find the lowest number in array
 * find biggest number after lowest number
 * 
 * return the difference of the two numbers(profit)
 * 
 * pseudo code:
 * iterate through array keeping track of the smallest number
 * 
 * int low
 * int high
 * 
 * for (i = 0 (start of array) run as long as < array length i ++
 *  
 * if (prices[i] < low) {low = prices[i]; }
 * 
 * if (prices[i] > low) {high = prices[i]}
 * 
 * return high-low;
 * 
 * problems:
 * if last element in array is less than current low value, but not higher value exists (since it is at end of array)
 * -must reset high number once a new low number is found (must be in the future)
 * -could iterate backwords to fix this?
 * 
 * 
 * 
 */