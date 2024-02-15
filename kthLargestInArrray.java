import java.util.Collections;
import java.util.PriorityQueue;

public class kthLargestInArrray {


    /*
     * Ex: [3,2,1,5,6,4] k= 2
     * we sort in descending order [6,5,4,3,2,1] and return 5, or index k=2-1
     * 
     * we could use a sorting algorithim like quick sort or merge sort
     * I'm going to use a heap sort using max heap
     * 
     * Runtime: O(nlogn)
     * Space complexity: 
     * O(logn) if recursive, for each level of tree
     * O(1) if iterative
     * 
     * 
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(10, Collections.reverseOrder()); //create max heap

        //iterate through each integer in our given array
        for (int x: nums) {
            maxheap.offer(x); //add the integer to the heap
        }
        int kthLargest =0;

        //iterate through the heap, pop the max element, do this k times (last one popped should be the kth greatest)
        for (int i = 0; i < k; i++) {
            kthLargest = maxheap.poll(); //pop the max element

        }
        return kthLargest;

    }
}
