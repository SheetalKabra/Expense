package com.company.model;

import java.io.Serializable;
import java.util.Date;

public class Expense implements Serializable {
    private Date theDate;
    private String theCat;
    private double theAmount;
    private String theDesc;
    private String theMerchant;
    private String thePaymentMethod;
    private String theTags;

    public String getItem(){
        return theDate+ ", "+theCat+", "+theAmount+", "+theDesc+", "+theMerchant+", "+thePaymentMethod+", "+theTags;
    }

    public String toString(){
        return "Date: "+theDate+ "\nCategory: "+theCat+"\nAmount: "+theAmount+"\nDescription: "+theDesc+"\nMerchant: "+theMerchant+"\nPayment Method: "+thePaymentMethod+"\nTags: "+theTags;
    }

    public Date getTheDate() {
        return theDate;
    }

    public void setTheDate(Date theDate) {
        this.theDate = theDate;
    }

    public String getTheCat() {
        return theCat;
    }

    public void setTheCat(String theCat) {
        this.theCat = theCat;
    }

    public double getTheAmount() {
        return theAmount;
    }

    public void setTheAmount(double theAmount) {
        this.theAmount = theAmount;
    }

    public String getTheDesc() {
        return theDesc;
    }

    public void setTheDesc(String theDesc) {
        this.theDesc = theDesc;
    }

    public String getTheMerchant() {
        return theMerchant;
    }

    public void setTheMerchant(String theMerchant) {
        this.theMerchant = theMerchant;
    }

    public String getThePaymentMethod() {
        return thePaymentMethod;
    }

    public void setThePaymentMethod(String thePaymentMethod) {
        this.thePaymentMethod = thePaymentMethod;
    }

    public String getTheTags() {
        return theTags;
    }

    public void setTheTags(String theTags) {
        this.theTags = theTags;
    }
}
