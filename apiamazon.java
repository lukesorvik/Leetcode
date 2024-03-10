import java.util.*;

public class apiamazon {

    public static void main(String[] args) {
        List<String> logs = new ArrayList<>();
        logs.add("register");
        logs.add("user1");
        logs.add("pass1");
        implementAPI(logs);
    }
    
    
        public static List<String> implementAPI(List<String> logs) {
            List<String> result = new ArrayList<>();
           Set<String> usersLoggedin = new HashSet<>();
           Map<String, String> userReg = new HashMap<>();
           Iterator logsIterator = logs.iterator();
   
           while ( logsIterator.hasNext() ) {
               String str = (String)logsIterator.next(); //get command
   
               //register the user
               if (str == "register") {
                   //get username
                   String user = (String)logsIterator.next();
                   String pass = (String)logsIterator.next();
   
                   if (userReg.containsKey(user) == false) {
                       userReg.put(user, pass);
                       result.add("Registered Successfully");
                   }
                   else {
                       result.add("Username already exists");
                   }
                   
   
   
               }
               else if (str == "login") {
                   String user = (String)logsIterator.next();
                   String pass = (String)logsIterator.next();
   
                   //if the user and passowrd are correct, and they are not logged in
                   if (userReg.containsKey(user) == true && usersLoggedin.contains(user) == false && userReg.get(user) == pass) {
                       usersLoggedin.add(user);
                       result.add("Logged in Successfully");
                   }
                   else {
                        result.add("Login unsuccessful");
                   }
               }
                   
               else if (str == "logout") {
                   String user = (String)logsIterator.next();
                   String pass = (String)logsIterator.next();
                   
                       if (usersLoggedin.contains(user) == true) {
                           usersLoggedin.remove(user);
                           result.add("Logged Out Successfully");
                       }
                       else {
                           result.add("Logout unsuccessful");
                       }
                       
               }
           }
   
           return result;
       }
   
   

}
