import java.util.*;

public class getKclosest {
    /*
     * given an array of points where points[i] = [xi,yi] represents a point on the X-Y plane and an integer k,
     * return the k closest points to the origin (0,0).
     * 
     * the distance between two points on the x-y plane is the euclidean distance (i.e., sqrt((x1-x2)^2 + (y1-y2)^2)).
     * 
     * you may return the answer in any order. the answer is guaranteed to be unique (except for the order that it is in).
     * 
     * k = 1 means get the closest point to the origin, smallest val
     * k = 2 means get the second closest point to the origin, 2nd smallest val
     * 
     * Solution:
     * iterate through the array, get the distance from origin, put in min heap in order of least distance (at the top)
     * iterate while i<k, startingi at 0
     * pop from minheap, get ith closest
     * add the coordinate to our return array
     * 
     * ex
     * k = 3 we want the 3 closest points 
     * 

     */
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(p -> p[0] * p[0] + p[1] * p[1]));
        //the comparator tells us how to compare the ints within our pair we give it 
        //PriorityQueue<>(Comparator.comparingInt(p -> p[0] * p[0] + p[1] * p[1]) defines the comparator for our min heap
        // p[0] * p[0] + p[1] * p[1] gets the distance from the int[] = [x,y], so we are sorting by distance in our min heap

        //iterate through the given array, add the points to the minheap
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0]; //row i, get the x value
            int y = points[i][1]; // row i get the y value
            int[] coord = {x, y};
            minheap.offer(coord);
        }
        int[][] returnArray = new int[k][]; //declare a multidimensional array to return

        //iterate k times, popping the min value from the minheap, and adding to our return array
        for (int i = 0; i < k; i++) {
            returnArray[i] = minheap.poll(); // Get and remove the closest to origin
        }

        return returnArray; // Return the populated returnArray

    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int kval = 1;
        int[][] result = kClosest(points, kval);
        
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }


}
