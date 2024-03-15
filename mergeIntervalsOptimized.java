import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervalsOptimized {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        //int[][] intervals = {{1,4},{4,5}};
        mergeintervals test = new mergeintervals();
        int[][] result = test.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

     public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); //sort the array, 
        // (a, b) -> a[0] - b[0] is a lamdda expression saying we sort the array based on the first element of each subarray [X,Y] where X is the first element
        //we do this to make comparing the ranges easier
        
        int totalIntervals = intervals.length;

        int intervalStart = intervals[0][0]; //point to the first element of the first range
        int intervalEnd = intervals[0][1]; //point to the second element of the first range

        List<int[]> mergedList = new ArrayList<>(); //arraylist to store the result

        for (int i = 1; i < totalIntervals; i++) {
            
            //if the Lower bound of this range is > the upperbound of the previous range, then we have a new range
            if (intervals[i][0] > intervalEnd) {
                mergedList.add(new int[] {intervalStart, intervalEnd}); //add the previous range to the result
                
                intervalStart = intervals[i][0]; //update the start of the new range
                intervalEnd = intervals[i][1]; //update the end of the new range
            } else { //if the lower bound of this range is <= the upperbound of the previous range, then we have an overlapping range
                intervalEnd = Math.max(intervalEnd, intervals[i][1]); //update the end of the range to the max of the two ranges
                //no need to update the lower bound since we are assuming the array is sorted
                //if we only update upper bounds, then the intervalStart will always be lowest range
            }
        }
        //once the loop is done, we need to add the last range to the result
        //this is because each loop iteration only adds the previous range to the result
        mergedList.add(new int[] {intervalStart, intervalEnd}); //add the last range to the result
        
        return mergedList.toArray(new int[mergedList.size()][]); //convert the arraylist to a multidemnsional array and return
    }
}
