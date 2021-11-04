/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public class BusinessContract extends Contract implements Subject {

    public BusinessContract(){

    }

    public BusinessContract(String customerName, char accountType, double discountedPrice,
            boolean internationalCallSelected, double price, String reference, String pkg, String periodInMonths,
            String dataBundle, String date, double discountInPercent) {
        super(customerName, accountType, discountedPrice, internationalCallSelected, price, reference, pkg, periodInMonths,
                dataBundle, date, discountInPercent);
        
    }
    
    public String getDataBundle() {
        return dataBundle;
    }


    public String getReferenceNumber() {
        return referenceNumber;
    }


    public String getCustomerName() {
        return customerName;
    }

    public char getAccountType() {
        return accountType;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public boolean isInternationalCallSelected() {
        return internationalCallSelected;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObserver();
    }

    public String getPkg() {
        return pkg;
    }


    public String getPeriodInMonths() {
        return periodInMonths;
    }

    public String getDate() {
        return date;
    }

    public double getDiscountInPercent() {
        return discountInPercent;
    }

    public void setDataBundle(String dataBundle) {
        this.dataBundle = dataBundle;
        notifyObserver();
    }


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
        notifyObserver();
    }


    public void setAccountType(char accountType) {
        this.accountType = accountType;
        notifyObserver();
    }


    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
        notifyObserver();
    }


    public void setDiscountInPercent(double discountInPercent) {
        this.discountInPercent = discountInPercent;
        notifyObserver();
    }


    public void setInternationalCallSelected(boolean internationalCallSelected) {
        this.internationalCallSelected = internationalCallSelected;
        notifyObserver();
    }


    public void setPkg(String pkg) {
        this.pkg = pkg;
        notifyObserver();
    }


    public void setPeriodInMonths(String periodInMonths) {
        this.periodInMonths = periodInMonths;
        notifyObserver();
    }


    public void setDate(String date) {
        this.date = date;
        notifyObserver();
    }


    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
        notifyObserver();
    }


    @Override
    public void attachObserver(Observer newObserver) {
        observers.add(newObserver);
        
    }


    @Override
    public void detachObserver(Observer observer) {
        int observerIndex = observers.indexOf(observer);
        observers.remove(observerIndex);
        
    }


    @Override
    public void notifyObserver() {
        for(Observer observer : observers){
            observer.update(customerName,accountType, discountedPrice,internationalCallSelected,referenceNumber,pkg, periodInMonths,dataBundle,date);
        }
        
    }

}
