public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");



        int[][] moves =  { {0,0} ,{2,0} ,{1,1}, {2,1}, {2,2}};
        //an array of arrays
        //multidimensional array
        //a matrix or table

        String a = Solution.tictactoe(moves);
        System.out.println(a);

    }   
}




class Solution {
    public static String tictactoe(int[][] moves) {
        
        char[][] arr = new char[3][3]; //creates a 3 by 3 matrix that stores characters
        // char[array][index of array]
        //char[0] = row 0
        //char [0][0] = row 0 column 0

        for (int i = 0; i < moves.length ; i++) {
            //i=0 first move [0,0]
            //move = [row, column]
            int row = moves[i][0]; //since accessing move #1 will get index 0 of move one which is the row
            int column = moves[i][1]; //still accessing first move but will get index 1 which is the column

            Character symbol = 'O'; //default to O

            if (i % 2 == 0) {
                //if the current move # is even, then it is x's move
                symbol = 'X';
            }

            arr[row][column] = symbol ;
            //adds either X or O to the specified row and collumn


        }
        

        //prints the current multidimensional array for debugging
        print(arr);
        //yes it did successfully store the tictactoe data into the array
        //now just need a way to check for winners and it is done



        //check rows and columns to see if 3 x's


        //checks for x's
        //iterates i 3 times, does this to check each row and each column
        for (int i = 0; i < 3 ; i++) {
            //i loops over rows

            //checks the first row when i = 0
            if(arr[i][0] == 'X' && arr[i][1] == 'X' && arr[i][2] == 'X' ) {
                //if a row is all x's
                return "A";
            }

            //checks the first column when i = 0
            if(arr[0][i] == 'X' && arr[1][i] == 'X' && arr[2][i] == 'X' ) {
                //if a row is all x's
                return "A";
            }

        }

        //now check both diagonals for x [0,0] [1,1] [2,2]
        //other diagonal [0,2][1,1][2,0]
         if(arr[2][0] == 'X' && arr[1][1] == 'X' && arr[0][2] == 'X' ) {
                //if diagonal 1 is all x's
                return "A";
            }
        if(arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X' ) {
                //if diagonal 1 is all x's
                return "A";
            }




        //checks for O
        //could make a function with parameter being (O, B) to change what to return and what to check for
        for (int i = 0; i < 3 ; i++) {
            //i loops over rows

            //checks the first row when i = 0
            if(arr[i][0] == 'O' && arr[i][1] == 'O' && arr[i][2] == 'O' ) {
                //if a row is all x's
                return "B";
            }

            //checks the first column when i = 0
            if(arr[0][i] == 'O' && arr[1][i] == 'O' && arr[2][i] == 'O' ) {
                //if a row is all x's
                return "B";
            }

        }
        //checks first diagonal for O
         if(arr[2][0] == 'O' && arr[1][1] == 'O' && arr[0][2] == 'O' ) {
                //if diagonal 1 is all x's
                return "B";
            }
        if(arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O' ) {
                //if diagonal 1 is all x's
                return "B";
            }


        //reaches this point if no valid winners


        //if all of board is filled and no winners then draw
        //if not then return pending(ie still waiting for moves)

        //if moves.length is less than 9 (enoguh to fill the board return pending)
        if (moves.length < 9) {
            return "Pending";

        }

        //didnt find any winners
        //enough moves to fill board
        return "Draw";
    }









    //method to print a multidimensional array
    public static void print(char[][] arr)     {


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
 
            System.out.println();
        }
    }



    
}


/*
 * how to:
 * iterate through the moves
 * if current i iteration is even add the corresponding move to x
 * if the i iteration is odd then do 0
 * since starts at 0 and x, 1 then o
 * 
 * add to the corresponding char matrix
 * 
 * then find a way to test for the winner
 * 
 */




/*
The rules of Tic-Tac-Toe are:

Players take turns placing characters into empty squares ' '.
The first player A always places 'X' characters, while the second player B always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never on filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.


given a 2d integer array moves[]
where moves[i] = [row1, col1] indicates that the i^th move will be played on grid[row1][col1]
-return the winner of the game if it exists(A or B). 
In case the game inds in a draw return "Draw"
If there are still movements to play return Pending



given an int[] array of int[] arrays
input moves

the grid is stored as a matrix [row, column]
int[] rows =



*/