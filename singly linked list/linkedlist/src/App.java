

public class App {
    public static void main(String[] args) throws Exception {
        
        //how to create a linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2); //declares next object with value parameter for input (refer to listnode class to understand)


        System.out.println("list before remove dupe");
        PrintList(head);


        Solution.deleteDuplicates(head); //runs the delete duplicates method with the ListNode
        System.out.println("list after remove dupe");
        PrintList(head);
         


    }


    public static void PrintList(ListNode input) {
         ListNode temp = input;  //creates new temp node so the original node is not destroyed

        //how to print node to test
        while (temp != null ) { //runs as long as the current node is not empty (not declared, last node in list will be null)
            System.out.println(temp.val); //prints head of linked list current value
             temp = temp.next; //sets head to next linked node
    
        }
    }

}



//object listnode
class ListNode {
     int val; //current value of listnode
     ListNode next; //next node it points to
     ListNode() {} //method construct
     ListNode(int val) {  //overloaded method with just value as input
        this.val = val; }
     ListNode(int val, ListNode next) { //overloaded method with current val and next listnode to point to
        this.val = val; 
        this.next = next; }

  }
 

 
class Solution {
    public static ListNode deleteDuplicates(ListNode head) {




        ListNode temp = head; //creates a new head of list object, with the same .next objects as head
        //leaves the head node alone and creates a duplicate so that after we iterate through the list we still have the head node left
        //since the temp node will be the last node after cleaning up list

        if (head == null ) { //if the current node points to nothing
            return head; //return since the list is empty
        }

        while (temp.next != null ) { //while the current node points to a next node that has a value
           
            if (temp.val != temp.next.val) { //if the current value is equal to the next
                //move head node to next node (iterate next)
                temp = temp.next;  //make the current node equal to the next 
                
               
            }

            else { //if the current node.val == node.next.val
                temp.next = temp.next.next; //sets current node to point to the next nodes pointer
                //ex : 1-> 1-> 2
                 //so if temp.next is 1->1
                //and temp.next.next is 1->2
                //doing temp.next =temp.next.next would set the current node to point to 1->2
                //thus getting rid of the extra and keeping the next number to point to
            }
        }

        return head; //returns head node with newly removed duplicates
        
    }
}
