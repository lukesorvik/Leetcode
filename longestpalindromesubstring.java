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
        //System.out.println(longestPalindrome("bb") + " should be bb");
        //System.out.println(longestPalindrome("babad") + " should be bab or aba");
        System.out.println(longestPalindrome("cbbd") + " should be bb");
        System.out.println(longestPalindrome("a") + " should be a");
        System.out.println(longestPalindrome("ac") + " should be a");
    }
    public static String longestPalindrome(String s) {
        //base case just one char
        if (s.length() <= 1) {
            return s;
        }

        //java .subtring is not inclusive for end bound
        String maxStr = s.substring(0, 1); //max string we have seen so far, default set to "a", from index 0 to 0


        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandFromCenter(s, i, i); //get the odd string
            String even = expandFromCenter(s, i, i + 1); //get the even

            if (odd.length() > maxStr.length()) { //if the odd length is bigger than the max
                maxStr = odd;
            }
            if (even.length() > maxStr.length()) { //if the even length is bigger than the max
                maxStr = even;
            }
        }

        return maxStr; //update return string
    }

    private static String expandFromCenter(String s, int left, int right) {
        //while left & right are in bounds, and the char at left & right are valid palindromes (same), continue search 
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            String debug = s.substring(left, right);
            left--;
            right++;
        }
        //loop will end with left -1 that it should be and right +1 than it should be!, substring(left,right) right is exclusive so it dont matter
        //max palindrome found from that center
        return s.substring(left + 1, right); //+1 since out of bounds for our base case
    }
}
