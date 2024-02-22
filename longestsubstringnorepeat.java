import java.util.*;

public class longestsubstringnorepeat {
    public static void main(String[] args) {
        String s = "pwwkew";
        //String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }
    
    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        Set<Character> set = new HashSet<>(); // to store the characters we have found so far (of our current block)

        int leftpointer = 0;

        for (int rightpointer = 0; rightpointer < s.length(); rightpointer++) {
           char c = s.charAt(rightpointer);

           //if the current character is already in the set, move the left pointer to the right until the current character is no longer in the set
           //remove the left pointer character from the set as we move the left pointer to the right
            if (set.contains(c)) {
               while ( set.contains(c)) {
                   set.remove(s.charAt(leftpointer));
                   leftpointer++;
               }
               set.add(c); //add the current element to the set, to start a new block
                
            }

            //continue current block
            //if the current character is not in the set, add it to the set and update the longest substring length
            else {
                set.add(c);
                longest = Math.max(longest, rightpointer - leftpointer + 1);
            }

        }

        return longest;
        
    }
}
