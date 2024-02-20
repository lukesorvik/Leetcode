import java.util.*;

public class permutations2 {

   
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); //initialize the result list, 

        recursive(result, nums, 0);
        return result; //return the result list

    }

    public static void recursive(List<List<Integer>> result, int[] nums, int start){
        if (start == nums.length){ 
            List<Integer> list = new ArrayList<>();

            for (int num: nums){
                list.add(num);
            }
            result.add(list);
            return;
        }

        //iterate through the given nums aray, swapping the start index with each index
        for (int i = start; i < nums.length; i++){
            swap(nums, start, i);
            recursive(result, nums, start + 1); //call the recursive function with the start index incremented by 1
            swap(nums, start, i);
        }

    }

    //swap function, to swap the values at index a and b in the array arr
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }





    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

}


