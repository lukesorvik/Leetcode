import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        List<List<Integer>> start = new ArrayList<List<Integer>>();
        //creates an arraylist of int arrays

        List<Integer> num = new ArrayList<>(); //creates an integer arraylist
        num.add(1); //adds 1 to the integer array list
        start.add(num); //adds the [1] array list to the arraylist of int arrays



        System.out.println(start); //before pescal triangle
        start = Solution2.generate(6); //generates 4 rows based off the [1]
        System.out.println(start); //after pescal triangle


        int rowIndex = 5;
        num = Solution.getRow(rowIndex);
        System.out.println("row " + rowIndex + " of pascal triangle = " + num);



        
    }




}



class Solution {
    public static List<Integer> getRow(int rowIndex) {
        /*
         * create first row off triangle
         * keep adding onto the row until we reach the desired row
         * 
         * 
         * use current row
         * use prev row
         * but dont store list of rows like before
         * 
         */

         List<Integer> curr = new ArrayList<>();

         for (int i = 0; i <= rowIndex; i++) {
            
            curr.add(1); //adds 1 to end of list every

            for (int j = i -1 ; j > 0; j--) {
                //as long as j is greater than zero
                //j is initialized to i -1 each loop
                //iterates down each loop
                //so ex starts when i = 2, j = 1
                // sets index 1 of [1,1,1] to j + j-1 (1+1)
                // or [1,2,1]
                //then j--
                //and j=0 so this ends
                //this prevents j from running at the first index of the array, and since it is i-1 it wont run starting at the end of the array
                //it runs at the end-1 -> start +1
                //i represents the END INDEX of the current row (so at loop 1 or i = 0, the row should only have one value or index of 0)
                //ex: at row 2, i = 2 which means the length of that row is 3 since the last index of the array is 2 [0,1,2]


                curr.set(j, curr.get(j) + curr.get(j-1)); //replaces the middle element with the current element + the previous element
                //works from the end of the array towards the front 
                //ex row 2 starts as [1,1,1]
                //then 1->2 [1,2,1]
                
                //ex row 3 starts as [1,2,1,1]
                //index 2 int 1 -> (1+2) or (j + j-1) -> 3
                //[1,2,3,1]
                //then 2-> (1+2) or (j+ j-1)
                //[1,3,3,1]

            }


         }

         return curr;


    }
}




/*
         * given ONLY AN INTEGER return the array representing the row of the pascal triangle
         * 
         * ex: rowIndex = 0
         * [1]
         * 
         * ex: rowIndex = 1
         * output[1,1]
         * 
         * 
         * so i could just use previous program to build pascal triangle until the row and then return the completed row
         * 
         * or i could calculate the row without having to calculate every previous row (if thats possible)
         * 
         * how would i do that?
         * 
         * 
         * the first middle value of the row is Row# 
         * row 2 = [1,2,1]
         * row 3 = [1,3,3,1]
         * 
         * but with row 4 it is
         * 
         * [1,4,6,4,1]
         * 
         * row 5
         * [1, 5, 10, 10, 5, 1]
         * 
         * i cant find an equation from this
         */



class Solution2 {
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