import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class permutations {
    List<List<Integer>> result = new ArrayList<>(); //initialize the result list, 
    //outside of the function so that it can be accessed by all functions

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList(); //create a new integer arraylist so we can use the remove and add functions
        for(int num: nums){ //add all the numbers from the input array to the new arraylist
            numsList.add(num);
        }

        List<Integer> subList = new ArrayList(); //create a new integer arraylist so we can use the remove and add functions
        backtrack(numsList, subList); //call the backtrack function
        return result; //return the result list
    }

    public void backtrack(List<Integer> numsList, List<Integer> subList){
        if(numsList.isEmpty()){ //if the numsList is empty, add the subList to the result list
            result.add(new ArrayList<>(subList)); //add a new arraylist with the same values as subList to the result list
        }

        //for each number in the numsList, remove it from the numsList, 
        //add it to the subList, call the backtrack function, then add it back to the numsList and remove it from the subList
        for(int i = 0; i < numsList.size(); i++){
            Integer temp = numsList.get(i); //get the number at index i
            subList.add(temp); //add the number to the subList
            numsList.remove(i); //remove the number from the numsList
            backtrack(numsList,subList); //call the backtrack function
            numsList.add(i, temp); //add the number back to the numsList
            subList.remove(temp); //remove the number from the subList
        }
    }

    public static void main(String[] args) {
        permutations p = new permutations();
        int[] nums = {1,2,3};
        System.out.println(p.permute(nums));
    }

}
