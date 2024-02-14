public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        TreeNode p = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        TreeNode q = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        System.out.println("are they same tree? :" + Solution.isSameTree(p,q));


        boolean t = true;
        boolean f = false;
        System.out.println("true && false ==" + (t && f));
        System.out.println("true && true ==" + (t && t));
        System.out.println("false && false ==" + (f && f));



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
    public static boolean isSameTree(TreeNode p, TreeNode q) {


        return (check(q, p));
        
    }


    //recursive method
     public static boolean check (TreeNode p, TreeNode q) {


        //reaches this point at the end of the tree
        if (q == null && p == null) {
            return true; //base case, end of tree, leaf
        }


        //checks nulls first (so dont throw null point exception for p.val)
        //checks if current nodes are unequal and if so returns false
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        
        //reaches this point if p.val==q.val
        //means go deeper since it is valid tree so far
        return check(p.left, q.left) && check (p.right, q.right);
        


    }


}