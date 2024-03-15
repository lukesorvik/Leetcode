
/*
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 


ideas:?
brute force:
keep a map of starting ranges and the index of their array [j][] <starting range, index>
map of ending ranges and the index of their array [j][] <ending range, index>
for each array j [j][i]
    for each element i
        check if arr[j][i=0] (lowrange) exists in map (if so then dupe range in list )

idea 2, 2 pointers
keep track of current longest lowest bound, and upperbound, when in range, update, when not add to output update new current ub and lb

maybe sort the array? idk if guarentee
current lower bound = arr[0][0]
current upperbound= arr[0][1]

for each array j arr[j][i]
    int thisLB = arr[j][0]
    int this UB = arr[j][1]

    //if this.ub greater than old ub
    check if current lb and this arr[j][0] up in range
    if LB <= this UB && ub <= thisUB && LB <= this.ub {
        ub = this.ub
    }
    //if this.lb lower than the old lb, but still in range
    if thislb < lb && thisub <= ub  &&  lb <= this.ub 
        lb = this.lb

    //neither cases were true
    if lb > this.ub || ub < this.lb {
        update since it is a new range 
    }




    
 */

import java.util.Arrays;
import java.util.Comparator;

public class mergeintervals {
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
        int[][] result = new int[intervals.length][2]; //initialize result array
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]) ); //sort the array

        //List<int[]> list = new ArrayList<>(); //arraylist to store the result

        int prevLB = intervals[0][0];
        int prevUB= intervals[0][1];
        int outputIndex = 0;

        for (int j = 0; j < intervals.length; j++) {
            int thisLB = intervals[j][0];
            int thisUB = intervals[j][1];

            if (thisLB <= prevUB ) {
                prevLB = Math.min(thisLB, prevLB);
                if (thisUB > prevUB) {
                    prevUB = Math.max(prevUB, thisUB);
                }
                //if at last element in the array, add the last range to the result
                if(j == intervals.length - 1) {
                    int[] range = {prevLB, prevUB};
                    result[outputIndex] = range;
                }
            }

            //ranges do not overlap , add last range to result, update prevLB and prevUB to current range
            else if (thisLB >= prevUB) {
                //add old range to result
                int[] range = {prevLB, prevUB};
                result[outputIndex] = range;
                outputIndex++;
                //update prevLB and prevUB to current range
                prevLB = thisLB;
                prevUB = thisUB;
                //if at last element in the array, add the last range to the result
                if(j == intervals.length - 1) {
                    int[] range2 = {thisLB, thisUB};
                    result[outputIndex] = range2;
                 }
            }
            
            
            
        }


            return result;
    }
}
