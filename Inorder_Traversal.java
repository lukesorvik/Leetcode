import java.util.*;

import javax.swing.tree.TreeNode;



public class Inorder_Traversal {
    public class TreeNode {
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

    public static void main(String[] args) {
        Inorder_Traversal test = new Inorder_Traversal();
        TreeNode root = test.new TreeNode(1);
        root.right = test.new TreeNode(2);
        root.right.left = test.new TreeNode(3);
        System.out.println(test.inorderTraversal(root));
    }



    List<Integer> answer = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return answer;
    }

    public void inOrder(TreeNode root) {
        //base case
        if(root == null) {
            return;
        }

        //divide

        inOrder(root.left); //recurse down to farthest left

        //only reach this point if left leaf.left == null, then we go return and recurse back up to leaf node
        answer.add(root.val); //add leaf node to answer list
        
        
        inOrder(root.right); //recurse down to farthest right

        
    }
}
