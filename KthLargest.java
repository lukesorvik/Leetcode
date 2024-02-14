import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * since we want the kth largest element (the kth element from the largest)
 * [2,4,5,8] k = 3, the 3rd largest element is 4
 * if we want the kth smallest element, we would use a min heap
 * we keep the size of the heap to k, so the top of the heap is always the kth largest element
 * 
 * add()
 * O(logn)-add the element to the heap
 * O(logn)-if the size of the heap is greater than k, remove the smallest element from the heap 
 *  since the smallest element when heap.size > k will not be the kth largest element
 * suppose we do add(2) [2,4,5,8] k = 3, the 3rd largest element is 4 it will never be 2
 * O(1)-return the minimum element from the heap, which is the kth largest element 
 * 
 * worst case runtime O((n-k)2logn) since we add the element to the heap until it is of size k
 * then once the heap is of size k, we remove the smallest element from the heap, worst case all n-k elements 
 * are smaller than the kth largest element
 * 
 * 
 */



class KthLargest {
    PriorityQueue<Integer> heap; //min heap, the smallest element is at the top
    //if wanted max heap we could do  PriorityQueue<>(10, Collections.reverseOrder()); so that peek will return the largest element
    int k; //the kth largest element


    //constructor method to heapify the array of nums 
    public KthLargest(int k, int[] nums) {
        this.k = k; //the kth largest element to find
        heap = new PriorityQueue<>(); //create a new min heap
        for (int num : nums) { //for each element in the array of nums
            add(num); //add the element to the heap, using the add method and not the heap add method
        }
    }
    
    //add the value to the heap, return the kth largest element
    public int add(int val) {
        heap.offer(val); //add the element to the priority queue
        //heap.offer will not throw an exception if the heap is full, whereas heap.add will throw an exception

        System.out.println(Arrays.toString(heap.toArray()));
        if (heap.size() > k) { //if the size of the heap is greater than k
            //need to remove b
            heap.poll(); //removes the smallest element from the heap, heap of min heap
            //o(nlogn) time complexity, as the heap is re-heapified (re-ordered) after the smallest element is removed
        }

        System.out.println(Arrays.toString(heap.toArray()));
        //K < heap.size() 
        return heap.peek(); //return the kth largest element, do not remove
    }
}


class Main {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println("heap before" + Arrays.toString( kthLargest.heap.toArray()) +"\n"); //print the heap
        System.out.println("\n add 3");
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println("\n add 5 ");
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println("\n add 10 ");
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println("\n add 9 ");
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println("\n add 4 ");
        System.out.println(kthLargest.add(4));   // returns 8
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */