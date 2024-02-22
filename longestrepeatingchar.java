
/*
 * You are given a string s and an integer k. you can choose any character of the string and change it to any other uppercase english character
 * you can change any character like this 2 times
 * 
 * return the length of the longest substring contating the same letter you can get after performing these operations
 * 
 * 
 * Solution:
 * use sliding window to go block by block
 * get the max frequency of any character within the block
 * if the number of characters that are not the max frequency character is greater than k, move the left pointer to the right
 * (since this block can only replace k characters to match the most frequent character, if there are more than k characters that are not the most frequent
 * , we need to move the left pointer to the right since this block is invalid)
 * 
 * we can store the frequency of every letter in a map, worst case we are given a string of 26 characters
 * so O(26) = O(1) still constant time
 * 
 * we iterate over the string once using the rightpointer, we stop when we can no longer increment the right pointer so O(n) runtime
 * 
 */

import java.util.HashMap;
import java.util.*;

public class longestrepeatingchar {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABBAABB", 2) + " should be 6");
        System.out.println(characterReplacement("ABBB", 2) + " should be 4");
        System.out.println(characterReplacement("ABAB", 2) + " should be 4");
        System.out.println(characterReplacement("AABABBA", 1) + " should be 4");
        
        
    }

    public static int characterReplacement(String s, int k) {
        int longest = 0; //keep track of the longest substring
        Map<Character, Integer> map = new HashMap<>(); //map to store the frequency of a character
        int leftpointer = 0; //left pointer to keep track of the start of the current block
        int maxfreq = 0; //keep track of the max frequency of any character in the current block

        for (int rightpointer =0; rightpointer< s.length(); rightpointer++) {
            Character c = s.charAt(rightpointer); //get the character at the right pointer

            //if the character at the right pointer exists in the map
            if (map.containsKey(c)) {
                map.put(c, map.get(c) +1); //increment the frequency by 1
            }
            //character does not exist in the map
            else {
                map.put(c, 1); //add the character to the map with a frequency of 1
            }

            maxfreq = getMaxFreq(map); //get the max frequency of any character in the map

            //if the length of the current block - the max frequency of any character in the block is greater than k
            //length of block - max frequency of any character in the block = number of characters that are not the max frequency character
            // # of chars that are not the most frequent in current block should be <= k
            //if it is not, we need to move the left pointer to the right, and decrement the frequency of the character at the left pointer by 1
            //move the current block to the right, continue testing the current block
            if ((rightpointer - leftpointer + 1) - maxfreq > k) {
                //move the left pointer to the right
                map.put(s.charAt(leftpointer), map.get(s.charAt(leftpointer)) - 1); //decrement the frequency of the character at the left pointer by 1
                leftpointer++; //move the left pointer to the right
            }

            //the block is valid, does not break the k rule
            else {
                //update the longest substring length
                longest = Math.max(longest, rightpointer - leftpointer + 1);
            }
        }
        return longest;
    }

    //iterate over the map, return the max frequency of any character
    //alphabet is max 26 characters so O(26) = O(1)
    public static int getMaxFreq(Map<Character, Integer> map) {
        Iterator<Map.Entry<Character, Integer>> mapIterator = map.entrySet().iterator();
        int maxfreq = 0;
        // Iterate over the map
        while (mapIterator.hasNext()) {
            int freq = mapIterator.next().getValue();

           maxfreq = Math.max(maxfreq, freq);
            // Process the entry
        }
        return maxfreq;
    }

}
