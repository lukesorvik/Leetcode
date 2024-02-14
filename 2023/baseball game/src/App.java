import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String[] ops = {"5","2","C","D","+"};

        System.out.println(Solution.calPoints(ops));


    }
}


class Solution {
    public static int calPoints(String[] operations) {
        
        Stack<Integer> record = new Stack<Integer>();


        for (int i = 0; i < operations.length; i++) {
            //iterates through each string in the operations array

            String current = operations[i];


            //if number
            if (current.charAt(0) >= '0' && current.charAt(0) <= '9' || current.charAt(0) == '-') {
                //if first character in string is a number or - then add it to the record
                
                int number = Integer.parseInt(current); //converts the current string to a number
                
                record.push(number);
                
            }

            // if + add the two previous numbers in record and re add them
            if (current.equals("+") && !record.empty()) {
                //only runs if stack is not empty and current string is just +

                int top = record.pop();
                int belowTop = record.pop();

                int newTop = top + belowTop;

                record.push(belowTop);
                record.push(top);
                record.push(newTop);
            }

            //double (x2) most recent element in record and add new total to top of stack 
            if (current.equals("D")) {
                record.push(record.peek() * 2);
                //adds the top element *2

            }

            if (current.equals("C")){ 
                record.pop(); //removes last element from record

            }


        }

        //now should have iterated through operations, and should get the sum of everything in record

        System.out.println("stack" + record);


        int sum = 0;

        //iterate through stack and add to sum
        while (!record.empty()) {
            //runs as long as the record is not empty
            
            sum += record.pop(); //removes the top element and adds it to the sum 
        }

        return sum;

    }
}



/*
you are keeping the scores for a baseball game with strange rules
at the beginning of the game you start with an empty record

you are given a list of strings "operations" where operations[i] is the i^th operation you must apply to the record and is one of the following:

if an integer x
-record a new score of x

if '+'
-record a new score that is the sum of the previous two scores

if 'D'
-record a new score that is the double of the previous score

if 'c'
invalidate the previous score, removing it from the record

-return the sum of all the scores on the record after applying all the operations

the test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer,
and that all operations are valid

Example 1:
input: ops = [["5","2","C","D","+"]]
output = 30

5 - add 5 to the record [5]
2 - add 2 to the record, record is now [5,2]
c - inalidate and remove the previous score, record is now [5]
d - add 2 * 5 = 10 to the reocrd, record is now [5,10]
+ - add 5 + 10 = 15 to the record, record is now [5,10,15]

the total sum is 5+10+15 = 30.



how to:
given a string array

output the sum of the record based on the operations

need to make an array  OR STACK called record that is edited depending on the current operation


if current char is a number or -


*/