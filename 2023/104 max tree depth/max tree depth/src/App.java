public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(1, new TreeNode(9), right);


        int maxDepth = Solution.maxDepth(root);
        System.out.println("max depth of tree is "  + maxDepth);
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
    public static int maxDepth(TreeNode root) {
        /*
         * traverse tree to find longest path
         * count nodes along the way
         * recursively do this
         * 
         * do
         * count 1, recursively call root.left root.right
         * if root != null
         * count ++
         * 
         * go through each branch recursively
         * examine current node, if not null then add one to count
         * if null return 0 (base case)
         * 
         * 
         * 
         * 
         */


        return depth(0, root);

    }

    public static int depth(int count, TreeNode root) {


        //if the current node has a value, add one to count and go deeper
        if (root != null) {
            count++;
            return Math.max(depth(count, root.left), depth(count, root.right));
            //returns the bigger number of the two recursive call
        }

        //base case when reach end of nodes
        //reaches this point if the root is null (end of tree)
        //returns total count of that branch
        return count;
        

    }
}