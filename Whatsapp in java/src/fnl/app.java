package fnl;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

 interface Nameable {
    String getObjName();
}

 class SharedIntegerHolder {
    public static int countobj= 0;    //For counting how many object created
}
 class idcreator {
    private static int nextId = 1;
    public static int generateId() {
        return nextId++;
    }   
}
class cat  implements Nameable{
    static int id;
    private String objName;
  static  String  [] [] quotes = new String[2][2];
    public cat(String objN) {
     
        quotes[0][0] = "nasilsin 1";
        quotes[0][1] = "nasilsin 2";
        quotes[1][0] = "nasilsin 3";
        quotes[1][1] = "nasilsin 4";

        id = idcreator.generateId();
        center.AddMe(cat.this,objN);
        SharedIntegerHolder.countobj++;
        this.objName = objN;
        String FolderName = getObjName()+".txt";    //creating the object folder
        try {
           FileOutputStream fos = new FileOutputStream(FolderName);
           PrintWriter pw = new PrintWriter(fos);
          }           
          catch (IOException e) {
          }
    }
    public static  int getId() {
        return id;
    }
    @Override
    public String getObjName() {
        return objName;
    }
}
class cup implements Nameable{
    private static int id;
    private String objName;
  static  String  [] [] quotes = new String[2][2];

    public cup(String objN) {
        
        quotes[0][0] = "nasilsin cup1";
        quotes[0][1] = "nasilsin cup2";
        quotes[1][0] = "nasilsin cup3";
        quotes[1][1] = "nasilsin cup4";
        id = idcreator.generateId();
        center.AddMe(cup.this,objN);
        SharedIntegerHolder.countobj++;

        this.objName = objN;
        String FolderName = getObjName()+".txt";      //creating the object folder
        try {
            FileOutputStream fos = new FileOutputStream(FolderName);
            PrintWriter pw = new PrintWriter(fos);
           }           
           catch (IOException e) {
           }
    }
    public static int getId() {
        return id;
    }
    @Override
    public String getObjName() {
        return objName;
    }

}
 class car implements Nameable {
    private static int id;
    private String objName;
static String  [] [] quotes = new String[2][2];    

    public car(String objN) {
        quotes[0][0] = "nasilsin car1";
        quotes[0][1] = "nasilsin car2";
        quotes[1][0] = "nasilsin car3";
        quotes[1][1] = "nasilsin car4";
        id = idcreator.generateId();
        center.AddMe(car.this,objN);
        SharedIntegerHolder.countobj++;
        

        this.objName = objN;
        String FolderName = getObjName()+".txt";         //creating the object folder    
        try {
            FileOutputStream fos = new FileOutputStream(FolderName);
            PrintWriter pw = new PrintWriter(fos);
           }           
           catch (IOException e) {
           }
    }
    public static int getId() {
        return id;
    }
    @Override
    public String getObjName() {
        return objName;
    }
}
class cloud implements Nameable {
    private static int id;
    private String objName;
  static  String  [] [] quotes = new String[2][2]; 

