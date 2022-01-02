package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.company.model.Expense;
import com.company.io.InputOutputJava;
import com.company.WriterReader;

public class ExpenseManager {
    private InputOutputJava io;
    public ExpenseManager(){
        io = new InputOutputJava();
    }

    public enum menuItem {
        ADD_EXPENSE, DELETE_EXPENSE, SHOW_EXPENSE, UPDATE_EXPENSE, LEAVE_PROGRAM, NOT_VALID_ITEM;

        public static menuItem getMenuItemFromInt(int input) {
            switch (input){
                case 1: return menuItem.ADD_EXPENSE;
                case 2: return menuItem.SHOW_EXPENSE;
                case 3: return menuItem.DELETE_EXPENSE;
                case 4: return menuItem.LEAVE_PROGRAM;
                default: return menuItem.NOT_VALID_ITEM;
            }

        }
    };

    public static List<String> currentList = new ArrayList<>();
    public Date StringToDate(String dob) throws ParseException {
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object
        Date date = formatter.parse(dob);
        io.printMessageln("Date object value: " + date);
        return date;
    }

    public void start() throws ParseException{
        menuItem m;
        do{
            m = printMenu();
            switch (m){
                case ADD_EXPENSE: addExpense();break;
                case SHOW_EXPENSE: showExpense();break;
                case DELETE_EXPENSE: deleteExpense();break;
                case LEAVE_PROGRAM: io.printMessageln("Goodbye");break;
                default: io.printMessageln("Enter valid option");
            }
        }while(m != menuItem.LEAVE_PROGRAM);
    }

    public menuItem printMenu(){
        io.printMessageln("");
        io.printMessageln("---------------------------------------------");
        io.printMessageln("Main menu:");
        io.printMessageln("1. Add an expense");
        io.printMessageln("2. Show list of expenses");
        io.printMessageln("3. Delete expense");
        io.printMessageln("4. Leave a program");
        io.printMessageln("---------------------------------------------");
        io.printMessage("Enter a choice:");
        Scanner sc = new Scanner(System.in);
        int menuItemInput = sc.nextInt();
        return menuItem.getMenuItemFromInt(menuItemInput);
    }

    public void showExpense(){
        WriterReader r = new WriterReader();
        io.printMessageln("");
        io.printMessageln("---------------------------------------------");
        boolean isItemExist = r.readObject();
        if(!isItemExist){
            io.printMessageln("Expense list is empty!!!");
        }

        io.printMessageln("---------------------------------------------");
    }

    public void addExpense() throws ParseException {
        Scanner sc = new Scanner(System.in);
        io.printMessage("Enter the expense:\n===========");
        io.printMessage("Enter Date:");
        String dateEntered = sc.next();
        Date convertDate = StringToDate(dateEntered);
        io.printMessage("Enter category:");
        String cat = sc.next();
        io.printMessage("Enter amount:");
        double amount = sc.nextDouble();
        io.printMessage("Enter description:");
        String desc = sc.next();
        io.printMessage("Enter merchant:");
        String merchant = sc.next();
        io.printMessage("Enter payment method:");
        String paymentMethod = sc.next();
        io.printMessage("Enter tags:");
        String tags = sc.next();
        Expense expense = new Expense();
        expense.setTheDate(convertDate);
        expense.setTheCat(cat);
        expense.setTheAmount(amount);
        expense.setTheDesc(desc);
        expense.setTheMerchant(merchant);
        expense.setThePaymentMethod(paymentMethod);
        expense.setTheTags(tags);
        WriterReader w = new WriterReader();
        w.writeObject(expense);
        //w.readObject();
        //String itemList = expense.getItem();
        //currentList.add(itemList);

        io.printMessageln("Item has been added into the expense list.");
        io.printMessageln("========================");

    }

    public boolean deleteExpense(){
        if(currentList.isEmpty()){
            io.printMessageln("Sorry, Expense list is empty");
            return false;
        }
        io.printMessageln("Enter expense number you want to delete");
        Scanner sc = new Scanner(System.in);
        int indexTodelete = sc.nextInt();
        currentList.remove(indexTodelete-1);
        io.printMessageln("Item "+indexTodelete+" has been deleted from the expense list.");
        return true;
    }

}
