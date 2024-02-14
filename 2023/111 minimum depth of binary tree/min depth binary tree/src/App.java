
public class App extends Solution {
    public static void main(String[] args) throws Exception  {
        System.out.println("Hello, World!");
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode main = new TreeNode(3, new TreeNode(9), right);

        System.out.println(minDepth(main));

        TreeNode last = new TreeNode(6);
        TreeNode before = new TreeNode(5, null, last);

        TreeNode main2 = new TreeNode (2, null , new TreeNode(3, null, new TreeNode(4, null, before) ) );
        System.out.println(minDepth(main2));


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
    public static int minDepth(TreeNode root) {
        //count the number of nodes from the root
        //return the smallest amount of nodes from root

        //base case
        if (root == null) {
            //if current root is null, return 0 (dont add to depth)
            return 0;
        }

        //set left depth of current root to
        int leftDepth = minDepth(root.left);

        //set right depth of current root to
        int rightDepth = minDepth(root.right);


        //reaches this if the .right node is null, but the .left node is not
        if (rightDepth == 0 && leftDepth != 0) {
            return leftDepth + 1; //returns only the current leftDepth + 1

        }

        //reaches this if the .left node is null, but the . right is not
        if (leftDepth == 0 && rightDepth != 0) {
            return rightDepth + 1; //returns current depth of right + 1
        }
        
        else {
            //reaches this point if both.left and.right are are not null
            //has to compare the min out of the two values
            return Math.min(leftDepth,rightDepth) + 1;
        }
        
    }
}



