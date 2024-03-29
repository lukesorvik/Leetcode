import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.awt.Point;

public class islands {

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        
        System.out.println(numIslands(grid));
    }
    
    public static int numIslands(char[][] grid) {
        
        Set<Point> visited = new HashSet<>(); //create a set to store the visited coordinates
        //use Point class to store coordinate
        //we do not use int[] becuase java will reference the int[] object and not the values within the array
        int islands = 0; //initialize the number of islands to 0

        int rows = grid.length;
        int cols = grid[0].length;

        //for each coordinate in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Point coord = new Point(i,j);
                if (grid[i][j] == '1' && !visited.contains(coord)) { //if the coordinate is not visited and the value is 1
                    
                    bfs(grid, coord, visited, rows, cols); //this will visit all adjacent coordinates and mark them as visited
                    islands++; //increment the number of islands, we only do this once since we are visiting all adjacent coordinates
                    //cannot be more than 1 island
                }
                
            }
        }

        return islands;
        
    }

    //breadth first search
    //given the cordinate visit all adjacent coordinates recursively, and mark them as visited
    public static void bfs(char[][] grid, Point coord, Set<Point> visited, int rows, int cols) {
        Queue<Point> queue = new LinkedList<>(); //create a queue to store the coordinates 
        visited.add(coord); //add the current coordinate to the visited set
        queue.add(coord); //add the current coordinate to the queue

        //while the queue is not empty
        while (queue.isEmpty() == false) {
            Point current = queue.poll(); //remove the first element from the queue

            int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}}; //create an array of directions to move in


            for (int[] direction: directions) {

                Point newCoord = new Point((int)current.getX() + direction[0],(int) current.getY() + direction[1]); //new coordinate is the current coordinate plus the direction
                int x = (int) newCoord.getX();
                int y = (int) newCoord.getY();

                //if the new coordinate is within the bounds of the grid
               if (x >= 0 
               && x < rows 
               && y >= 0 
               && y < cols) {


                    //if the new coordinate is not visited and the value is 1
                   if (grid[x][y] == '1' && !visited.contains(newCoord)) {
                       visited.add(newCoord); //mark as visited
                       queue.add(newCoord); //add the new coordinate to the queue
                   }
               }

            }
        }
        

    }

    
}
