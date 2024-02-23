/*
 * given a string s, return the longest palindromic substring in s
 * 
 * palindrome - A string is palindromic if it reads the same forward and backward.
 * 
 * s = "babad" substring = "bab"
 * 
 */

import java.util.HashSet;
import java.util.*;

public class longestpalindromesubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb") + " should be bb");
        System.out.println(longestPalindrome("babad") + " should be bab or aba");
        System.out.println(longestPalindrome("cbbd") + " should be bb");
        System.out.println(longestPalindrome("a") + " should be a");
        System.out.println(longestPalindrome("ac") + " should be a");
    }
    public static String longestPalindrome(String s) {

        int longest = 0;
        int leftpointer = 0;
        String longestStr = "";
        String subString = "";
        Set<String> set = new HashSet<>(); 

        if (s.length() == 1) {
            return s;
        }

        for (int rightpointer =0; rightpointer <s.length(); rightpointer++ ) {
            subString = s.substring(leftpointer, rightpointer+1); //make a substring of current block
            int templeft = leftpointer;
            //while it is not a palindrome iterate the left pointer 
            while (ispalindrome(s.substring(templeft,rightpointer)) == false  && leftpointer < rightpointer) {
                templeft++;
                subString = s.substring(templeft,rightpointer+1);
            }

            if (set.contains(subString) == false || ispalindrome(subString) ) {
                
                 set.add(subString); //add the string to the set of valid palindromes
                    
                //if the substring that is a palindrome is the longest we have seen
                if (subString.length() > longest) {
                        longestStr = subString;
                        longest = subString.length();
                }
                    
               
            }
           

        }

        return longestStr;
    
    }

    public static boolean ispalindrome(String s) {
        s.toLowerCase(); //convert to lowercase so all same char val
        char[] strarr = s.toCharArray(); 

        //similar to having 1 pointer point to start and 1 pointer point to the end
        //compare first char to last to see if equal
        for (int i = 0;i < s.length()/2; i++) {
            Character first = strarr[i];
            Character last = strarr[s.length()-i-1]; //-1 to account for size 3 being index [0,1,2]
            if(first != last) {
                return false;
            }

        }
        //did not find any bad pairs
        return true;
    }
}
