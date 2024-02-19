import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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
        
        Set<int[]> visited = new HashSet<>(); //create a set to store the visited coordinates
        int islands = 0; //initialize the number of islands to 0

        int rows = grid.length;
        int cols = grid[0].length;

        //for each coordinate in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int[] coord = {i, j};
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
    public static void bfs(char[][] grid, int[] coord, Set<int[]> visited, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>(); //create a queue to store the coordinates 
        visited.add(coord); //add the current coordinate to the visited set
        queue.add(coord); //add the current coordinate to the queue

        //while the queue is not empty
        while (queue.isEmpty() == false) {
            int[] current = queue.poll(); //remove the first element from the queue

            int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}}; //create an array of directions to move in

            for (int[] direction: directions) {

                int[] newCoord = {current[0] + direction[0], current[1] + direction[1]}; //new coordinate is the current coordinate plus the direction

                //if the new coordinate is within the bounds of the grid
               if (newCoord[0] >= 0 
               && newCoord[0] < rows 
               && newCoord[1] >= 0 
               && newCoord[1] < cols) {

                   int x1 = newCoord[0];
                    int y1 = newCoord[1];

                    //if the new coordinate is not visited and the value is 1
                   if (grid[x1][y1] == '1' && !visited.contains(newCoord)) {
                       visited.add(newCoord); //mark as visited
                       queue.add(newCoord); //add the new coordinate to the queue
                   }
               }

            }
        }
        

    }

    
}
