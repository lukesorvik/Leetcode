
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

public class longestrepeatingchar {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
        
    }

    public static int characterReplacement(String s, int k) {
        int longest = 0;
        Character current = s.charAt(0);  //current character we are looking for duplicates of, initialize at first char in string
        int leftpointer = 0;
        int freebies = k;

        for (int rightpointer =0; rightpointer< s.length(); rightpointer++) {
            Character c = s.charAt(rightpointer);

            if (c != current && freebies <= 0) {
                while (s.charAt(leftpointer) != c) {
                    leftpointer++;
                }
                freebies = k; //reset freebies, we are looking at a new block!
            }

            //if thing at right pointer is not the char we are looking for
            if(c != current) {
                freebies--; //decrement freebies
                longest = Math.max(longest, rightpointer-leftpointer+1);
            }

            //thing at c is a duplicate of current char at left pointer
            else {
                longest = Math.max(longest, rightpointer-leftpointer+1);
            }
        }

        return longest;
        
    }
}
