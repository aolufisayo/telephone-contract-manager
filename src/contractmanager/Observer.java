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
public interface Observer {

    public void update(String customerName, char accountType, double discountedPrice, boolean internationalCallSelected,
            String referenceNumber, String pkg, String periodInMonths, String dataBundle, String date);
}
