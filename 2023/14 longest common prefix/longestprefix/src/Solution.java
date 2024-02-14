import java.util.Arrays;

public class Solution {
    public static String longestCommonPrefix(String[] strs) {

        /*accepts an array of strings so
        strs[0] would get first word in array of strings

        Input: array of strings
        Output: the longest commom prefix for every string (longest common chars per string)


        how to:
        since every common prefix means that "flow" and "fl" if start with "fl" the common prefix would be itself

        sort by lexicographic order (so that the smalled word is in front of list)

        then have a for loop that runs while i<firstsmalled string.length

        each loop test the current char with the other words to see if there is a char there as well

        if so then it is a common prefix

        add current char to the end of the output string

        */


        System.out.println("before sort" + Arrays.toString(strs));

        Arrays.sort(strs); //sorts the string into lexographix order (least to most or alphabetical)
        //first string in array will be the smallest
        //last will be the most out of common with rest of strings

        /*
        The reason why we sort the input array of strings and compare the first and last strings is that the 
        longest common prefix of all the strings must be a prefix of the first string and a prefix of the last
         string in the sorted array. This is because strings are ordered based on their alphabetical order (Lexicographical order).
        For example, consider the input array of strings {"flower", "flow", "flight"}. 
        After sorting the array, we get {"flight", "flow", "flower"}. 
        The longest common prefix of all the strings is "fl", which is located at the beginning of the first string "flight" and the second string "flow".
        Therefore, by comparing the first and last strings of the sorted array, we can easily find the longest common prefix.
*/


        System.out.println("after sort" + Arrays.toString(strs));
        String s1 = strs[0];
        String s2 = strs[strs.length-1];

        int idx = 0; //sets the index for the while loop

        while ( idx < s1.length() && idx < s2.length() ) {
            //runs as long as the index is less than the first string and last string
            //if the current index is more than the length of the first and last string, kills the loop
            //stops the out of bounds array error
            


            if (s1.charAt(idx) == s2.charAt(idx) ) {
                //if the current element in the first string is equal to the current element in the last string
                //then it is a prefix
                
                idx++; //increases index which means current element will be included in output string
            }

            else { //they are not equal, so it is the end of the common prefix
                break; //ends while loop
            }
        }

        return s1.substring(0,idx); //returns the string of the first word in array from (index 0, to last found prefix)






    }
}