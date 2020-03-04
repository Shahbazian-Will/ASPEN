/* Will Shahbazian
*Version 1.0.0
*This is a Student class that can be used with the TeacherClassroom class and the ASPENGUI class. It has remained essentially untouched since being created.
*6/6/19
*/
import java.io.*;

public class StudentAccount
{
   private String username;
   private String password;
   
   public StudentAccount(){
      username = "";
      password = "";
   }
   public StudentAccount(String u, String p){
      username = u;
      password = p;
   }
   public String getAccountInfo(){
      return username + " " + password;
   }
   public boolean validateAccount(String u, String p) //checks to see if account exists
   {
      String actualInfo = u + " " + p;
      if(actualInfo.equals(toString())){
         return true;
      } else {
         return false;
      }
   }
   public String toString(){
      return username + " " + password;
   }
}