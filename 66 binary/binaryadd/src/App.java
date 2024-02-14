public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("1 - 0 chars is: " + ('1' - '0'));
        System.out.println("1 - 0 chars is: " + ('0' - '0'));


        String a = "11";
        String b = "1";

        String c = "1010";
        String d = "1011"; //strings are immutable meaning they cannot be changed


         System.out.println( Solution.addBinary(a,b) );
         System.out.println( Solution.addBinary(c,d) );




        
    }
}


class Solution {
    public static String addBinary(String a, String b) {

        /*
        start at the end of the string



        approach: 
        We start at the right end of each binary number, adding the digits and any carry-over value, and storing the result in a new string.

        Now we move to the next digit on the left and repeats the process until it has gone through all the digits in both binary numbers.
        
        If there is any carry-over value after adding all the digits, append it to the end of the new string.

        explanation to approach: 
        First, we initialize a StringBuilder object to store the sum and two integer variables 'carry' and 'i' to keep track of the carry-over value and the current position in the first binary number (a), respectively.

        We also initialize another integer variable 'j' to keep track of the current position in the second binary number (b). Here is how the code initializes these variables:

        Next, we enter a while loop that iterates until we have processed all digits in both binary numbers and there is no more carry-over value left. In each iteration, we add the digits from both numbers at the current position and the carry-over value (if any), and append the result to the StringBuilder object.

        We also update the carry-over value based on the sum of the digits. 

        */

        StringBuilder sb = new StringBuilder(); //mutable string that can be changed
        //going to use this to add or subtract values to

        int carry = 0; //number to keep track of carry over values
        int i = a.length() -1; //sets i to the last index number of a string
        int j = b.length() -1; //sets j to the last index number of b string

        while ( i >= 0 || j >= 0 || carry == 1) {
            //runs as long as one of these are true
            //i has not iterated through completely
            //j has not iterated through completely
            //the carry over value is 1 (should be 0 when ends)

            if (i>=0) {
                //only does this if i has not iterated through completely
                carry += a.charAt(i) - '0' ; 
                i--;
                //i-- subtracts the current i value by one before it searches the char, so it checks the char to the left
                //the -'0' casts it to an int since '1' - '0' will yeild 49-48 in ac11 values
                //which will end with 1, the actual value of the integer
                //a fast way to cast a char to the correct int number subtract by '0'

                //WHAT THIS DOES
                //adds current element to count
                //subtracts i by one to iterate string from end to first

            }

            if (j>=0) {
                //only runs here if j has not iterated through
                carry += b.charAt(j) - '0'; //subtracts by zero to get int value from char ex: 49(1) - 48(0) ac11 values = 1
                j--;
                //adds current element at j index to count
                //subtracts j by one to iterate to the left

            }

            sb.append(carry % 2); //append adds the count to the end of the stringbuilder (mutable, changable string)
            // %2 is the remainder after dividing by 2
            // so 1 % 2 leaves a 1 remainder
            // 2 % 2 leaves no remainder

            //if 2 adds 0 (since can only be 1 or 0)
            //if 2 then means to carry a 1 over to next element (like addition)


            carry /= 2;
            //if carry is equal to 2 then this sets it to 1
            //carry is only equal to 2 if both current elements at i & j = 1
            //that means there should be +1 at next element in sb iteration



        }

        return sb.reverse().toString();
        //since adds to string builder to end it will add the last first
        //since we start at last
        //reverse whole thing to get in right order
        





    }
}