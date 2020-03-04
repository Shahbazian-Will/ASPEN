/* Will Shahbazian
*Version 2.0.0
*This is my TeacherClassroom class.
It can utilize the StudentAccount class, and it is utilzed by the ASPENGUI class. 
It's the second version with a lot of new methods required by the ASPENGUI.
*6/17/19
*/

import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.lang.Object;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.LineNumberReader;

public class TeacherClassroom{

   private String name;
   private StudentAccount[] accounts;
   private int numAccounts;
   public static final int MAX_ACCOUNTS = 25;
   public String classList;
   public String gradeComp = "";
   public String grade = "";
 
   public TeacherClassroom()
   {
      accounts = new StudentAccount[MAX_ACCOUNTS];
      classList = "";
   }
   public String addStudent(String u, String p)
   {
      if(numAccounts < MAX_ACCOUNTS)
      {
         accounts[numAccounts] = new StudentAccount(u, p);
         numAccounts++;
         return u + " " + p;
      }
      else
         return null; //no more room 
      }
   public void changeAllGrades()throws IOException{
      PrintWriter gradeEraser = new PrintWriter(new File("gradelist.txt")); //erases gradelist.txt so it can be overwritten
      gradeEraser.close();
   }
   public void changeAbsences(String a)throws IOException{
      PrintWriter absenceWriter = new PrintWriter(new File("absences.txt")); //erases to overwrite
      absenceWriter.println(a);
      absenceWriter.close();
   }
   public void changeTardies(String t)throws IOException{
      PrintWriter tardiesWriter = new PrintWriter(new File("tardies.txt")); //erases to overwrite
      tardiesWriter.println(t);
      tardiesWriter.close();
   }
   public void changeDismissals(String d)throws IOException{
      PrintWriter dismissalsWriter = new PrintWriter(new File("dismissals.txt")); //erases to overwrite
      dismissalsWriter.println(d);
      dismissalsWriter.close();
   }
   public String addGrade(String g) throws IOException{
      PrintWriter gradeWriter = new PrintWriter(new FileWriter("gradelist.txt", true)); //Appends gradelist.txt
      gradeWriter.println(g);
      gradeWriter.close();
      return g;
   }   
   public StudentAccount checkAccount(TeacherClassroom c, String u, String p)
   {
      StudentAccount target = c.findAccount(u, p);
      if(target == null)
         return null;
      else 
         return c.findAccount(u, p);
   }
   private StudentAccount findAccount(String u, String p)
   {
      for(int i=0; i<numAccounts; i++)
      {
         if(accounts[i] != null && accounts[i].validateAccount(u, p) == true)
            return accounts[i];
      }
      return null;
   }
   public int findAccountNumber(String u, String p){
      for(int i=0; i<numAccounts; i++)
      {
         if(accounts[i] != null && accounts[i].validateAccount(u, p) == true)
            return i;
      }
      return -1;
   }
   public String findName(int i)throws Exception{
      String accountName = Files.readAllLines(Paths.get("classlist2.txt")).get(i); //https://programming.guide/java/reading-nth-line-from-file.html
      return accountName;
   }
   public String findYOG(int i)throws Exception{
      String YOG = Files.readAllLines(Paths.get("yog.txt")).get(i);
      return YOG;
   }
   public int getLine(String fullName) throws Exception { //gets the line number of the inputted name. Vital for the rest of the "find" methods. Helps program match info to the correct person.
      BufferedReader buf = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream("classlist2.txt")))); //https://stackoverflow.com/questions/7548519/finding-line-number-of-a-word-in-a-text-file-using-java
   
      String line;
      int lineNumber = 0;
      while ((line = buf.readLine()) != null){
         if (fullName.equals(line)) {
            return lineNumber;
         } else {
            lineNumber++;
         }
       }
       return -1;
   }
   public String findGrade(int i)throws Exception{ //finds the grade at line i  and returns it
      String studentsGrade = Files.readAllLines(Paths.get("gradelist.txt")).get(i);
      return studentsGrade;
   }
   public String findAbsences(int i)throws Exception{ //finds number of absences at line i and returns it
      String studentsAbsences = Files.readAllLines(Paths.get("absences.txt")).get(i);
      return studentsAbsences;
   }
   public String findDismissals(int i)throws Exception{ //finds number of dismissals at line i and returns it
      String studentsDismissals = Files.readAllLines(Paths.get("dismissals.txt")).get(i);
      return studentsDismissals;
   }
   public String findTardies(int i)throws Exception{ //finds number of dismissals at line i and returns it
      String studentsTardies = Files.readAllLines(Paths.get("tardies.txt")).get(i);
      return studentsTardies;
   }
   public String classListToString() throws Exception{ 
      Scanner classListReader = new Scanner(new File("classlist2.txt"));
      classList = "";
      for(int h = 0; h <24; h++){
         classList += classListReader.nextLine() + ": Grade: " + findGrade(h) + "% Absences: " + findAbsences(h) + " Tardies: " + findTardies(h) + " Dismissals: " + findDismissals(h) + "\n";
      }
      return classList;
   }
}