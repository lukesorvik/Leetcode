import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



/*
 * leetcode 17
 * 
 * given string contaning didgits  2-9 inclusive  return all possible letter combinations that the number could 
 * represent, return the answer in any order
 * 
 * Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Input: digits = "2"
Output: ["a","b","c"]

3 -> [d,e,f]

So i think we are permuting the set of integers that each number maps to
2 -> [a,b,c] , so we permute 2 for each possible letter

naive:
create a map of the digits to the letters
recursive function that takes in the input string
we iterate over each letter in the input string
we get the array of letters it could be from the map
we pick one of the letters, add it to the set of seen letters
call the next letter in digits

dfs type algorithm because we are going down one of the branches of choices


Better:
backtracking algorithm
we have a map of the digits to the letters
we have a recursive function that takes in the index of the current digit, the input string, and the current string
We iterate over each character the current digit[i] maps to
we call recursively with each character, to the next digit (i+1) where it then iterates over the characters of the digit[i+1] and call recursively again
We append the current character to the recursive call
we only return when our current string is the same length as the input string, meaning we have a full permutation


runtime?
O(4^n* n)

n since we do this n times (where n = size of digits string)

ex: we have string 9999, so we have 4*4*4*4 choices for each char = 256 possible permutations
worst case n 9's so 4^n
 * 
 */
public class letterComboPhonenumber {
    public static void main(String[] args) {
        letterComboPhonenumber l = new letterComboPhonenumber();
        System.out.println(l.letterCombinations("23"));
    }

    static List<String> output = new ArrayList();
    static Map<Character, String> keyMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        output.clear(); //clear the output list
        keyMap.put('2', "abc");
        keyMap.put('3', "def");
        keyMap.put('4', "ghi");
        keyMap.put('5', "jkl");
        keyMap.put('6', "mno");
        keyMap.put('7', "pqrs");
        keyMap.put('8', "tuv");
        keyMap.put('9', "wxyz");

        backtrack(0, digits, "");

        return output;
    }



    public void backtrack(int i, String digits, String currentString){
        //base case, length of currentString = length of digits, meaning full permutation met
        if (currentString.length() == digits.length()) {
            output.add(currentString); //add to the output list
            return;
        }
        //if the input string is empty, return (base case
        if(digits.length() == 0) {
            return; 
        }
       
        char[] numbers = digits.toCharArray(); //get the array of numbers
        String characters =  keyMap.get(numbers[i]);  //get the array of letters for the current number[i]

        //for each letter that keypad maps to
        for (char c : characters.toCharArray() ) {
            backtrack(i+1, digits, currentString+c); //call recursively 
            //i++, pass string of digits, add the char to the current string
        }


    }
}
