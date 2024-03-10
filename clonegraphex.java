import java.util.*;




public class clonegraphex {
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
        visited[copy.val] = copy;// store the current node at it's val index which will tell us that this node is now visited
        
//         now traverse for the adjacent nodes of root node
        for(Node n : node.neighbors){
//             check whether that node is visited or not
//              if it is not visited, there must be null
            if(visited[n.val] == null){
//                 so now if it not visited, create a new node
                Node newNode = new Node(n.val);
//                 add this node as the neighbor of the prev copied node
                copy.neighbors.add(newNode);
//                 make dfs call for this unvisited node to discover whether it's adjacent nodes are explored or not
                dfs(n , newNode , visited);
            }else{
//                 if that node is already visited, retrieve that node from visited array and add it as the adjacent node of prev copied node
//                 THIS IS THE POINT WHY WE USED NODE[] INSTEAD OF BOOLEAN[] ARRAY
                copy.neighbors.add(visited[n.val]);
            }
        }
        
    }
    public static Node cloneGraph(Node node) {
        if(node == null) return null; // if the actual node is empty there is nothing to copy, so return null

        Node copy = new Node(node.val); // create a new node , with same value as the root node(given node)

        Node[] visited = new Node[101]; // in this question we will create an array of Node(not boolean) why ? 
        //, because i have to add all the adjacent nodes of particular vertex, 
        //whether it's visited or not, so in the Node[] initially null is stored, if that node is visited,
        // we will store the respective node at the index, and can retrieve that easily.
        
        Arrays.fill(visited , null); // initially store null at all places
        dfs(node , copy , visited); // make a dfs call for traversing all the vertices of the root node
        return copy; // in the end return the copy node
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


