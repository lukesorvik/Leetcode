public class App {
    public static void main(String[] args) throws Exception {
        


        int[] nums = new int[]{1,1,2}; //declares an array

        int nums2[] = {0,0,1,1,1,2,2,3,3,4}; //another way to declare an array


        int x = Solution.removeDuplicates( nums);
        System.out.println("nums number of unique elements " + x);

        System.out.println("nums2 number of unique elements " + Solution.removeDuplicates(nums2));




    }
}
