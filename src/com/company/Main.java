package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;


class Task{
    private Date theDate;
    private String theCat;
    private double theAmount;
    private String theDesc;
    private String theMerchant;
    private String thePaymentMethod;
    private String theTags;
    Task(Date date, String cat, double amount, String desc,String merchant, String paymentMethod, String tags){
        theDate = date;
        theCat = cat;
        theAmount = amount;
        theDesc = desc;
        theMerchant = merchant;
        thePaymentMethod = paymentMethod;
        theTags = tags;
    }
    public String getItem(){
        return theDate+ ", "+theCat+", "+theAmount+", "+", "+theDesc+", "+theMerchant+", "+thePaymentMethod+", "+theTags;
    }
}


public class Main {
    public enum menuItem {ADD_EXPENSE, DELETE_EXPENSE, SHOW_EXPENSE, UPDATE_EXPENSE, LEAVE_PROGRAM, NOT_VALID_ITEM};
    public static List<String> currentList = new ArrayList<String>();
    public static Date StringToDate(String dob) throws ParseException {
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object
        Date date = formatter.parse(dob);
        System.out.println("Date object value: " + date);
        return date;
    }

    public static void main (String[] args) throws ParseException  {
	    Main main = new Main();
        menuItem m;
        do{
            m = main.printMenu();
            switch (m){
                case ADD_EXPENSE: main.addExpense();break;
                case SHOW_EXPENSE: main.showExpense();break;
                case DELETE_EXPENSE: main.deleteExpense();break;
                case LEAVE_PROGRAM: System.out.println("Goodbye");break;
                default: System.out.println("Enter valid option");
            }
        }while(m != menuItem.LEAVE_PROGRAM);

    }

    public menuItem printMenu(){
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("Main menu:");
        System.out.println("1. Add an expense");
        System.out.println("2. Show list of expenses");
        System.out.println("3. Delete expense");
        System.out.println("4. Leave a program");
        System.out.println("---------------------------------------------");
        System.out.print("Enter a choice:");
        Scanner sc = new Scanner(System.in);
        int menuItem = sc.nextInt();
        switch (menuItem){
            case 1: return Main.menuItem.ADD_EXPENSE;
            case 2: return Main.menuItem.SHOW_EXPENSE;
            case 3: return Main.menuItem.DELETE_EXPENSE;
            case 4: return Main.menuItem.LEAVE_PROGRAM;
            default: return Main.menuItem.NOT_VALID_ITEM;
        }
    }

    public void showExpense(){
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("To-Do List:");
        int number=0;
        for(String item: currentList){
            System.out.println(++number+ ". " +item);

        }
        System.out.println("---------------------------------------------");
    }

    public void addExpense() throws ParseException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expense:\n===========");
        System.out.print("Enter Date:");
        String dateEntered = sc.next();
        Date convertDate = Main.StringToDate(dateEntered);
        System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(convertDate));
        System.out.print("Enter category:");
        String cat = sc.next();
        System.out.print("Enter amount:");
        double amount = sc.nextDouble();
        System.out.print("Enter description:");
        String desc = sc.next();
        System.out.print("Enter merchant:");
        String merchant = sc.next();
        System.out.print("Enter payment method:");
        String paymentMethod = sc.next();
        System.out.print("Enter tags:");
        String tags = sc.next();
        Task task = new Task(convertDate, cat,amount, desc, merchant,paymentMethod, tags);
        String itemList = task.getItem();
        currentList.add(itemList);
        System.out.println("Item has been added into the expense list.");
        System.out.println("========================");

    }

    public boolean deleteExpense(){
        if(currentList.isEmpty()){
            System.out.println("Sorry, Expense list is empty");
            return false;
        }
        System.out.println("Enter expense number you want to delete");
        Scanner sc = new Scanner(System.in);
        int indexTodelete = sc.nextInt();
        currentList.remove(indexTodelete-1);
        System.out.println("Item "+indexTodelete+" has been deleted from the expense list.");
        return true;
    }
}
