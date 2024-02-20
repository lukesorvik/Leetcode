import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * This solution treats the array [1,2,3] as an undirected graph
 * We use dfs to get all permutations
 * 
 * Solution:
 * iterate over the array
 * for each element in the array dfs
 *      dfs:
 *          -set current node as visited (arr[j]) by adding to hash
 *          -look for first unvisited neighbor
 *          -call dfs on that neighbor
 *          
 *          -base case: when the permutation reaches full length
 *          -backtrack: 
 *              -remove elements from visited, and the permutation
 * 
 * Ex: start with (1)
 * first we add 1 to the hashset, and the permutation
 * then we dfs(1)
 * we check 1's neighbor 1(self) in hashset so ignore
 * we check 1's neighbor 2, not in hashset so we
 * we add 2 to the hashset
 * we add 2 to the permutation
 * call dfs(2)
 * we check 2's neighbor 1, but it has been visited so we skip
 * we check 2's neighbor (self) but it is in hashset
 * we check 2's neighbor (3) not in set so we 
 * add 3 to set
 * add 3 to permutation
 * call dfs(3)
 * 
 * p= [1,2,3] so we return
 * 
 * on backtrack we remove 3 from the permutation and the hashset
 * p =[1,2]
 * h = [1,2]
 * 
 * then we remove 2 (since 2 has iterated 3 times)
 * p=[1]
 * h=[1]
 * 
 * Now we are back at dfs(1)
 * and j=2/ arr[j] =3
 * then we will go down the path
 * p = [1,3,2]
 * and backtrack similarly 
 *
 * 
 * If the number is not in the hashset,
 * it means it hasn't been used in the current permutation. 
 * We add it to the permutation list and mark it in the hashset.
 * 
 * We check whether the current number is already present in the hashset(visited). 
 * If it is, we skip the current iteration(continue) to avoid duplicate permutations.
 * 
 * 
 * time complexity: O(N * N!)
 * n = size of array, n! = all possible permutations
 * we iterate over the size of the array(n), then go through each possible permutation(n!) 
 */



public class permutations3dfs {
    public static void main(String[] args) {
       
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    
   static List<List<Integer>> result; 
   static List<Integer> permutation; 
   static HashSet<Integer> hashset;
    
   public static List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>(); 
        permutation = new ArrayList<>(); //a way to store the permutation
        hashset = new HashSet<>(); //hashset to store nodes we visit
        dfs(nums);
        return result;
    }

    public static  void dfs(int[] nums){
        if(permutation.size()==nums.length){ //if it is the size of a permutation
            result.add(new ArrayList<>(permutation)); //add the permutation to the answers
            return; 
        }

        for(int j=0; j<nums.length; j++){
            if(hashset.contains(nums[j])) { //check if we have already visited element nums[j] in this permutation
                continue; //if the array has already been visited, do not recursively calls
            } 
            

            permutation.add((Integer)nums[j]); //add the valid element to the permutation
            hashset.add((Integer)nums[j]); //add the element to the hashset of visited numbers

            dfs(nums); //call recursively on valid element


            //backtracking
            //after we reached a base case

            permutation.remove((Integer)nums[j]); //remove the current nums[j] we used for the permutation 
            hashset.remove((Integer)nums[j]); //remove the current nums[j] we used for the permutations
            //(so we dont add the same element twice to the permutation)
            
        }
        return;
    }
    
}
