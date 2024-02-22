
/*
 * You are given a string s and an integer k. you can choose any character of the string and change it to any other uppercase english character
 * you can change any character like this 2 times
 * 
 * return the length of the longest substring contating the same letter you can get after performing these operations
 * 
 * 
 * Solution:
 * use sliding window to go block by block
 * instead this time we can ignore current char being in set up to k times
 * 
 * ex:
 * 
 * ABAB
 * when we get to B, we see it is not in the set, so we check if we have used k yet, if not 
 * 
 * 
 * 
 * for length of string 
 * 
 * if rightpointer != char at left pointer && allowed excuses = 0
 *  then we iterate the left pointer until we reach the first char not equal to the original left pointer
 *  reset allowed freebies = k
 * if thing at right pointer is not duplicat
 *  allowed freebies -1
 * else 
 * the thing at the right pointer is a duplicate
 * update max length 
 * move right pointer over one
 * 
 * 
 */

import java.util.HashMap;
import java.util.*;

public class longestrepeatingchar {
    public static void main(String[] args) {
        
        System.out.println(characterReplacement("ABBB", 2) + " should be 4");
        System.out.println(characterReplacement("ABAB", 2) + " should be 4");
        System.out.println(characterReplacement("AABABBA", 1) + " should be 4");
        
    }

    public static int characterReplacement(String s, int k) {
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>(); //map to store the frequency of a character
        int leftpointer = 0;
        int maxfreq = 0;

        for (int rightpointer =0; rightpointer< s.length(); rightpointer++) {
            Character c = s.charAt(rightpointer);

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
            // # of chars that are not the most frequent should be <= k
            //if it is not, we need to move the left pointer to the right, and decrement the frequency of the character at the left pointer by 1
            //move the current block to the right
            if ((rightpointer - leftpointer + 1) - maxfreq > k) {
                //move the left pointer to the right
                map.put(s.charAt(leftpointer), map.get(s.charAt(leftpointer)) - 1); //decrement the frequency of the character at the left pointer by 1
                leftpointer++; //move the left pointer to the right
            }

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