    public cloud(String objN) {
        quotes[0][0] = "nasilsin cloud1";
        quotes[0][1] = "nasilsin cloud2";
        quotes[1][0] = "nasilsin cloud3";
        quotes[1][1] = "nasilsin cloud4";
        id = idcreator.generateId();
        center.AddMe(cloud.this,objN);
        SharedIntegerHolder.countobj++;
        this.objName = objN;
        String FolderName = getObjName()+".txt"; //creating the object folder
                
        try {
            FileOutputStream fos = new FileOutputStream(FolderName);
            PrintWriter pw = new PrintWriter(fos);
           }           
           catch (IOException e) {
           }

    }
    public static int getId() {
        return id;
    }
    @Override
    public String getObjName() {
        return objName;
    }
}
 class center {
   public static ArrayList<Object> comunicators = new ArrayList<Object>();
     static String msg ;
     public static void AddMe(Object obj,String name){
    comunicators.add(obj); 
    try{
        FileOutputStream fos = new FileOutputStream("log.txt",true);
        PrintWriter pw = new PrintWriter(fos);
        if(obj.getClass().equals(cat.class)){
         msg = name +":" + cat.getId();
        }
        if(obj.getClass()==car.class){
          msg = name +":" + ((car) obj).getId();
        }
        if(obj.getClass()==cloud.class){
          msg = name +":" + ((cloud) obj).getId();
        }
        if(obj.getClass()==cup.class){
          msg = name +":" + ((cup) obj).getId();
        }
        pw.println(msg);
       pw.flush();
    }
    catch(IOException e){}
}
public static void CopyFile(){
            ArrayList<String> namesList = new ArrayList<>();
            int  i =0;
try{
	    Scanner fileIn = new Scanner(new File("log.txt"));
        while(fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                 String[] parts = line.split(":");
                
                 if (parts.length > 0) {
                    String name = parts[0];
                    namesList.add(name);
                }
        }
          while(i<namesList.size()){
          String loc = namesList.get(i) + ".txt";
          PrintWriter pw = new PrintWriter(loc); 
        Scanner nScanner = new Scanner(new File("log.txt"));

            while(nScanner.hasNextLine()){
                String lines = nScanner.nextLine();
                pw.write(lines+ " Just assigned"+System.lineSeparator());
                pw.flush();
            }
            i++;
          }
}
catch(IOException e){}
}
public static void SendMessage(String s,Object obj){     
    int y = 0;
                ArrayList<Integer> mesageİdList = new ArrayList<>();
                ArrayList<String> mesageNameList = new ArrayList<>();
                String[] splitparts = s.split(":");
                String TheMessage = splitparts[2];
                String [] multiplereciever = splitparts[1].split(",");
                int [] desid = new int [multiplereciever.length];
                while(y<multiplereciever.length){
                    if(!(splitparts[1].equals("all"))){
                        desid[y] =Integer.parseInt(multiplereciever[y]);
                    }
                    y++;
                }
                Random r = new Random();
                ArrayList<ArrayList<String>> quotes = new ArrayList<>();
               int  i =0;
               int c = 0;
               int f = 0;
               int o =0;     
        try{
	    Scanner fileIn = new Scanner(new File("log.txt"));
        while(fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                 String[] parts = line.split(":");
                
                 if (parts.length > 0) {
                    int ids = Integer.parseInt(parts[1]); 
                    mesageİdList.add(ids);
                }
                if (parts.length > 0) {
                    String Name = parts[0];
                    mesageNameList.add(Name);
                }
        }            
        //for the sender
                        
                while(i!=SharedIntegerHolder.countobj){ 
                    while(f!=Integer.parseInt(splitparts[1])){
                        f++;
                    }
                    if( mesageİdList.get(i) == Integer.parseInt(splitparts[0])){
                       
                       FileOutputStream fos = new FileOutputStream(mesageNameList.get(i)+".txt",true);
                        FileOutputStream logw = new FileOutputStream("log.txt",true);
                       PrintWriter pw2 = new PrintWriter(fos);
                        PrintWriter pwlog = new PrintWriter(logw);       
                        
                        pw2.write("You send to user " + "'" +mesageNameList.get(f-1)+"'" + "'" +TheMessage+"'" + System.lineSeparator());
                        pwlog.write(s +System.lineSeparator());
                        pwlog.flush();
                        pw2.flush();
                        break;
                    }
                    else{
                        i++;
                    }                   
                } 
                            //for the reciever
                 while(c!=SharedIntegerHolder.countobj){ 
                    if( mesageİdList.get(c) == Integer.parseInt(multiplereciever[o])){
                       
                        FileOutputStream fos2 = new FileOutputStream(mesageNameList.get(c)+".txt",true);
                        PrintWriter pw1 = new PrintWriter(fos2);                      
                        pw1.write("The user " + "'" +mesageNameList.get(i)+"'" + " Sends you " + "'" +TheMessage+"'" + System.lineSeparator());
                        pw1.flush();
                        break;
                    }
                    else{
                        c++;
                    }
                }
        i=0;
        c=0;
        f=0;
    }
        catch(IOException e){}
        catch(NumberFormatException e){   
          if(splitparts[1].equals("all")){
            if(splitparts[2].equals("quote")){
                                    
    try{
        if(obj.getClass().equals(cat.class)){
         TheMessage = cat.quotes[r.nextInt(2)][r.nextInt(2)];
        }
        if(obj.getClass()==car.class){
          TheMessage = car.quotes[r.nextInt(2)][r.nextInt(2)];
        }
        if(obj.getClass()==cloud.class){
          TheMessage = cloud.quotes[r.nextInt(2)][r.nextInt(2)];
        }
        if(obj.getClass()==cup.class){
        TheMessage = cup.quotes[r.nextInt(2)][r.nextInt(2)];
        }
                   FileOutputStream logw = new FileOutputStream("log.txt",true);
                   PrintWriter pwlog = new PrintWriter(logw);  
                    pwlog.write(mesageNameList.get(i)+ ":all:" +TheMessage+ System.lineSeparator());
                    pwlog.close();
                              
             
                    while(c!=SharedIntegerHolder.countobj){
                     FileOutputStream fos2 = new FileOutputStream(mesageNameList.get(c)+".txt",true);
                        PrintWriter pw1 = new PrintWriter(fos2);                 
                        pw1.write("The user " + "'" +mesageNameList.get(i)+"'" + " Sends quote " + "'" +TheMessage+"'" + System.lineSeparator());
                        pw1.flush();
                        c++;
                }                      
            }
                catch(IOException a){}
                
        }
        else{                    
                try{
                   FileOutputStream logw = new FileOutputStream("log.txt",true);
                   PrintWriter pwlog = new PrintWriter(logw);  
                    pwlog.write(mesageNameList.get(i)+ ":all:" +TheMessage+ System.lineSeparator());
                    pwlog.close();
                    

                    while(c!=SharedIntegerHolder.countobj){
                     FileOutputStream fos2 = new FileOutputStream(mesageNameList.get(c)+".txt",true);
                        PrintWriter pw1 = new PrintWriter(fos2);

                        pw1.write("The user " + "'" +mesageNameList.get(i)+"'" + " Sends all " + "'" +TheMessage+"'" + System.lineSeparator());
                        pw1.flush();
                        c++;
                }                      
            }
                catch(IOException a){}
        }
       }
       else{
        int ul = 0;
        int p =0;
        if(splitparts[2].equals("quote")){

            try{
                if(obj.getClass().equals(cat.class)){
         TheMessage = cat.quotes[r.nextInt(2)][r.nextInt(2)];
         ul = cat.getId();
        }
        if(obj.getClass()==car.class){
          TheMessage = car.quotes[r.nextInt(2)][r.nextInt(2)];
          ul=car.getId();
        }
        if(obj.getClass()==cloud.class){
          TheMessage = cloud.quotes[r.nextInt(2)][r.nextInt(2)];
          ul=cloud.getId();
        }
        if(obj.getClass()==cup.class){
        TheMessage = cup.quotes[r.nextInt(2)][r.nextInt(2)];
        ul=cup.getId();
        }
                   FileOutputStream logw = new FileOutputStream("log.txt",true);
                   PrintWriter pwlog = new PrintWriter(logw);  
                    pwlog.write(mesageNameList.get(ul)+ ":"+mesageİdList.get(ul)+":"+TheMessage+ System.lineSeparator());
                    pwlog.close();
                   
                     FileOutputStream fos2 = new FileOutputStream(mesageNameList.get(ul)+".txt",true);
                        PrintWriter pw1 = new PrintWriter(fos2);
                        if(TheMessage.equals("quote")){                            
                        }
                        pw1.write("The user " + "'" +mesageNameList.get(ul)+"'" + " Sends all " + "'" +TheMessage+"'" + System.lineSeparator());
                        pw1.flush();                         
            }
                catch(IOException a){}
        }
       }  
    }
 }
}
public class app {
    public static void main(String[] args) {
 
        car car1 = new car("car1");
        car car2 = new car("car2");
       
        cat cat1 = new cat("cat1");

        cup cup1 = new cup("cup1");
        cup cup2 = new cup("cup2");
        cup cup3 = new cup("cup3");
        
        cloud cloud1 = new cloud("cloud1");
       
        center.CopyFile();

        center.SendMessage("1:2:merhaba 2",car1);
        center.SendMessage("2:1:merhaba 1",car2);
        center.SendMessage("3:4:merhaba 4",cat1);
        center.SendMessage("1:3:merhaba 3",car1);
        center.SendMessage("1:2,3,4:ananizi", car1);
     
        center.SendMessage("1:all:herkese selam 1",car1);
        center.SendMessage("2:all:herkese selam 2",car2);
        center.SendMessage("1:all:quote", car1);

    }
}

/*
 * \\-------------------EXPLANATİON------------------------------//
 *
 * 
 * 
 * First ı have classes cat,car,cloud,cup every obect has theid unique id and name my first method is unique id giver its function is when object creted it gives that object unique id.
 * and then when object cretaed it also create a txt file with same name that object has after create the file ı have log file ım printing that this object has entered the system to the log file,
 * after every object created ı am copying the log file to all object file so every object can know who is in system who is not,for printing and all other things at that point ı recieve the object from,
 * object list (that ı assign automaticly when object created its an array list).
 * When it comes to send mesage ı have method that do this ı give this method a string "sender id:reciever id:mesage" ım spliting this to 3 pieces that ı can use the unique id's and names after doing this,
 * ıt's accesing the object's folder with name and it prints what mesage user wants to send.
 * if object wants to send mesage the all other object it can use "all".
 * 
 * Every class has their quotes in their classes if sender wants to send a quote it must written in the mesage after that the system randomly choosing a quote .
 *  
 * 
 * 
 */