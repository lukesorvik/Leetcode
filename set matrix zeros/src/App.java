
import java.util.*;




public class App {
    public static void main(String[] args) throws Exception {

        int[][] matrix = { {1,1,1} ,{1,0,1},{1,1,1} };

        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        System.out.println("Matrix before" );
        print(matrix);
        Solution.setZeroes(matrix);
        System.out.println("Matrix after" );
        print(matrix);

        System.out.println("\nMatrix before" );
        print(matrix2);
        Solution.setZeroes(matrix2);
        System.out.println("Matrix after" );
        print(matrix2);
    }

    //method to print matrix
    public static void print(int[][] arr)     {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
 
            System.out.println();
        }
    }

}


class Solution {
    public static void setZeroes(int[][] matrix) {
        
        int rows = matrix.length;
        int columns = matrix[0].length;

        //multidimensional arraylist
        ArrayList<ArrayList<Integer>> zeroPairs = new ArrayList<ArrayList<Integer>>();
        //chose arraylist since it is mutable, and there is no guarenteed how many zeros we will find

        //traverses the list and finds the zero pairs
        for (int i = 0; i < rows; i++) {
            //traverses rows
            for (int j = 0; j < columns; j++) {
                //traverses columns
                int current = matrix[i][j];
                if (current == 0) {
                    
                    zeroPairs.add( new ArrayList<Integer>(Arrays.asList(i,j) ) ); //adds the pair of where the zero was found to the zero pair
                    //since the multidimensionsal arraylist is an arraylist of arraylists
                    //you have to add an integer arraylist to the end of the integer arraylists
                }
            }
        }

        System.out.println(zeroPairs); //prints the contents of the multidimensional arraylists

        for (int i = 0; i < zeroPairs.size(); i++) {
            

            ArrayList<Integer> pair = zeroPairs.get(i); //gets the pair at index i &&sets a variable for the pair
            System.out.print("\ncurrent pair:" + pair);

            int row = pair.get(0); //gets the first index of the pair which is the x value or row of the element
            int col = pair.get(1); //gets the col from the second index of the pair

             System.out.print("\npair found = (" + row + "," + col+ ")\n" );

             //calls the replaceZeros method with the correct pairs
            replaceZeros(row, col, matrix, rows, columns); 
        }



    }

    //method to replace all zeros around given coordinates of found zero (row,column)
    //parameters are the coordinates of the found zero, and the matrix to edit
    public static void replaceZeros(int x, int y, int[][] matrix, int rows, int columns) {
        // given pair is (x,y) or (i,j) i just didnt want it to interfere with a for loop

        //change all above
        //change all above current pair to zeros (-1, 0)
        // do row-1 until current row = 0
        for (int i = x-1; i >= 0; i--) {
            //i=x-1 since it will start one row above the given row
            //will only procede in the for loop if i is greater than or equal to zero
            //starts the row at the row of the given number
            //sets current element to zero until it reaches the first row
            matrix[i][y] = 0; //sets the above to zero
        }

        //change all right to zeros
        //(0,+1) until reaches last column
        for (int i = y +1; i <= columns -1; i++) {
            //columns -1 since index of columns is 0,1,2 for 3 size column

            matrix[x][i] = 0; //sets the next column to zero
        }

        //goes down
        //(+1,0) until reaches last row
        for (int i = x+1; i <= rows-1; i++) {
            //rows -1 since a matrix with 3 rows will have row 0,1,2
            //x+1 since we will look ahead one row since given pair is already zero
            matrix[i][y] = 0;
        }

        //change all left to zero
        //(0,-1) until reaches first column (column 0)
        for (int i = y -1; i >= 0 ; i--) {
            //y-1 since we will look at the column to the left of the found pair
            //runns as long as the current column is greater than or equal to zero
            //-1 to the column each loop

            matrix[x][i] = 0; //sets the next column to zero
        }


    }

}

