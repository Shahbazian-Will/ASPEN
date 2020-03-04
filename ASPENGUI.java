/* Will Shahbazian
*Version 2.0.0
*This is the second version of the ASPEN GUI. 
I have added additional functionality to both student users and the teacher.
This includes attendance tracking, adding in grades for a single user, displaying personal info, etc.
*6/17/19
*/

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File; 
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ASPENGUI {

   public static void main(String[] args) throws Exception, IOException {
   
      TeacherClassroom c = new TeacherClassroom();
      String username;
      String grade = "";
      String password;
      String gradeComp = "";
      String classList;
      String nextGrade;
      String teacherUsername = "adibenedetto";
      String teacherPassword = "password"; 
      String enteredUsername = "";
      String enteredPassword = "";
      String name;
      String studentsGrade = "";
           
      try{
         Scanner loginInfoReader = new Scanner(new File("logininfo.txt"));
         while(loginInfoReader.hasNext())
         {
            username = loginInfoReader.nextLine();
            password = loginInfoReader.nextLine();
            c.addStudent(username, password); //reads the file containing all the pairs of usernames and passwords, and creates an account for each pair.
         }
      }     
      catch(Exception e)
      {
         e.printStackTrace();
      } 
      while(true) { //Interface will loop until you exit
         URL url = new URL("https://docs.microsoft.com/en-us/schooldatasync/images/follettaspen.png");
         ImageIcon image = new ImageIcon(ImageIO.read(url));
         enteredUsername = 
         (String)JOptionPane.showInputDialog(
               null, "                 Andover Public Schools \nLogin ID",
               "",
         JOptionPane.PLAIN_MESSAGE, image, null, "");
         if(enteredUsername == null){
            return;
         }
         enteredPassword = 
         (String)JOptionPane.showInputDialog(
               null, "                 Andover Public Schools \nPassword",
               "",
         JOptionPane.PLAIN_MESSAGE, image, null, "");
         if(enteredPassword == null){
            return;
         }
         if(enteredPassword.equals("") && enteredUsername.equals("")){
            JOptionPane.showMessageDialog(null,
                  "You must enter a logon \nID. \nYou must enter a \npassword.",
                  "",
                  JOptionPane.ERROR_MESSAGE);
         } else if(enteredUsername.equals("")){
            JOptionPane.showMessageDialog(null,
                  "You must enter a logon \nID.",
                  "",
                  JOptionPane.ERROR_MESSAGE);
         } else if(enteredPassword.equals("")){
            JOptionPane.showMessageDialog(null,
                  "You must enter a password.",
                  "",
                  JOptionPane.ERROR_MESSAGE);
         }else if(enteredUsername.equals(teacherUsername) && enteredPassword.equals(teacherPassword)){
            while(true){
               Object[]	options	=	{"Class Info", "Enter Grade (all students)", "Enter Grade (single student)", "Take Attendance", "Log Off"};//
               int answer	=	JOptionPane.showOptionDialog(null,	
      		      "DiBenedetto, Alison",
      				"Andover Public Schools 2019 - 2020",
      				JOptionPane.YES_NO_CANCEL_OPTION,	
      				JOptionPane.PLAIN_MESSAGE,	null,	options,	
      				options[4]);
                  if(answer == 0){
                     JOptionPane.showMessageDialog(null,
                        c.classListToString(),
                        "Class Info",
                        JOptionPane.PLAIN_MESSAGE);
                  } else if (answer == 1){
                     c.changeAllGrades();
                     Scanner classListReader = new Scanner(new File("classlist2.txt"));
                     while(true){
                        while(classListReader.hasNext())
                           {
                              String studentToGrade = classListReader.nextLine();
                              String enteredGrade = 
                              (String)JOptionPane.showInputDialog(
                                    null, 
                                    "Enter Grade for " + studentToGrade,
                                    "",
                              JOptionPane.PLAIN_MESSAGE, null, null, "");
                              nextGrade = enteredGrade;
                              c.addGrade(enteredGrade);
                              if(nextGrade == null){
                                 break;
                              }
                           }
                           break;
                           }
                  } else if (answer == 2){
                     while(true){
                        Object[] studentPossibilities = {"Ardini, Alexandra", "Ardizzone, Joseph", "Azzi, Emma", "Bobier, Colin", "Branscombe, Michael", "Cummings, Liam", "Desai, Ishaan", "Earl, Alexander", "Elbasiony, Omar", "Gemmell, John", "Hudgins, Miles", "Johnson, Quaid", "Kirn, Cameron", "Lareau, Aidan", "Li, Yiran", "Liu, Larry", "McConley, Jonathan", "Mezher, Issac", "Oltman, Sarah", "Papazian, Gabriel", "Rickards, Gabriella", "Rogoff, Alexander","Shahbazian, Will", "Yundt, Tyler"};
                        String studentName = (String)JOptionPane.showInputDialog(
                              null,
                              "Select Student",
                              "",
                              JOptionPane.PLAIN_MESSAGE,
                              null, studentPossibilities, "");
                        if(studentName == null || studentName.length()<=0){
                           break;
                        }
                        String enteredGrade = 
                        (String)JOptionPane.showInputDialog(
                              null, 
                              "Enter Grade for " + studentName,
                              "",
                        JOptionPane.PLAIN_MESSAGE, null, null, "");
                        if(enteredGrade == null || enteredGrade.length()<=0){
                           break;
                        }
                        Scanner gradesReader = new Scanner(new File("gradelist.txt")); 
                        String grade1 = gradesReader.nextLine();
                        String grade2 = gradesReader.nextLine();
                        String grade3 = gradesReader.nextLine();
                        String grade4 = gradesReader.nextLine();
                        String grade5 = gradesReader.nextLine();
                        String grade6 = gradesReader.nextLine();
                        String grade7 = gradesReader.nextLine();
                        String grade8 = gradesReader.nextLine();
                        String grade9 = gradesReader.nextLine();
                        String grade10 = gradesReader.nextLine();
                        String grade11 = gradesReader.nextLine();
                        String grade12 = gradesReader.nextLine();
                        String grade13 = gradesReader.nextLine();
                        String grade14 = gradesReader.nextLine();
                        String grade15 = gradesReader.nextLine();
                        String grade16 = gradesReader.nextLine();
                        String grade17 = gradesReader.nextLine();
                        String grade18 = gradesReader.nextLine();
                        String grade19 = gradesReader.nextLine();
                        String grade20 = gradesReader.nextLine();
                        String grade21 = gradesReader.nextLine();
                        String grade22 = gradesReader.nextLine();
                        String grade23 = gradesReader.nextLine();
                        String grade24 = gradesReader.nextLine();
                        if(c.getLine(studentName) == 0){
                           grade1 = enteredGrade;
                        } else if(c.getLine(studentName) == 1){
                           grade2 = enteredGrade;
                        } else if(c.getLine(studentName) == 2){
                           grade3 = enteredGrade;
                        } else if(c.getLine(studentName) == 3){
                           grade4 = enteredGrade;
                        } else if(c.getLine(studentName) == 4){
                           grade5 = enteredGrade;
                        } else if(c.getLine(studentName) == 5){
                           grade6 = enteredGrade;
                        } else if(c.getLine(studentName) == 6){
                           grade7 = enteredGrade; 
                        } else if(c.getLine(studentName) == 7){
                           grade8 = enteredGrade;
                        } else if(c.getLine(studentName) == 8){
                           grade9 = enteredGrade; 
                        } else if(c.getLine(studentName) == 9){
                           grade10 = enteredGrade;   
                        } else if(c.getLine(studentName) == 10){
                           grade11 = enteredGrade;  
                        } else if(c.getLine(studentName) == 11){
                           grade12 = enteredGrade; 
                        } else if(c.getLine(studentName) == 12){
                           grade13 = enteredGrade;  
                        } else if(c.getLine(studentName) == 13){
                           grade14 = enteredGrade;   
                        } else if(c.getLine(studentName) == 14){
                           grade15 = enteredGrade;  
                        } else if(c.getLine(studentName) == 15){
                           grade16 = enteredGrade;
                        } else if(c.getLine(studentName) == 16){
                           grade17 = enteredGrade;   
                        } else if(c.getLine(studentName) == 17){
                           grade18 = enteredGrade;  
                        } else if(c.getLine(studentName) == 18){
                           grade19 = enteredGrade;
                        } else if(c.getLine(studentName) == 19){
                           grade20 = enteredGrade;      
                        } else if(c.getLine(studentName) == 20){
                           grade21 = enteredGrade;
                        } else if(c.getLine(studentName) == 21){
                           grade22 = enteredGrade;
                        } else if(c.getLine(studentName) == 22){
                           grade23 = enteredGrade;
                        } else {
                           grade24 = enteredGrade;       
                        }
                        gradeComp = grade1 + "\n" + grade2 + "\n" + grade3 + "\n" + grade4 + "\n" + grade5 + "\n" + grade6 + "\n" + grade7 + "\n" + grade8 + "\n" + grade9 + "\n" + grade10 + "\n" + grade11 + "\n" + grade12 + "\n" + grade13 + "\n" + grade14 + "\n" + grade15 + "\n" + grade16 + "\n" + grade17 + "\n" + grade18 + "\n" + grade19 + "\n" + grade20 + "\n" + grade21 + "\n" + grade22 + "\n" + grade23 + "\n" + grade24;
                        c.changeAllGrades();
                        c.addGrade(gradeComp);
                        if(enteredGrade == null){
                           break;
                        }
                     break;
                     }
                  } else if (answer == 3){
                     while(true){
                        Object[] attendancePossibilities = {"Ardini, Alexandra", "Ardizzone, Joseph", "Azzi, Emma", "Bobier, Colin", "Branscombe, Michael", "Cummings, Liam", "Desai, Ishaan", "Earl, Alexander", "Elbasiony, Omar", "Gemmell, John", "Hudgins, Miles", "Johnson, Quaid", "Kirn, Cameron", "Lareau, Aidan", "Li, Yiran", "Liu, Larry", "McConley, Jonathan", "Mezher, Issac", "Oltman, Sarah", "Papazian, Gabriel", "Rickards, Gabriella", "Rogoff, Alexander","Shahbazian, Will", "Yundt, Tyler"};
                        String studentName = (String)JOptionPane.showInputDialog(
                              null,
                              "Select Student",
                              "",
                              JOptionPane.PLAIN_MESSAGE,
                              null, attendancePossibilities, "");
                        if(studentName == null || studentName.length()<=0){
                           break;
                        }
                        Object[]	attendanceOptions	=	{"Absent", "Dismissed", "Tardy", "Cancel"};//
                        int attendanceAnswer	=	JOptionPane.showOptionDialog(null,	
               		      "Mark " + studentName + " as:",
               				"Andover Public Schools 2019 - 2020",
               				JOptionPane.YES_NO_CANCEL_OPTION,	
               				JOptionPane.PLAIN_MESSAGE,	null,	attendanceOptions,	
               				options[3]);
                        if(attendanceAnswer == 0){
                           Scanner absencesReader = new Scanner(new File("absences.txt")); 
                           int absences1 = Integer.parseInt(c.findAbsences(0));
                           int absences2 = Integer.parseInt(c.findAbsences(1));
                           int absences3 = Integer.parseInt(c.findAbsences(2));
                           int absences4 = Integer.parseInt(c.findAbsences(3));
                           int absences5 = Integer.parseInt(c.findAbsences(4));
                           int absences6 = Integer.parseInt(c.findAbsences(5));
                           int absences7 = Integer.parseInt(c.findAbsences(6));
                           int absences8 = Integer.parseInt(c.findAbsences(7));
                           int absences9 = Integer.parseInt(c.findAbsences(8));
                           int absences10 = Integer.parseInt(c.findAbsences(9));
                           int absences11 = Integer.parseInt(c.findAbsences(10));
                           int absences12 = Integer.parseInt(c.findAbsences(11));
                           int absences13 = Integer.parseInt(c.findAbsences(12));
                           int absences14 = Integer.parseInt(c.findAbsences(13));
                           int absences15 = Integer.parseInt(c.findAbsences(14));
                           int absences16 = Integer.parseInt(c.findAbsences(15));
                           int absences17 = Integer.parseInt(c.findAbsences(16));
                           int absences18 = Integer.parseInt(c.findAbsences(17));
                           int absences19 = Integer.parseInt(c.findAbsences(18));
                           int absences20 = Integer.parseInt(c.findAbsences(19));
                           int absences21 = Integer.parseInt(c.findAbsences(20));
                           int absences22 = Integer.parseInt(c.findAbsences(21));
                           int absences23 = Integer.parseInt(c.findAbsences(22));
                           int absences24 = Integer.parseInt(c.findAbsences(23));
                           if(c.getLine(studentName) == 0){
                              absences1 += 1;
                           } else if(c.getLine(studentName) == 1){
                              absences2 += 1;
                           } else if(c.getLine(studentName) == 2){
                              absences3 += 1;
                           } else if(c.getLine(studentName) == 3){
                              absences4 += 1;
                           } else if(c.getLine(studentName) == 4){
                              absences5 += 1;
                           } else if(c.getLine(studentName) == 5){
                              absences6 += 1;
                           } else if(c.getLine(studentName) == 6){
                              absences7 += 1;   
                           } else if(c.getLine(studentName) == 7){
                              absences8 += 1;
                           } else if(c.getLine(studentName) == 8){
                              absences9 += 1;   
                           } else if(c.getLine(studentName) == 9){
                              absences10 += 1;   
                           } else if(c.getLine(studentName) == 10){
                              absences11 += 1;   
                           } else if(c.getLine(studentName) == 11){
                              absences12 += 1;   
                           } else if(c.getLine(studentName) == 12){
                              absences13 += 1;   
                           } else if(c.getLine(studentName) == 13){
                              absences14 += 1;   
                           } else if(c.getLine(studentName) == 14){
                              absences15 += 1;   
                           } else if(c.getLine(studentName) == 15){
                              absences16 += 1;   
                           } else if(c.getLine(studentName) == 16){
                              absences17 += 1;   
                           } else if(c.getLine(studentName) == 17){
                              absences18 += 1;   
                           } else if(c.getLine(studentName) == 18){
                              absences19 += 1;
                           } else if(c.getLine(studentName) == 19){
                              absences20 += 1;      
                           } else if(c.getLine(studentName) == 20){
                              absences21 += 1;
                           } else if(c.getLine(studentName) == 21){
                              absences22 += 1;
                           } else if(c.getLine(studentName) == 22){
                              absences23 += 1;
                           } else {
                              absences24 += 1;         
                           }
                           String absencesComp = absences1 + "\n" + absences2 + "\n" + absences3 + "\n" + absences4 + "\n" + absences5 + "\n" + absences6 + "\n" + absences7 + "\n" + absences8 + "\n" + absences9 + "\n" + absences10 + "\n" + absences11 + "\n" + absences12 + "\n" + absences13 + "\n" + absences14 + "\n" + absences15 + "\n" + absences16 + "\n" + absences17 + "\n" + absences18 + "\n" + absences19 + "\n" + absences20 + "\n" + absences21 + "\n" + absences22 + "\n" + absences23 + "\n" + absences24;
                           c.changeAbsences(absencesComp);
                           break;
                        } else if(attendanceAnswer == 1){
                           Scanner dismissalsReader = new Scanner(new File("dismissals.txt")); 
                           int dismissals1 = Integer.parseInt(c.findDismissals(0));
                           int dismissals2 = Integer.parseInt(c.findDismissals(1));
                           int dismissals3 = Integer.parseInt(c.findDismissals(2));
                           int dismissals4 = Integer.parseInt(c.findDismissals(3));
                           int dismissals5 = Integer.parseInt(c.findDismissals(4));
                           int dismissals6 = Integer.parseInt(c.findDismissals(5));
                           int dismissals7 = Integer.parseInt(c.findDismissals(6));
                           int dismissals8 = Integer.parseInt(c.findDismissals(7));
                           int dismissals9 = Integer.parseInt(c.findDismissals(8));
                           int dismissals10 = Integer.parseInt(c.findDismissals(9));
                           int dismissals11 = Integer.parseInt(c.findDismissals(10));
                           int dismissals12 = Integer.parseInt(c.findDismissals(11));
                           int dismissals13 = Integer.parseInt(c.findDismissals(12));
                           int dismissals14 = Integer.parseInt(c.findDismissals(13));
                           int dismissals15 = Integer.parseInt(c.findDismissals(14));
                           int dismissals16 = Integer.parseInt(c.findDismissals(15));
                           int dismissals17 = Integer.parseInt(c.findDismissals(16));
                           int dismissals18 = Integer.parseInt(c.findDismissals(17));
                           int dismissals19 = Integer.parseInt(c.findDismissals(18));
                           int dismissals20 = Integer.parseInt(c.findDismissals(19));
                           int dismissals21 = Integer.parseInt(c.findDismissals(20));
                           int dismissals22 = Integer.parseInt(c.findDismissals(21));
                           int dismissals23 = Integer.parseInt(c.findDismissals(22));
                           int dismissals24 = Integer.parseInt(c.findDismissals(23));
                           if(c.getLine(studentName) == 0){
                              dismissals1 += 1;
                           } else if(c.getLine(studentName) == 1){
                              dismissals2 += 1;
                           } else if(c.getLine(studentName) == 2){
                              dismissals3 += 1;
                           } else if(c.getLine(studentName) == 3){
                              dismissals4 += 1;
                           } else if(c.getLine(studentName) == 4){
                              dismissals5 += 1;
                           } else if(c.getLine(studentName) == 5){
                              dismissals6 += 1;
                           } else if(c.getLine(studentName) == 6){
                              dismissals7 += 1;   
                           } else if(c.getLine(studentName) == 7){
                              dismissals8 += 1;
                           } else if(c.getLine(studentName) == 8){
                              dismissals9 += 1;   
                           } else if(c.getLine(studentName) == 9){
                              dismissals10 += 1;   
                           } else if(c.getLine(studentName) == 10){
                              dismissals11 += 1;   
                           } else if(c.getLine(studentName) == 11){
                              dismissals12 += 1;   
                           } else if(c.getLine(studentName) == 12){
                              dismissals13 += 1;   
                           } else if(c.getLine(studentName) == 13){
                              dismissals14 += 1;   
                           } else if(c.getLine(studentName) == 14){
                              dismissals15 += 1;   
                           } else if(c.getLine(studentName) == 15){
                              dismissals16 += 1;   
                           } else if(c.getLine(studentName) == 16){
                              dismissals17 += 1;   
                           } else if(c.getLine(studentName) == 17){
                              dismissals18 += 1;   
                           } else if(c.getLine(studentName) == 18){
                              dismissals19 += 1;
                           } else if(c.getLine(studentName) == 19){
                              dismissals20 += 1;      
                           } else if(c.getLine(studentName) == 20){
                              dismissals21 += 1;
                           } else if(c.getLine(studentName) == 21){
                              dismissals22 += 1;
                           } else if(c.getLine(studentName) == 22){
                              dismissals23 += 1;
                           } else {
                              dismissals24 += 1;         
                           }
                           String dismissalsComp = dismissals1 + "\n" + dismissals2 + "\n" + dismissals3 + "\n" + dismissals4 + "\n" + dismissals5 + "\n" + dismissals6 + "\n" + dismissals7 + "\n" + dismissals8 + "\n" + dismissals9 + "\n" + dismissals10 + "\n" + dismissals11 + "\n" + dismissals12 + "\n" + dismissals13 + "\n" + dismissals14 + "\n" + dismissals15 + "\n" + dismissals16 + "\n" + dismissals17 + "\n" + dismissals18 + "\n" + dismissals19 + "\n" + dismissals20 + "\n" + dismissals21 + "\n" + dismissals22 + "\n" + dismissals23 + "\n" + dismissals24;
                           c.changeDismissals(dismissalsComp);
                           break;
                        } else if(attendanceAnswer == 2){
                           Scanner tardiesReader = new Scanner(new File("tardies.txt")); 
                           int tardies1 = Integer.parseInt(c.findTardies(0));
                           int tardies2 = Integer.parseInt(c.findTardies(1));
                           int tardies3 = Integer.parseInt(c.findTardies(2));
                           int tardies4 = Integer.parseInt(c.findTardies(3));
                           int tardies5 = Integer.parseInt(c.findTardies(4));
                           int tardies6 = Integer.parseInt(c.findTardies(5));
                           int tardies7 = Integer.parseInt(c.findTardies(6));
                           int tardies8 = Integer.parseInt(c.findTardies(7));
                           int tardies9 = Integer.parseInt(c.findTardies(8));
                           int tardies10 = Integer.parseInt(c.findTardies(9));
                           int tardies11 = Integer.parseInt(c.findTardies(10));
                           int tardies12 = Integer.parseInt(c.findTardies(11));
                           int tardies13 = Integer.parseInt(c.findTardies(12));
                           int tardies14 = Integer.parseInt(c.findTardies(13));
                           int tardies15 = Integer.parseInt(c.findTardies(14));
                           int tardies16 = Integer.parseInt(c.findTardies(15));
                           int tardies17 = Integer.parseInt(c.findTardies(16));
                           int tardies18 = Integer.parseInt(c.findTardies(17));
                           int tardies19 = Integer.parseInt(c.findTardies(18));
                           int tardies20 = Integer.parseInt(c.findTardies(19));
                           int tardies21 = Integer.parseInt(c.findTardies(20));
                           int tardies22 = Integer.parseInt(c.findTardies(21));
                           int tardies23 = Integer.parseInt(c.findTardies(22));
                           int tardies24 = Integer.parseInt(c.findTardies(23));
                           if(c.getLine(studentName) == 0){
                              tardies1 += 1;
                           } else if(c.getLine(studentName) == 1){
                              tardies2 += 1;
                           } else if(c.getLine(studentName) == 2){
                              tardies3 += 1;
                           } else if(c.getLine(studentName) == 3){
                              tardies4 += 1;
                           } else if(c.getLine(studentName) == 4){
                              tardies5 += 1;
                           } else if(c.getLine(studentName) == 5){
                              tardies6 += 1;
                           } else if(c.getLine(studentName) == 6){
                              tardies7 += 1;   
                           } else if(c.getLine(studentName) == 7){
                              tardies8 += 1;
                           } else if(c.getLine(studentName) == 8){
                              tardies9 += 1;   
                           } else if(c.getLine(studentName) == 9){
                              tardies10 += 1;   
                           } else if(c.getLine(studentName) == 10){
                              tardies11 += 1;   
                           } else if(c.getLine(studentName) == 11){
                              tardies12 += 1;   
                           } else if(c.getLine(studentName) == 12){
                              tardies13 += 1;   
                           } else if(c.getLine(studentName) == 13){
                              tardies14 += 1;   
                           } else if(c.getLine(studentName) == 14){
                              tardies15 += 1;   
                           } else if(c.getLine(studentName) == 15){
                              tardies16 += 1;   
                           } else if(c.getLine(studentName) == 16){
                              tardies17 += 1;   
                           } else if(c.getLine(studentName) == 17){
                              tardies18 += 1;   
                           } else if(c.getLine(studentName) == 18){
                              tardies19 += 1;
                           } else if(c.getLine(studentName) == 19){
                              tardies20 += 1;      
                           } else if(c.getLine(studentName) == 20){
                              tardies21 += 1;
                           } else if(c.getLine(studentName) == 21){
                              tardies22 += 1;
                           } else if(c.getLine(studentName) == 22){
                              tardies23 += 1;
                           } else {
                              tardies24 += 1;         
                           }
                           String tardiesComp = tardies1 + "\n" + tardies2 + "\n" + tardies3 + "\n" + tardies4 + "\n" + tardies5 + "\n" + tardies6 + "\n" + tardies7 + "\n" + tardies8 + "\n" + tardies9 + "\n" + tardies10 + "\n" + tardies11 + "\n" + tardies12 + "\n" + tardies13 + "\n" + tardies14 + "\n" + tardies15 + "\n" + tardies16 + "\n" + tardies17 + "\n" + tardies18 + "\n" + tardies19 + "\n" + tardies20 + "\n" + tardies21 + "\n" + tardies22 + "\n" + tardies23 + "\n" + tardies24;
                           c.changeTardies(tardiesComp);
                           break;
                        } else if(attendanceAnswer == 3){
                           break;
                        }
                     }
                  } else if (answer == 4){   
                     break;
                  }
              }
         } else if(c.checkAccount(c, enteredUsername, enteredPassword) == null){
            JOptionPane.showMessageDialog(null,
                  "Invalid login.",
                  "",
                  JOptionPane.ERROR_MESSAGE);
         } else {
            while(true){
               name = c.findName(c.findAccountNumber(enteredUsername, enteredPassword));
               Object[]	options1	=	{"My Info", "Academics", "Log Off"};
          
               int answer1	=	JOptionPane.showOptionDialog(null,	
      				name,
      				"Andover Public Schools 2019 - 2020",
      				JOptionPane.YES_NO_CANCEL_OPTION,	
      				JOptionPane.PLAIN_MESSAGE,	null,	options1,	
      				options1[2]);
      	
               if(answer1 == -1){ //user exited box instead of making a choice
                  return;
               } else if(answer1 == 0){
                  String YOG = c.findYOG(c.findAccountNumber(enteredUsername, enteredPassword));
                  String absenceCount = c.findAbsences(c.findAccountNumber(enteredUsername, enteredPassword));
                  String tardyCount = c.findTardies(c.findAccountNumber(enteredUsername, enteredPassword));
                  String dismissalCount = c.findDismissals(c.findAccountNumber(enteredUsername, enteredPassword));
                  JOptionPane.showMessageDialog(null,
                           name + "\nYOG: " + YOG + "\nAbsences: " +absenceCount + "\nTardies: " + tardyCount + "\nDismissals: " + dismissalCount, //Shows all of user's personal info, a compilation of data from four different files
                           "",
                           JOptionPane.PLAIN_MESSAGE);
               } else if(answer1 == 1){
                  studentsGrade = c.findGrade(c.findAccountNumber(enteredUsername, enteredPassword));
                  JOptionPane.showMessageDialog(null,
                           "\nClasses currently enrolled in: Java Programming \nTeacher: Ms. DiBenedetto \nGrade: " + studentsGrade + "%", //Shows grade
                           "",
                           JOptionPane.PLAIN_MESSAGE);
               } else {
                  break;
               }
            }
         }
      }
   }
}