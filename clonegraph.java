import java.util.*;




public class clonegraph {
    public static void main(String[] args) {
        Node node = new Node();
        node.val = 1;
        node.neighbors = new ArrayList<Node>();

        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node3 = new Node(4);

        node2.neighbors.add(node);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node);
        node4.neighbors.add(node3);

        node.neighbors.add(node2);
        node.neighbors.add(node4);

        Node copy = cloneGraph(node);
        printGraph(copy);
    }

    public static void dfs(Node node , Node copy , Node[] visited){
   
        
    }
    public static Node cloneGraph(Node node) {
   
    }

    public static void printGraph(Node node) {
        //print the graph
        System.out.println("Node: " + node.val);
        for (Node n : node.neighbors) {
            System.out.println("Neighbor: " + n.val);
        }
    }

    
}

// Definition for a Node, for the graph
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


