public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        TreeNode left = new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3));
        TreeNode whole = new TreeNode(1, left, new TreeNode(2));

        System.out.println(Solution.isBalanced(whole));




    }
}




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
    public static boolean isBalanced(TreeNode root) {

        /* 
        need to find a way to calculate height

        need to remember: root, height
        recursive (height, root)
        each loop add 1 to height and go to deeper nodes

        

        find a way to record max height and minimun height depth
        traverse tree

        */

        if (root == null){
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        //find a way to compare if the height between the two is different by 2

        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            //if the difference between the absolute value of height is less than or equal to 1
            //and if the left sub tree is the same, and the right sub tree is the same
            //then it is height balanced
            return true;
        }

        //reaches this point if false
        return false;




        
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));

    }
}