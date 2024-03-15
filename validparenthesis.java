/*
 * leetcode 20
 * given string s containing the chars '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

idea:
map each opening bracket to it's closing bracket
use a stack
add all the ({[ to the stack
when we get to any })]
remove the top element from the stack and check if it is the correct value
since if at top of stack most recent element should be the correct bracket
{[
[ = top of stack
]}
] read so pop, pop = [, [==] so valid parenthesis 
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class validparenthesis {
    public static void main(String[] args) {
        validparenthesis v = new validparenthesis();
        System.out.println(v.isValid("()") + " should be true");
        System.out.println(v.isValid("()[]{}") + " should be true");
        System.out.println(v.isValid("(]") + " should be false");
        System.out.println(v.isValid("([)]") + " should be false");
        System.out.println(v.isValid("{[]}") + " should be true");
    }
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();

        if(s.length() == 0) return true; //empty string is valid

        //for each char in the string
        for ( char c : s.toCharArray()) {
            //if the char is an open bracket, add it to the stack
            if ( c == '{' || c == '[' || c == '(' ){
                stack.push(c);
            }
            //since we know string s contains only parenthesis, anything else must be a closing bracket
            else {
                //if the stack is empty, we have a closing bracket without an open bracket
                if (stack.isEmpty()) {
                    return false;
                }
                //if the top of the stack is not the corresponding open bracket, return false
                if(stack.pop() != map.get(c)) {
                    return false;
                }
             }
        }
        
        //if the stack is empty, we have a valid string, all open brackets have been closed
        if(stack.isEmpty()) {
            return true;
        }
        else { //we have one open bracket remaining, not valid ex: "()("
            return false;
        }
    }
}
