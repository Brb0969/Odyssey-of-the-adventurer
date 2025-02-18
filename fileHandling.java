import java.io.File; 
import java.io.IOException;  
import java.util.*;
import java.io.FileWriter;
import java.io.FileNotFoundException;


public class fileHandling {

    public void createFile(String name)

    {  //creation of file to store customer details
            try {
      File myObj = new File(name+".txt"); //creation of File object
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

       


    }

    public void writeFile(String fName, String cName,int cAge)
    {
        try{
            FileWriter f2=new FileWriter(fName+".txt",true);
            f2.write("The name is   "+cName);
            f2.write("\n");
            f2.write("The Age is"+cAge);
            f2.write("\n");


            f2.close();
                }
                catch(IOException e)
                {
                    System.out.println("An error has occured");
                    e.printStackTrace();
                }  


    }

    public void readFromFile(String fName)
    {
        try
        {
            File f2=new File(fName+".txt");
            Scanner sc=new Scanner(f2);
            while (sc.hasNextLine()) 
            {
                String data=sc.nextLine();
                System.out.println(data);
            }
        }catch(FileNotFoundException e)
        {
            System.out.println("An error has occured");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        fileHandling obj=new fileHandling();
        System.out.println("Enter the name of the file you want to create");
        String fileName=sc.nextLine();
        obj.createFile(fileName);
        int i=0;
        while(i<=5)
        { System.out.println("\n");
        
        System.out.println("Enter the Customer Name");
        String customerName=sc.nextLine();
        System.out.println("Enter the customer's age");
        int customerAge=sc.nextInt();
     
        obj.writeFile(fileName, customerName, customerAge);
        i++;
    }

    System.out.println("The Customer's details are");

    obj.readFromFile(fileName);
    

}
}
