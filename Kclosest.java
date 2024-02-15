import java.util.*;

public class Kclosest {
    /*
     * given an array of points where points[i] = [xi,yi] represents a point on the X-Y plane and an integer k,
     * return the k closest points to the origin (0,0).
     * 
     * the distance between two points on the x-y plane is the euclidean distance (i.e., sqrt((x1-x2)^2 + (y1-y2)^2)).
     * 
     * you may return the answer in any order. the answer is guaranteed to be unique (except for the order that it is in).
     * 
     * k = 1 means get the closest point to the origin, smallest val
     * k = 2 means get the second closest point to the origin, 2nd smalled val
     * 
     * Solution:
     * iterate through the array, get the distance from origin, put in min heap in order of least distance (at the top)
     * if we do a min heap, then the kth closest will always be at the top
     * 
     * ex
     * k = 3 we want the 3 closest points 
     * 
     * 
     * this code works except when we have a collision in the hashmap, when two points have the same distance.
     * maybe fix with if the key exists in the hashmap do x?
     */
    public int[][] kClosest(int[][] points, int k) {
        //int[][] result  = [1,2][3,4], etc
        PriorityQueue<Double> minheap = new PriorityQueue<>(); //priority queue to get the min distance 
        Map<Double, int[]> hashmap = new HashMap<>(); //hashmap to store the (distance, coordinate associated)

        //get the distances from origin
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0]; //row i, get the x value
            int y = points[i][1]; // row i get the y value
            double distance = Math.sqrt(((x*x) + (y*y))) ; //since we are comparing to origin (0,0) the distance formula become simplified
            minheap.add(distance);
            int[] coord = {x,y};
            hashmap.put(distance, coord );
            //how to associate the coordinate with the distance?
            //maybe map the distance to a hashmap to get the coords?
        }
        int[][] returnArray = new int[k][]; // Declare and initialize the returnArray variable properly

        for (int i = 0; i < k; i++) {
            double key = minheap.poll(); // Get and remove the closest to origin
            int[] coord = hashmap.get(key); // Get the associated coordinate
            returnArray[i] = coord; // Assign the coord array to the correct index in the returnArray array
        }

        return returnArray; // Return the populated returnArray

    }


}
