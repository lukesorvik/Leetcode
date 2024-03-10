import java.util.Arrays;
import java.util.*;
import java.util.Collections;

public class validkeypad {
    public static void main(String[] args) {
        System.out.println(findMinClicks("abc") + " should be 3");
        System.out.println(findMinClicks("aabbcc") + " should be 6");
        System.out.println(findMinClicks("aabbccddeeffgghhii") + " should be 9");
    }


    public static int findMinClicks(String letters) {
        int clicks = 0;//running sum
        Integer[] lettermap = new Integer[26]; //map of the letters
        
        // Initialize each element of lettermap to 0
        for (int i = 0; i < 26; i++) {
            lettermap[i] = 0;
        }
        
        for (char c : letters.toCharArray()) {
            lettermap[c - 'a'] += 1; //map the letters to the index
            //subtracting 'a' will give us the index of the letter since 
        }

        Arrays.sort(lettermap, Collections.reverseOrder()); //sort the array starting from most frequent letter
        //so now will be sorted in descending order of [9,3,.....]
        int multiplier = 1;
        
        //size 26 array so iterate over the sorted
        for(int i = 0; i< 26 ; i++){
            clicks += multiplier * lettermap[i]; 
            if (i %9 ==0) {
                ++multiplier;
            }
        }

        return clicks;

    }
}
