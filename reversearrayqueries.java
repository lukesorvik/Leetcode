import java.util.ArrayList;
import java.util.List;

public class reversearrayqueries {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        List<List<Integer>> operations = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>() {{ 
            add(1); 
            add(3); 
            } }; 
        
        operations.add(list);
         
        
        System.out.println(performOperations(arr, operations) + " should be [200, 200, 200, 200, 200]");
    }


    //passes all tests!!!
    public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {
        for (List<Integer> operation : operations) {
            int start = operation.get(0); //get the start index from the ar
            int end = operation.get(1);


            for (int i = start ; i < end; i++) {
                int temp = arr.get(i);

                arr.set(i, arr.get(end)); //swap the first and last
                arr.set(end, temp);
                end--;
            }
        }
        return arr;
    }
}
