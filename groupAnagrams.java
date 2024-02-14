import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class groupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        //given an array of strings group the anagrams together
        
        List<List<String>> result = new ArrayList<>(); //an arraylist of arraylists of strings, each element is an array of strings 

        //for each string check if it is an anagram of another string

        for (int i = 0; i < strs.length; i++) {
            List<String> anagramsOfStringI = new ArrayList<>(); //create a new arraylist of strings to store the anagrams
            anagramsOfStringI.add(strs[i]); //add the current string to the arraylist

            //check every other string in the list of strings to see if it is an anagram of the current string
            for (int j = i + 1; j < strs.length; j++) {
                //if the strings are anagrams, add them to the same arraylist
                if (isAnagram(strs[i], strs[j])) { //check if the two strings are anagrams
                    
                    anagramsOfStringI.add(strs[j]); //add the anagram to the arraylist
                    
                }
            }
            result.add(anagramsOfStringI); //add the arraylist of anagrams to the result arraylist
        }

        return result;
        
    }


    //using a hash tablem O(n) time complexity, since we iterate through the strings once, then iterate through the hash table once (2n = O(n))
    public static boolean isAnagram(String s, String t) {
      Map<Character, Integer> count = new HashMap<>(); //create a hashmap, (character, integer)

         // Count the frequency of characters in string s
         for (char x : s.toCharArray()) {
            if (count.containsKey(x)) {
                count.put(x, count.get(x) + 1); //if the character is already in the map, increment the value by 1
            } else {
                count.put(x, 1); //if the character is not in the map, add it to the map with a value of 1
            }
        }
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            if (count.containsKey(x)) {
                count.put(x, count.get(x) - 1); //if the character is already in the map, decrement the value by 1
            } else {
                return false; //if the character is not in the map, return false, not anagram
            }
        }

        // Check if any character has non-zero frequency, if so then there was not an equal number of characters in both strings
        for (int val : count.values()) {
            //if the value is not 0, then the strings are not anagrams, unequal number of characters
            if (val != 0) {
                return false;
            }
        }
        
        //reached here, then the strings are anagrams
        return true;

    }
}