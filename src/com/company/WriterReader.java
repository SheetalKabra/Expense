package com.company;
import com.company.model.Expense;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.company.io.InputOutputJava;

public class WriterReader {
    //public Expense expense;
    public InputOutputJava io;
    public WriterReader(){
        io = new InputOutputJava();
    }
    public File createFile(){
        File f = null;
        try{
            f = new File("Expense.txt");
            if (f.createNewFile()) {
                System.out.println("File " + f.getName() + " is created successfully.");
            } else {
                System.out.println("File is already exist in the directory.");
            }
        }catch(IOException e){
            System.out.println("Unexpected error occured");
            System.out.println(e);
        }
        return f;
    }
     public boolean writeObject(Expense expense){
        File f = createFile();
        if(f == null){
            return false;
        }
        try{
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream o = new ObjectOutputStream(fo);
            o.writeObject(expense);
            o.close();
            fo.close();
            return true;
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch(IOException e){
            System.out.println("Error initializing stream");
        }
         return false;
     }

    public boolean readObject(){
        try{
            File f = new File("Expense.txt");
            if(f.length()  > 0){
                FileInputStream fi = new FileInputStream("Expense.txt");
                ObjectInputStream oi = new ObjectInputStream(fi);
                Expense expense1 = (Expense) oi.readObject();
                io.printMessageln("Item is");
                io.printMessage(expense1.toString());
                oi.close();
                fi.close();
                return true;
            }else{
                return false;
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch(IOException e){
            System.out.println("Error initializing stream");
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
