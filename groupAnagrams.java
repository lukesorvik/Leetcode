import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class groupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> mapStrings = new HashMap<>(); //create hashmap of (string, integer), string is the key, int is the group number
        List<List<String>> ans = new ArrayList<>(); //create a list of lists of strings, each element is a list of strings

        //for each string in the array of strings
        //sort the string, then add it to the hashmap with the index of the list of strings that are anagrams of each other
        //if the hashmap already contains the sorted string, then add the string to the list of strings at the index of the group number(same anagram group)
        for (String str : strs) {
            char[] chars = str.toCharArray(); //convert the string to a character array
            Arrays.sort(chars); //sort the character array using java's sort method
            String sortedStr = new String(chars); //convert the sorted character array back to a string
            

            if (mapStrings.containsKey(sortedStr)) { //if the hashmap contains the sorted string
                ans.get(mapStrings.get(sortedStr)).add(str); 
                //add the string to the list of strings at the index of the group number
                //mapstrings.get geths the group number of the sorted string (group number is the index of the list of strings)
            } else {
                //if the hashmap does not contain the sorted string
                mapStrings.put(sortedStr, ans.size()); //put the sorted string into the hashmap with the group number
                //if the answer has nothing in it, then its group number is 0, if it has 1 element, then its group number is 1, etc 
                //each group number is the index of the list of strings
                ans.add(new ArrayList<>(Arrays.asList(str)));
            }
        }

        return ans;
        
    }


}