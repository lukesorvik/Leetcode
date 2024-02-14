import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        
        System.out.println(Solution.climbStairs(1));
        System.out.println(Solution.climbStairs(2));
        System.out.println(Solution.climbStairs(3));
        System.out.println(Solution.climbStairs(7));
        System.out.println(Solution.climbStairs(41));
        System.out.println(Solution.climbStairs(60)); //if n is too high it returns a negative value since the integer is too long
    }
}

//recursive way to solve
//fibonacci sequence equation
// f(n) = f(n-1) + f(n-2)
//uses memoization with a map

//N DOES NOT EQUAL VALUE AT FIBONACCI SEQUENCE
//N IS THE INDEX OF THE FIBONACCI SEQUENCE STARTING AT ZERO
// 0 1 1 2 3 5 8 13 etc

class Solution {
   
    //overloaded method
    //always starts here at beginning of recursion
    public static int climbStairs(int n) {

        
        Map<Integer, Integer> memoization = new HashMap<>(); //initializes a new hashmap


        return climbStairs(n, memoization); //returns the value of recursion with the n value as input, and the map
        

    }

    public static int climbStairs(int n, Map<Integer, Integer> memoization) {

        
        
        
        //base case (when to end recursion)
        if (n <= 1) { //if n is 0 or 1 return 1
            return 1;
        }

        
        //to utilize momoization we need to store the calculation f(n-1) + f(n-2)
        //if the current n value is not the map
        //calulate the value and add to map

        if (!memoization.containsKey(n)) { //reads true if does not contain true, running if statement
        //reaches this point if it is not in map
           memoization.put(n,  (climbStairs(n-1, memoization) + climbStairs(n-2, memoization) )  );
           //calls recursively to put the nth value into map, with the current map
        }
      

        //reaches this point if n,value are int map

         return memoization.get(n); //returns the value at n 

    }






    
}

