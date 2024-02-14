import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String s = "anagram";
        String t = "nagaram";


         System.out.println(Solution.isAnagram(s,t));
    }
}




class Solution {
    public static boolean isAnagram(String s, String t) {
        /*
        hash table solution
        
        1. create an unordered map to store the character frequenceies. the key of the map represents a character, and the value represents its frequency
        2. iterate over each character in string s. for each character, increment its frequency in the count map
        3. iterate over each character in string t. for each character decrement its frequency in the count map
        4. iterate over each value in the count map. if any frequency is non-zero it means there is a character that appears more times in one string than
        the other, indicating the strings are not anagrams. In that case, return false.
        5. if all frequences in the count map are zero, it means the t strings contain the same characters the same amount of times, making them 
        anagrams. so return true

        */




        Map<Character, Integer> count = new HashMap<>();

        //iterates through each char is s string
        //count the frequency of the characters in string s
        for (char current : s.toCharArray()) {
            count.put(current, count.getOrDefault(current, 0) + 1);
            //puts the key,value into the map
            //where the value is the value of the current key +1 , and if no previous value it defaults to 0
            
        }

        //decrement the fequences of the characters in string t
        for (char current : t.toCharArray()) {
            count.put(current, count.getOrDefault(current, 0) - 1);
            //puts the key,value into the map
            //where the value is the value of the current key +1 , and if no previous value it defaults to 0
            
        }

        for (int val : count.values()) {
            //.values returns every value for every key in the map as a collection
            //so iterate over each value and if one is not == 0 then they are not anagrams
            if (val != 0) {
                return false;
            }

        }

        return true;



    }
}
