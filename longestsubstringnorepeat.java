import java.util.*;

public class longestsubstringnorepeat {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    
    public static int lengthOfLongestSubstring(String s) {
        
        int longest = 0;
        List<Character> substring = new ArrayList(); //arraylist to store current substring

        for (int right = 0; right< s.length(); right++ ) {
            //if we have found a duplicate
            if(substring.contains(s.charAt(right))) { 
                int index = substring.indexOf(s.charAt(right));
                substring.remove(index); //remove the element from the current substring 
            }
            else{
                substring.add((Character)s.charAt(right));
                longest = Math.max(longest, substring.size());

            }
        }

        return longest;
        
    }
}
