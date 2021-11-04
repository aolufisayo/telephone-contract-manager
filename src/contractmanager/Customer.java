/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;

/**
 *
 * @author TOSHIBA
 */
public class Customer implements Observer {

    protected String referenceNumber;
    protected String customerName;
    protected char accountType;
    protected double discountedPrice;
    protected double discountInPercent;
    protected boolean internationalCallSelected;
    protected double price;
    protected String pkg;
    protected String periodInMonths;
    protected String dataBundle;
    protected String date;

    protected Subject contract;

    public Customer() {

    }

    public Customer(Subject contract) {

        this.contract = contract;
        contract.attachObserver(this);
    }

    @Override
    public void update(String customerName, char accountType, double discountedPrice, boolean internationalCallSelected,
            String referenceNumber, String pkg, String periodInMonths, String dataBundle, String date) {
        this.customerName = customerName;
        this.accountType = accountType;
        this.discountedPrice = discountedPrice;
        this.internationalCallSelected = internationalCallSelected;
        this.referenceNumber = referenceNumber;
        this.pkg = pkg;
        this.periodInMonths = periodInMonths;
        this.dataBundle = dataBundle;
        this.date = date;
        printNotification();

    }

    public void printNotification() {
        System.out.println("");
        System.out.println("The Customer and finance department have now been notified. ");
        System.out.println("");
    }

}
