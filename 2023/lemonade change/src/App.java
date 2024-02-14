import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // int bills[] = {5,5,5,10,20};
        int bills[] = { 5, 5, 10, 10, 20 };

        boolean result = Solution.lemonadeChange(bills);
        System.out.println(result);

    }
}

class Solution {
    public static boolean lemonadeChange(int[] bills) {

      Stack<Integer> stackof5 = new Stack<>();
      Stack<Integer> stackof10 = new Stack<>();

      for (int i = 0; i < bills.length; i++) {
        
        int input = bills[i];
        
        if (input == 5) {
            stackof5.push(input); //adds 5 to the stack of 5
        }

        else if (input == 10) {
            stackof10.push(input); //adds 10 to the stack of 10
            
            //give 5 dollars in change
            if (stackof5.empty()) {
                //if the 5 dollar bill stack is empty
                return false; //cant give change
            }
            else{
                stackof5.pop(); //removes a 5 from the top of 5 stack (to give as change)
            }
        }

        else if (input == 20) {

            //TRY TO MAKE CHANGE W 10S FIRST
            if (!stackof10.empty()) {
                //if the stack of 10 has bills
                //make change for 15
                stackof10.pop(); //remove a 10 from 10 bills
                
                //check if have any 5 dollar bills
                if (stackof5.isEmpty()){
                    return false; //out of 5s cant make change
                }
                //do have 5s remove 5 dollar bill from drawer
                else stackof5.pop();
            }

            //try to make change w 3 fives
            else if(!stackof5.empty())
                {
                    for(int j=0;j<3;j++)
                    {   
                        //check if any fives left to give change
                        if(stackof5.empty())
                        {
                            return false; //ran out of fives
                        }
                        stackof5.pop();
                    }
                }

                else
                {
                    return false;
                }

        }

      }

      return true;
      
    }
}

/*
 * lemonade 5 buck
 * 
 * customers in queue to buy one at a time
 * each will only buy one lemonade
 * pay with eiter 5 10 or 20
 * you must provide the correct change to each customer so that we make 5 buck
 * off the lemade
 * 
 * NOTE YOU DO NOT HAVE ANY CHANGE IN HAND AT FIRST
 * 
 * given an array bills
 * where bills[i] is the ith customer
 * return true if you can provide every customer with the correct change
 * or false if other wise
 * 
 * 
 * change = amount given - 5
 * 
 * total money = amount given - change
 * 
 * check at end if there is negative change or positive change
 * when giving change subtract from total
 * 
 * 
 * 
 */
/*
 * lemonade 5 buck
 * 
 * customers in queue to buy one at a time
 * each will only buy one lemonade
 * pay with eiter 5 10 or 20
 * you must provide the correct change to each customer so that we make 5 buck
 * off the lemade
 * 
 * NOTE YOU DO NOT HAVE ANY CHANGE IN HAND AT FIRST
 * 
 * given an array bills
 * where bills[i] is the ith customer
 * return true if you can provide every customer with the correct change
 * or false if other wise
 * 
 * 
 * change = amount given - 5
 * 
 * total money = amount given - change
 * 
 * check at end if there is negative change or positive change
 * when giving change subtract from total
 * 
 * 
 * 
 */
