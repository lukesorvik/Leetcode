public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        String a = "abab";
        String b = "abcabcabcabc";
        String c = "bb";

        System.out.println(Solution.repeatedSubstringPattern(a));
        //System.out.println(Solution.repeatedSubstringPattern(b));
        System.out.println(Solution.repeatedSubstringPattern(c));
    }
}



class Solution {
    public static boolean repeatedSubstringPattern(String s) {
        
        int sLength = s.length(); //stores the length of string s
       
        //a for loop to create substrings of string s starting fron index 0 to index i
        for (int i = 1 ; i <= sLength - 1; i++) {
            //i starts at index 1 of string
            //runs until the second to last index of string (so the whole string doesnt become a substring and reads true)
            
            
            String sub = s.substring(0, i); //creates a substring from index 0 of string to current i value
            int subLength = sub.length(); //creates a integer that keeps track of string length
        

            if (sLength % subLength == 0) { 
            //if the remainder of stringlength / substringlength == 0, then the substring can be appended to fit whole string

                int times = sLength / subLength; //this is the number of times the substring would need to be appended
                StringBuilder str = new StringBuilder(); //creates a stringbuilder like an arraylist to add the string to

                //for loop to add the substring to the end of the arraylist for the number of times calculated earlier
                for (int j = 0; j < times ; j++) {
                    str.append(sub);
                }

                String appended = str.toString(); //creates a new string from the arraylist

                if (s.equals(appended)) { //if string s equals the new appended string built from substring then it is true
                    return true;
                }

            }
        }

        //reaches this point if not found
        return false;
   

    }
}


/*
given a string s check if it can be constructed by taking a substring of it and appending multiple copies of the substring together

append = takes an object as an argument and adds it to the end of an existing list.


examples:
input s= "abad"
true
"ab" + "ab"

input "aba"
false
"ab" + "a"

input "abcabcabcabc"
true
"abc" x 4



how to solve:
iterate through each charater in the string
each iteration create a substring of start of string to current index
see if


psuedo code:

sLength = s.length();
StringBuilder str = new StringBuilder();



for (int i = 0 ; i < sLength - 1; i++) {
    
    String sub = s.subString(0, i);
    subLength = sub.length();

    if (sLength % subLength == 0) {
        int times = sLength / subLength;
        StringBuilder str = new StringBuilder();


        for (int = 0; i <= times ; i++) {
            str.append(sub);
        }

        String appended = str.toString();

        if (s.equals(appended)) {
            return true;
        }


      


    }


    }








*/