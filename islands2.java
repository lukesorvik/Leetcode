import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.awt.Point;

public class islands2 {

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        int islands = 0; // initialize the number of islands to 0

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] visited = new int[rows][cols]; // create a set to store the visited coordinates, use any array, set = 1 if visited, 0 if not
        //we treat this as a 2d array of booleans, but we use 1 and 0 instead of true and false
        //we do this over using a set because a set does not work well with arrays (it only checks for the object instance and not the values within the array)

        // for each coordinate in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && visited[i][j] != 1) { // if the coordinate is not visited and the value is 1

                    dfs(grid, i, j, visited, rows, cols); // this will visit all adjacent coordinates and mark them as
                                                          // visited
                    islands++; // increment the number of islands, we only do this once since we are visiting all adjacent coordinates
                    // cannot be more than 1 island
                }

            }
        }

        return islands;

    }

    // depth first search
    //recursively search the deepest island coordinate (first in (0,1) direction, then (0,-1), then (1,0), then (-1,0)
    //stop when out of bounds, or if the coordinate is visited, or if the coordinate is 0 (not an island)
    public static void dfs(char[][] grid, int x, int y, int[][] visited, int rows, int cols) {
        // instead of a queue we use recursion

        // if the new coordinate is within the bounds of the grid, or if the coordinate is visited, or if the coordinate is 0 return null
        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] == 1 || grid[x][y] == '0') {
            return;
        }

        visited[x][y] = 1; // mark as visited

        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // create an array of directions to move in

        for (int[] direction : directions) { //for each direction

            int newx = x + direction[0];
            int newy = y + direction[1];

            dfs(grid, newx, newy, visited, rows, cols); //recursively search using the new coordinate

        }

    }

}
