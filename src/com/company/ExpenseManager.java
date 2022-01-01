package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.company.model.Expense;

public class ExpenseManager {

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
    public static Date StringToDate(String dob) throws ParseException {
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object
        Date date = formatter.parse(dob);
        System.out.println("Date object value: " + date);
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
        int menuItemInput = sc.nextInt();
        return menuItem.getMenuItemFromInt(menuItemInput);
    }

    public void showExpense(){
        System.out.println();
        System.out.println("---------------------------------------------");
        if(!currentList.isEmpty()){
            System.out.println("To-Do List:");
            int number=0;
            for(String item: currentList){
                System.out.println(++number+ ". " +item);
            }
        }else{
            System.out.println("Expense list is empty!!!");
        }

        System.out.println("---------------------------------------------");
    }

    public void addExpense() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expense:\n===========");
        System.out.print("Enter Date:");
        String dateEntered = sc.next();
        Date convertDate = StringToDate(dateEntered);
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
        Expense expense = new Expense();
        expense.setTheDate(convertDate);
        expense.setTheCat(cat);
        expense.setTheAmount(amount);
        expense.setTheDesc(desc);
        expense.setTheMerchant(merchant);
        expense.setThePaymentMethod(paymentMethod);
        expense.setTheTags(tags);
        String itemList = expense.getItem();
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
