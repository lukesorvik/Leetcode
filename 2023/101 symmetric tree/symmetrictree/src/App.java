import java.io.PrintStream;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode right = new TreeNode(2, new TreeNode(4), new TreeNode(3));

        TreeNode root = new TreeNode(1, left, right);

        
        print(root);

        boolean answer = Solution.isSymmetric(root);
        System.out.println("is the tree symmetric :" + answer);
    }

    //recursive method
    //method to create a long string (string builder, out of the tree)
    public static void traversePreOrder(StringBuilder sb, String padding, String pointer, TreeNode root) {
        if (root != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(root.val);
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("| ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = (root.right != null) ? "├──" : "└──";
            // if root.right != null, ├── , else └──
            traversePreOrder(sb, paddingForBoth, pointerForLeft, root.left);
            traversePreOrder(sb, paddingForBoth, pointerForRight, root.right);

        }

    }

    //prints the treenode, by using a stringbuilder variable, and recursion
    public static void print( TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", root);
        System.out.println(sb.toString());
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static boolean isSymmetric(TreeNode root) {

        

        //tests if current root node is null, if so returns false
         if (root == null) {
             return false;
         }

       

        //dont need hella code since recursion will test for things
        //root just cant be null, since we need .right and .left pointers
        return test(root.left, root.right); // calls recursive function to go deeper
       


    }

    public static boolean test(TreeNode left, TreeNode right) {
        

        // base cases

        // base case if left nodes (end of tree)
        if (left == null && right == null) {
            return true;
        }

        // base case if inner nodes are not same
        //if the left node is null, or the right node is null
        //reaches this point if only one node is null and the other has a value
        //hence not symmetric
        if (left == null || right == null) {
            return false;
        }

        

        // tests if the left branches and right branches are NOT symmetrical
        //if the left and right nodes are not equal, not symmetrical
        if (left.val != right.val) {
            return false;

        }

        // reaches this point if the two sides are symmetrical, moves foward
        return test(left.left, right.right) && test(left.right, right.left);

    }
}
