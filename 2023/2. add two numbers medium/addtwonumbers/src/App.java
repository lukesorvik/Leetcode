import java.util.ArrayList;

import javax.xml.bind.PrintConversionEvent;

public class App {
    public static void main(String[] args) throws Exception {

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

        System.out.println("l1 =");
        PrintList(l1);

        System.out.println("l2 =");
        PrintList(l2);

        //creates a new l3, with the returned sum of l1+l2
        ListNode l3 = Solution.addTwoNumbers(l1,l2);

        System.out.println("their sum is");
        PrintList(l3);




    }

    //METHOD to print the values of an array list without destroying it
    public static void PrintList(ListNode input) {
         ListNode temp = input;  //creates new temp node so the original node is not destroyed
        //how to print node to test

        ArrayList printList = new ArrayList<>(); //creates arraylist to add all of the current vals to (so it prints nicer)


        while (temp != null ) { //runs as long as the current node is not empty (not declared, last node in list will be null)
            printList.add(temp.val);
             temp = temp.next; //sets head to next linked node
    
        }

        System.out.println(printList);
    }
}







 class ListNode {
     int val;
     ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode() {}
    ListNode(int val, ListNode next) { 
        this.val = val;
         this.next = next; 
        }

      
 }

 
 class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            //digit 1 is equal to:
            //condition ? if true : if false
            // if l1 is not null, first digit is l1.val, if it is null, first digit is zero
            //TERNARY OPERATOR
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            //digit is equal to the remainder of sum/10 (sum % 10)
            //gives leftover digit

            carry = sum / 10;

            ListNode newNode = new ListNode (digit); //creates new node for digit we want to add to the end
            tail.next = newNode; //sets the .next node of tail to new digit (tail = tail of dummy node)
            tail = tail.next; //sets tail to the newly added node (the new tail; end of dummy node)

           l1 = (l1 != null) ? l1.next : null;
           //if l1 is not equal to null, set l1head to .next node, if is equal to null, set equal to null
           //condition ? if true : if false

           l2 = (l2 != null) ? l2.next : null;
           //if l2 is not equal to null, set l2head to .next node, if is equal to null, set equal to null 
            //same as writing if(l2!=null) { l2= l2.next}


        }

        ListNode result = dummyHead.next; //since dummyhead will have extra 0 at first node, set result to .next (real start)
        //ex: dummy = [0,7,0,8] should be [7,0,8]
       dummyHead.next = null; //resets the dummy head to [0] also works without this
        return result;





    }
}