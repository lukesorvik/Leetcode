import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        List<List<Integer>> start = new ArrayList<List<Integer>>();
        //creates an arraylist of int arrays


        ArrayList<Integer> num = new ArrayList<>(); //creates an integer arraylist

        num.add(1); //adds 1 to the integer array list

        start.add(num); //adds the [1] array list to the arraylist of int arrays

        System.out.println(start); //before pescal triangle

        start = Solution.generate(5); //generates 4 rows based off the [1]

        System.out.println(start); //after pescal triangle

        

    }





}



class Solution {
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> output = new ArrayList<List<Integer>>(); //creates a new arraylist of int[] arrays

        List<Integer> prev = new ArrayList<>(); //creates new array list to represent previous array

        if (numRows <= 0) return output; //if the inputed number of rows it 0, or negative return the empty list

        //create the top of the pyramid before looping
        prev.add(1); //add 1 to the previous list
	    output.add(prev); //add the [1] array to the list of arrays


        for (int i = 2; i <= numRows; i++) {
            //run until the number of rows is created (so run while i is lessthan or equal to numRows)
            //start at i = since first row is already created so if we want 3 rows we only need to create 2
            //would start at i=2 numRows = 3, loop once creating one row, and loop one more time creating third row
            //in this case i isn't really used except as just a way to keep track of how many rows is created



            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1); //adds first 1

            //loop that adds middle ints
            for (int j = 0; j < prev.size() -1 ; j ++ ) {
                //runs as long as it is smaller than the previous row
                //-1 since the second row shouldnt calculate any middle values
                //in this case j is used to calculate the middle value based off the top two values
                //first middle element starts at index 2
                //since [1] is already added to row, when we add this to the array it will be in index 2
                //since the first middle value is equal to index 0 and index 1 of previous row
                //get the equation middle = n + n+1
                curr.add(prev.get(j) + prev.get(j + 1));  

            }

            curr.add(1); //adds last 1

            output.add(curr); //adds the finished row to the list of lists
            prev = curr; //sets prevous list to current list for the next loop

        }



        return output;



       
    }
}

/*
 *  first and last element in array will always be 1
 * n= index of element in array
 *  
 * n+1 element is equal to n-1 + n+2 (top two elements from previous row)
 * 
 * need to be able to access previous row in current loop
 * 
 * 
 * 
 * 
 */

 /*
    input: a list of integer arrays
    

    first array
    n = number of elements in array
    next array should be n+1 in size


    second array
    current element = m
    first element should be m + m+1

    next row equals n+1 (size of last row plus 1)
    i = equals start element of new row
    i+2 -> n-1 are equal to top two elements

    PATTERNS:
    it is a factorial
    row 1 = 1 element
    row 2 = 2 elements
    row 3 = 3 elements etc

    first element of every row is the same as the first element in row 1
    last element of every row is the same as the first element in row 1



    classic recursion
    when n=0, number = 1 (top of pyramid)



    2 loops,
    outer loop that runs (num rows number of times)




    */
}





class Solution2 {
    public static List<List<Integer>> generate(int numRows) {
        // Create an array list to store the output result...
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        
        // Base cases...
	    if (numRows <= 0)  return output;
        //if the input says to make no or negative rows, return empty list
        
        // Create an array list to store the prev triangle value for further addition...
	    ArrayList<Integer> prev = new ArrayList<Integer>();
       
        // Inserting for the first row & store the prev array to the output array...
	    prev.add(1);
	    output.add(prev);
        
        // For rest of the rows, Traverse all elements through a for loop...
	    for (int i = 2; i <= numRows; i++) {
            
            // Create another array to store the current triangle value...
		    ArrayList<Integer> curr = new ArrayList<Integer>();
		    curr.add(1);    //first
            //adds first value which is always 1
           
            // Calculate for each of the next values...
		    for (int j = 0; j < prev.size() - 1; j++) {
                //starts at 0
                //runs as long a the current j value is less than the previous row's size -1 (so if size = 1, wont run)
                // Inserting the addition of the prev arry two values...
			    curr.add(prev.get(j) + prev.get(j + 1));    //middle
                //adds the current value to be the start of j value + next j value
		    }
            
            // Store the number 1...
		    curr.add(1);    //last
            //always 1 one on the end
            
            // Store the value in the Output array...
		    output.add(curr);
            
            // Set prev is equal to curr...
            //so next loop it will use this one
		    prev = curr;
	    }
        //reaches this point once it has made the rows
	    return output;      // Return the output list of pascal values...
    }
}

