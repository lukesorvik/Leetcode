import java.util.ArrayList;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        
    


    //TreeNode root = new TreeNode(1, null, TreeNode(2, TreeNode(3), null));

    TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
    
    //root.right = new TreeNode(2, new TreeNode(3), null);

    
    
     List<Integer> list = Solution.inorderTraversal(root);
     System.out.println(list);
     //was giving really weird bugs because wasnt inside main method lol

     }

}



//Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
 }


class Solution {
    static List<Integer> list; //creates list variable for class



    public static List<Integer> inorderTraversal(TreeNode root) {


        list = new ArrayList<>(); //list to return
        inorder(root);
        return list;


    }

    public static void inorder (TreeNode root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);


    }
}