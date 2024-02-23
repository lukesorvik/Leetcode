/*
 * given a string s, return the longest palindromic substring in s
 * 
 * palindrome - A string is palindromic if it reads the same forward and backward.
 * 
 * s = "babad" substring = "bab"
 * 
 */

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

        int maxLen = 0;
        String longestStr = "";
        String substring = "";
        //Set<String> set = new HashSet<>(); 

        //base case return self 
        if (s.length() == 1) {
            return s;
        }

        //iterate over every possible substring o(n^2), lp = left pointer, rp =right pointer
       for (int lp = 0; lp < s.length(); lp++) {
        //we add the maxlength since a bigger palindrome substring cannot end at indices <maxlen (since the substring must be bigger than the max)
            for (int rp = lp + maxLen; rp <= s.length(); rp++) {
                substring =  s.substring(lp, rp);
                //if the rightpointer j - leftpointer i > maxlength (then the substring if it is bigger than max palendrome)
                //if the substring is also a palindrome
                if (rp - lp > maxLen && ispalindrome(substring)) {
                    maxLen = substring.length(); //maxlength = length of substring (leftpointer- rightpointer)
                    longestStr = substring; //the maxstr = the substring
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
