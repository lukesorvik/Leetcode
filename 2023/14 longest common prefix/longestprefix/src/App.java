public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("longest common prefix: ");


        String[] strs = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};
        String[] strs3 = {"fl","flooow","floiz"};




        String sol = Solution.longestCommonPrefix(strs);

        System.out.println(sol);

        System.out.println( Solution.longestCommonPrefix(strs2) );

         System.out.println( Solution.longestCommonPrefix(strs3) );






    }
}
