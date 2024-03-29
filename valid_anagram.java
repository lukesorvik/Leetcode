import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class valid_anagram {

    //using sorting, O(nlogn) time complexity, due to java's sort method being O(nlogn)
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char schars[] = s.toCharArray();
        char tchars[] = t.toCharArray();

        Arrays.sort(schars);
        Arrays.sort(tchars);

        for (int i = 0; i < schars.length; i++) {
            if (schars[i] != tchars[i]) {
                return false;
            }
        }

        return true;

        //sort the elements in both
        //compare if the characters are the same 
    }

    //using a hash tablem O(n) time complexity, since we iterate through the strings once, then iterate through the hash table once (2n = O(n))
    public boolean isAnagram(String s, String t) {
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