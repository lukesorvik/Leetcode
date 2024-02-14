import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");





        int[][] threebythree =  { {1,2,3} ,{4,5,6} , {7,8,9} } ;
        //each {} is a row and each element in {x,x,x} is a column

        System.out.println("\ninput matrix: ");
        print(threebythree);
        List<Integer> result = Solution.spiralOrder(threebythree);
        System.out.println("\nspiral order is: \n" + result);
        


    }


    public static void print(int[][] arr)     {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
 
            System.out.println();
        }
    }

}



class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        

        List<Integer> result = new ArrayList<>();

        

        int rows = matrix.length;
        int cols = matrix[0].length; //number of columns is the number of elements in first row

        int left = 0;
        int right = cols-1;
        int bottom = rows-1;
        int top = 0;



        while (left <= right && top <= bottom) {
            //runs as long as left is less than or equal to right value
            //where left is first colum, and right is last column
            //and runs as long as top is less than bottom
            //where top is first row and bottom is last row


            //adding from topleft to topright
            for (int i = left; i <= right; i++) {
                //starts at first column(left) and goes till last column(right)

                result.add(matrix[top][i]);
                //adds the current column[i] from the first row
                //only adds from the top row
            }
            top++; //adds one to the top, meaning next time it will start one row down

            //adding from topright to botright
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
                //adds the current row[i] and last column to list
                //goes until reaches bottom
                //so adds from topright of matrix to bottomright
            }
            right--; //subtracts one from right, meaning the lastcolumn-1, so it will add one less from right next time

            if (top <= bottom) {
                //if the top is less than or equal to the bottom
                //does not run if top is more than bottom (meaning went past)

                //moving botright to botleft
                for (int i = right; i >= left; i--) {
                    //iterates backwords to add from right
                    //starts at last col(right) adds until fist col(left)
                    //runs as long as the right is greaterthan or equal to the left (until reaches first column)

                    result.add(matrix[bottom][i]);
                    //adds the element from last row[bottom] and the current column[i]

                }
                bottom--; //subtracts lastrow-1 meaning the new bottom is one row up
            }

            if (left <= right) {
                //runs as long as the first column(left) is less than the right
                
                
                //moving botleft to topleft
                for (int i = bottom; i >= top; i--) {
                    //iterates backwords to add upwards
                    //starts at last row(bottom) ends at first row(top)

                    result.add(matrix[i][left]);
                    //adds the element from the bottom[i] and the leftmost column(left)

                }
                left++; //increase the left value to mean it is moving one to the right
                //so that next loop will do the next column
            }
    



        }

        return result;


        



    }
}