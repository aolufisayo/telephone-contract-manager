/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author TOSHIBA
 */
public abstract class Contract {

    public String referenceNumber;
    public String customerName;
    public char accountType;
    public double discountedPrice;
    public double discountInPercent;
    public boolean internationalCallSelected;
    public double price;
    public String pkg;
    public String periodInMonths;
    public String dataBundle;
    public String date;

    public List<Observer> observers;

    public Contract() {

    }

    public Contract(String customerName, char accountType, double discountedPrice, boolean internationalCallSelected,
            double price, String reference, String pkg, String periodInMonths, String dataBundle, String date, double discountInPercent) {

        this.referenceNumber = reference;
        this.customerName = customerName;
        this.accountType = accountType;
        this.discountedPrice = discountedPrice;
        this.internationalCallSelected = internationalCallSelected;
        this.price = price;
        this.pkg = pkg;
        this.periodInMonths = periodInMonths;
        this.dataBundle = dataBundle;
        this.date = date;
        this.discountInPercent = discountInPercent;

        observers = new ArrayList<Observer>();
    }

    public Contract(String customerName, char accountType, double discountedPrice, boolean internationalCallSelected,
            String reference, String pkg, String periodInMonths, String dataBundle, String date) {

        this.referenceNumber = reference;

        this.customerName = customerName;
        this.accountType = accountType;
        this.discountedPrice = discountedPrice;
        this.internationalCallSelected = internationalCallSelected;
        this.pkg = pkg;
        this.periodInMonths = periodInMonths;
        this.dataBundle = dataBundle;
        this.date = date;
    }

    public abstract String getDataBundle();

    public abstract String getReferenceNumber();

    public abstract String getCustomerName();

    public abstract char getAccountType();

    public abstract double getDiscountedPrice();

    public abstract boolean isInternationalCallSelected();

    public abstract double getPrice();

    public abstract void setPrice(double price);

    public abstract String getPkg();

    public abstract String getPeriodInMonths();

    public abstract String getDate();

    public abstract double getDiscountInPercent();

    public abstract void setDataBundle(String dataBundle);

    public abstract void setCustomerName(String customerName);

    public abstract void setAccountType(char accountType);

    public abstract void setDiscountedPrice(double discountedPrice);

    public abstract void setDiscountInPercent(double discountInPercent);

    public abstract void setInternationalCallSelected(boolean internationalCallSelected);

    public abstract void setPkg(String pkg);

    public abstract void setPeriodInMonths(String periodInMonths);

    public abstract void setDate(String date);

    public abstract void setReferenceNumber(String referenceNumber);

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.referenceNumber);
        hash = 41 * hash + Objects.hashCode(this.customerName);
        hash = 41 * hash + this.accountType;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.discountedPrice) ^ (Double.doubleToLongBits(this.discountedPrice) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.discountInPercent) ^ (Double.doubleToLongBits(this.discountInPercent) >>> 32));
        hash = 41 * hash + (this.internationalCallSelected ? 1 : 0);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.pkg);
        hash = 41 * hash + Objects.hashCode(this.periodInMonths);
        hash = 41 * hash + Objects.hashCode(this.dataBundle);
        hash = 41 * hash + Objects.hashCode(this.date);
        hash = 41 * hash + Objects.hashCode(this.observers);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contract other = (Contract) obj;
        if (this.accountType != other.accountType) {
            return false;
        }
        if (Double.doubleToLongBits(this.discountedPrice) != Double.doubleToLongBits(other.discountedPrice)) {
            return false;
        }
        if (Double.doubleToLongBits(this.discountInPercent) != Double.doubleToLongBits(other.discountInPercent)) {
            return false;
        }
        if (this.internationalCallSelected != other.internationalCallSelected) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.referenceNumber, other.referenceNumber)) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.pkg, other.pkg)) {
            return false;
        }
        if (!Objects.equals(this.periodInMonths, other.periodInMonths)) {
            return false;
        }
        if (!Objects.equals(this.dataBundle, other.dataBundle)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.observers, other.observers)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Contract{" + "referenceNumber=" + referenceNumber + ", customerName=" + customerName + ", accountType=" + accountType + ", discountedPrice=" + discountedPrice + ", discountInPercent=" + discountInPercent + ", internationalCallSelected=" + internationalCallSelected + ", price=" + price + ", pkg=" + pkg + ", periodInMonths=" + periodInMonths + ", dataBundle=" + dataBundle + ", date=" + date + ", observers=" + observers + '}';
    }
    
    

}
