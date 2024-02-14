import java.util.HashMap;
import java.util.Map;

class containsduplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        //could brute force and compare each element to every other element in the array using 2 for loops (bad runtime)
        //or use a hash table to store all the elements in the array and see if the element already exists in the hash table

        Map<Integer, Integer> map = new HashMap<>(); //create hashmap

        for (int i = 0; i< nums.length ; i++) {
            //check if the element already exists in the hash table
            if (map.containsKey(nums[i])) { //if the hash table contains the element
                return true; //found a duplicate
                        }
                //else add it to the map
                map.put(nums[i], i); //put the element and its index into the hash table (element, index)
            }
        
            return false; //did not find any duplicates 
        }
    }

