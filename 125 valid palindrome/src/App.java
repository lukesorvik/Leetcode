import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        String s = "race a car";
        System.out.println(Solution.isPalindrome(s));

       String s2 =  "A man, a plan, a canal: Panama";

       System.out.println(Solution.isPalindrome(s2));



    }
}



class Solution {
    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();//converts string to lower case
        //have to set s= s.tolower since the .tolower just returns what the string would be in lower case
        StringBuilder str = new StringBuilder();
        int numberLow = 48;
        int numberHigh = 57;
        int letterLow = 97;
        int letterHigh = 122;

        List<Character> string = new ArrayList<>(); //mutiple(changable) charater list


        for (int i = 0; i < s.length(); i++) {
            
            Character current = s.charAt(i);

            if ( (current >= numberLow  && current <= numberHigh ) || (current <= letterHigh && current >= letterLow) ) {
                //is a valid word if char value is a number
                //OR  (BEFORE DIDNT WORK BECAUSE I HAD IT SET TO AND)
                //it is a valid lower case letter

                //if the current character is a number or a letter
                //add to string builder
                string.add(current); //adds to the end of the array

            } 
        }

        //now should have a string with only numbers and letters

        int end = string.size() - 1; //last index of array

        for (int i = 0; i < string.size() ; i++) {
            //iterates through new lowercase alphanumeric arraylist

            if (string.get(i) != string.get(end-i) ) {
                //if the first element and the last element are not the same
                //return false
                return false;
            }

        }

        return true; //returns true if no unequal values were found


    }
}


/*

convert uppercase to lowercase
remove no letter character ,  non-alphanumeric characters, (symbols, not numbers or letter)
remove anything including space

strings are immutable (cannot edit a string, always creates a new one)

could use string builder to convert string to stringbuilder
or
if it is a nonalphanumeric character just skip to next char (might do that)


first iterate from front
iterate from back
compare the two

or 

iterate from front comparing fron index to last index and move closer each time
this might work



chars 
48-57 = numbers on ac11 table
97-122 = lower case numbers

convert all -upercase to lowercase using string method

iterate throgh string
add each char that is aphanumeric to stringbuilder
or char array
remove all non alphanumeric characters


*/