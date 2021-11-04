/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author TOSHIBA
 */
public class ContractManager {

    private static final Scanner sc = new Scanner(System.in);
    private  static List<Contract> archives = new ArrayList<>();
    private  static List<Contract> contracts = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         System.out.println("| CONTRACT MANAGER APPLICATION |");

        String option = "";

        while(!option.equals("0")) {

           option = mainMenu();

           switch(option) {

            case "1": 
                enterNewContract(false);
                break;
            case "2":
                displaySummaryOfContracts();
                break;
            case "3":
                displaySummaryOfContractsForSelectedMonth();
                break;
            case "4":
                findAndDisplayContract();
                break;
            case "5":
                modifyExistingContract();
                break;
            case "0":
                break;
            default:
                break;
           }
            
        }

        sc.close();

    }

    private static String mainMenu() {

        String option = "";

            System.out.println("\n1. Enter new Contract");
            System.out.println("2. Display Summary of Contracts");
            System.out.println("3. Display Summary of Contracts for Selected Month");
            System.out.println("4. Find and display Contract");
            System.out.println("5. Modify existing Contract");
            System.out.println("0. Exit\n");

            
            while (!option.matches("[0-5]")) {
                
                System.out.println("Enter option: ");
                option = sc.next();
    
                if (!option.matches("[0-5]")) {
                    System.out.println("Enter correct option!");
                } else break;

            }


        return option;
    }

    private static Contract enterNewContract(boolean save) {
 
        System.out.println();

        if (!save)
        sc.nextLine();

        String customerName = "";

        while(true) {

            System.out.println("Enter Name: ");

            customerName = sc.nextLine().trim();

            if (customerName.length() > 25) {
                System.out.println("Name must be <= 25 character");
                continue;
            } else break;
        }

        System.out.println();


        String pkg = "";

        while(true) {

            System.out.println("1. Small 300 Mins ");
            System.out.println("2. Medium 600 Mins ");
            System.out.println("3. Large 850 Mins ");
            System.out.println("Enter Package To Select: ");

            pkg = sc.nextLine().trim();

            if (!pkg.matches("[1-3]")) {
                System.out.println("Enter correct Package Number!");
                continue;
            } else break;

        }

        System.out.println();

        String reference = "";


        while(true) {

            System.out.println("Enter Reference: ");

            reference = sc.nextLine().trim();

            if (!reference.matches("[A-Z]{2}[0-9]{3}[BCN]{1}")) {
                System.out.println("Format Should be Like!");
                System.out.println("(Two Letter followed by three positive int number followed by account type which is B,C or N)\n" +
                "E.g AA555B");
                continue;
            } else break;
            
        }


        char accountType = reference.charAt(5);

        reference = reference.substring(0,2) + reference.substring(2);
        System.out.println();

        String dataBundle = "";

        if (accountType == 'B') {
            while(true) {

                System.out.println("1. Low 1GB");
                System.out.println("2. Medium 4GB  ");
                System.out.println("3. High 8GB ");
                System.out.println("4. Unlimited ");
                System.out.println("Enter Data Bundle To Select: ");
    
                dataBundle = sc.nextLine().trim();
    
                if (!dataBundle.matches("[1-4]")) {
                    System.out.println("Enter Data Bundle Number!");
                    continue;
                } else break;
    
            }
        } else {
            while(true) {

                System.out.println("1. Low 1GB");
                System.out.println("2. Medium 4GB  ");
                System.out.println("3. High 8GB ");
                System.out.println("Enter Data Bundle To Select: ");
    
                dataBundle = sc.nextLine().trim();
    
                if (!dataBundle.matches("[1-3]")) {
                    System.out.println("Enter Data Bundle Number!");
                    continue;
                } else break;
    
            }
        }


        System.out.println();


        String period = "";

            if (accountType == 'B') {
                while(true) {  
                    System.out.println("1. 12 month");
                    System.out.println("2. 18 month");
                    System.out.println("3. 24 month");
                    System.out.println("Enter Peroid: ");
        
                    period = sc.nextLine().trim();

                    if (!period.matches("[1-3]")) {
                        System.out.println("Enter correct option!");
                        continue;
                    } else {
                            if (period.equals("1")) period = "2";
                            else if (period.equals("2")) period = "3";
                            else period = "4";
                        break;
                    }
                }
            } 
            else {

                while(true) {  
                System.out.println("1. 1 month");
                System.out.println("2. 12 month");
                System.out.println("3. 18 month");
                System.out.println("4. 24 month");
                System.out.println("Enter Peroid: ");
    
                period = sc.nextLine().trim();
    
                if (!period.matches("[1-4]")) {
                    System.out.println("Enter correct option!");
                    continue;
                } else break;
            }
        }

        System.out.println();


        boolean internationalCall = false;


        while(true) {

            System.err.println("Do you want option of Internation Call? (Y/N): ");
            System.out.println("Enter option: ");

            String option = sc.nextLine().trim();

            if (!(option.equalsIgnoreCase("n") || option.equalsIgnoreCase("y")))  {
                System.out.println("Enter Y or N only!");
                continue;
                
            } else {

                if (option.equalsIgnoreCase("y")) internationalCall = true;
                break;
            }
            
        }

        System.out.println();

        double price = 0;

        if (pkg.equals("1")) {
    
            if (dataBundle.equals("1")) price += 500; 
            else if (dataBundle.equals("2")) price += 700; 
            else if (dataBundle.equals("3")) price += 900; 

        } else if (pkg.equals("2")) {

            if (dataBundle.equals("1")) price += 650; 
            else if (dataBundle.equals("2")) price += 850; 
            else if (dataBundle.equals("3")) price += 1050; 

        } else {

            if (dataBundle.equals("1")) price += 850; 
            else if (dataBundle.equals("2")) price += 1050; 
            else if (dataBundle.equals("3")) price += 1250; 
            else if (dataBundle.equals("4")) price += 2000; 

        } 

        if (internationalCall) price += (price/100) * 15;

        double discountedPrice = price;
        double discount = 0;

        if (accountType == 'B') {
    
            discount = 10;
           discountedPrice -= (price/100) * 10;

        } else if (accountType == 'C') {
            discount = 30;
            discountedPrice -= (price/100) * 30;

        } else {

            if (pkg.equals("2") || pkg.equals("3")) {
                discount = 5;
                discountedPrice -= (price/100) * 5; 
            }
                else if (pkg.equals("4")) {
                    discount = 10;
                    discountedPrice -= (price/100) * 10; 
                } 
            else discountedPrice = 0;

        } 

        if (period.equals("1")) period = "1";
        else if (period.equals("2")) period = "12";
        else if (period.equals("3")) period = "18";
        else period = "24";

        discountedPrice /= Integer.parseInt(period);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        String date = sdf.format(cal.getTime());   

        //Subject subContract = null;
        Contract contract = null;
        Customer customer = null;

        if(accountType == 'B'){

            if (save) {
                contract = new BusinessContract();
                customer = new Customer((Subject) contract);
                contract.setCustomerName(customerName);
                contract.setAccountType(accountType);
                contract.setDiscountedPrice(discountedPrice);
                contract.setInternationalCallSelected(internationalCall);
                contract.setPrice(price);
                contract.setReferenceNumber(reference);
                contract.setPkg(pkg);
                contract.setPeriodInMonths(period);
                contract.setDataBundle(dataBundle);
                contract.setDate(date);
                contract.setDiscountInPercent(discount);
            }

            else {
                contract = new BusinessContract(customerName,accountType,discountedPrice,internationalCall,price,reference,pkg,period,dataBundle,date,discount);
            }

           
        }else if(accountType == 'C'){

            if (save) {
                contract = new CharityContract();
                customer = new Customer((Subject) contract);
                contract.setCustomerName(customerName);
                contract.setAccountType(accountType);
                contract.setDiscountedPrice(discountedPrice);
                contract.setInternationalCallSelected(internationalCall);
                contract.setPrice(price);
                contract.setReferenceNumber(reference);
                contract.setPkg(pkg);
                contract.setPeriodInMonths(period);
                contract.setDataBundle(dataBundle);
                contract.setDate(date);
                contract.setDiscountInPercent(discount);
            }else {
                contract = new CharityContract(customerName,accountType,discountedPrice,internationalCall,price,reference,pkg,period,dataBundle,date,discount);
            }

            //subContract = (Subject) contract;

            //customer = new Customer(subContract);
        }else {

            if (save) {
                contract = new NormalContract();
                customer = new Customer((Subject) contract);
                contract.setCustomerName(customerName);
                contract.setAccountType(accountType);
                contract.setDiscountedPrice(discountedPrice);
                contract.setInternationalCallSelected(internationalCall);
                contract.setPrice(price);
                contract.setReferenceNumber(reference);
                contract.setPkg(pkg);
                contract.setPeriodInMonths(period);
                contract.setDataBundle(dataBundle);
                contract.setDate(date);
                contract.setDiscountInPercent(discount);
            } else {
                contract = new NormalContract(customerName,accountType,discountedPrice,internationalCall,price,reference,pkg,period,dataBundle,date,discount);
            }

             //subContract = (Subject) contract;

            //customer = new Customer(subContract);
        }
        if (!save) {
            saveContract(contract);
            displaySummaryOfAContract(contract);
        }
        return contract;
    }

    private static void saveContract(Contract contract) {
        try {
            FileWriter myWriter = new FileWriter("contracts.txt",true);
          
            myWriter.write(contract.getCustomerName() + "," + contract.getAccountType() + "," + 
            contract.getDiscountedPrice() + "," + contract.getDiscountInPercent() + ","  + contract.getPrice() + "," +  contract.isInternationalCallSelected() + ","
             + contract.getReferenceNumber() + "," +  
            contract.getDate() + "," + contract.getPkg() + ","
             + contract.getDataBundle() + "," + contract.getPeriodInMonths() + "\n");

            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    private static void displaySummaryOfAContract(Contract contract) {

        String pkg = contract.getPkg();

        if (pkg.equals("1")) pkg = "Small (300)";
        else if (pkg.equals("2")) pkg = "Medium (600)";
        else pkg = "Large (1200)";

        String data = contract.getDataBundle();

        if (data.equals("1")) data = "Low (1GB)";
        else if (data.equals("2")) data = "Medium (4GB)";
        else if (data.equals("3")) data = "High (8GB)";
        else data = "Unlimited";

        String type = "";

        if (contract.getAccountType() == 'B') type = "Business";
        else if (contract.getAccountType() == 'C') type = "Charity";
        else if (contract.getAccountType() == 'N') type = "Normal";

        double discount = contract.getDiscountInPercent();
        String discountStr = "";
        if (discount == 0) discountStr = "none";
        else discountStr = discount + "%";

        double discountPrice = contract.getDiscountedPrice();

        if (discountPrice == 0) discountPrice = contract.getPrice()/12;

        String intCall = "No";
        if (contract.isInternationalCallSelected()) intCall = "Yes";


        System.out.println(
           "+---------------------------------------------------------------------------------------+\n"+
           "|                                                                                       |\n"+
           "| Customer: "+contract.getCustomerName()+"                                              |\n"+
           "|                                                                                       |\n"+
           "| Ref: "+ contract.getReferenceNumber()+" Date: "  + contract.getDate() + "             |\n"+
           "| Package: "+ pkg + " Data: " + data+"                                                  |\n"+
           "| Period: " + contract.getPeriodInMonths()+ " Months Type: "+ type + "                  |\n"+
           "|                                                                                       |\n"+
           "| Discount: "+ discountStr + " Intl. Calls: "+ intCall +"                               |\n"+
           "|                                                                                       |\n"+
           "| Discounted Monthly Charge: £" + discountPrice +"                                      |\n"+
           "|                                                                                       |\n"+
           "+---------------------------------------------------------------------------------------+"
            
        );
       


    }

    private static void displaySummaryOfContracts() {
    
        System.out.println();
       
        sc.nextLine();

        String chooseFile = "";

        while(true) {

            System.out.println("1. contracts.txt");
            System.out.println("2. archive.txt");
            System.out.println("Choose File: ");

            chooseFile = sc.nextLine().trim();

            if (!chooseFile.matches("[1-2]")) {
                System.out.println("Choose 1 or 2");
                continue;
            } else break;
        }

        System.out.println();
        int high = 0;
        int unlimited = 0;
        double avgLarge = 0;
        int avgCount = 0;
        int[] monthly = new int[12];
 
        if (chooseFile.equals("1")) {
            
            loadContracts();

            System.out.println("\nTotal number of contracts: " + contracts.size());


                     for (Contract contract : contracts) {
                    
                        if (contract.getDataBundle().equals("3")) {
                           
                            high++;
                        } 
                        else if (contract.getDataBundle().equals("4")) unlimited++;

                        if (contract.getPkg().equals("3"))  {
                            avgLarge += contract.getDiscountedPrice();
                            avgCount++;
                        }

                        String month = contract.getDate();
                        if (month.contains("Jan")) {
                            monthly[0] += 1;
                        } else if (month.contains("Feb")) {
                            monthly[1] += 1;
                        }else if (month.contains("Mar")) {
                            monthly[2] += 1;
                        }else if (month.contains("Apr")) {
                            monthly[3] += 1;
                        }else if (month.contains("May")) {
                            monthly[4] += 1;
                        }else if (month.contains("Jun")) {
                            monthly[5] += 1;
                        }else if (month.contains("Jul")) {
                            monthly[6] += 1;
                        }else if (month.contains("Aug")) {
                            monthly[7] += 1;
                        }else if (month.contains("Sep")) {
                            monthly[8] += 1;
                        }else if (month.contains("Oct")) {
                            monthly[9] += 1;
                        }else if (month.contains("Nov")) {
                            monthly[10] += 1;
                        }else if (month.contains("Dec")) {
                            monthly[11] += 1;
                        }
                        
                    } 
                    
        } else {
            
           loadArchiveContracts();

                    System.out.println("\nTotal number of contracts: " + archives.size());

                   

                             for (Contract contract : archives) {
                            
                                if (contract.getDataBundle().equals("3")) {
                           
                                    high++;
                                } 
                                else if (contract.getDataBundle().equals("4")) unlimited++;
        
                                if (contract.getPkg().equals("3"))  {
                                    avgLarge += contract.getDiscountedPrice();
                                    avgCount++;
                                }
        
                                String month = contract.getDate();
                                if (month.contains("Jan")) {
                                    monthly[0] += 1;
                                } else if (month.contains("Feb")) {
                                    monthly[1] += 1;
                                }else if (month.contains("Mar")) {
                                    monthly[2] += 1;
                                }else if (month.contains("Apr")) {
                                    monthly[3] += 1;
                                }else if (month.contains("May")) {
                                    monthly[4] += 1;
                                }else if (month.contains("Jun")) {
                                    monthly[5] += 1;
                                }else if (month.contains("Jul")) {
                                    monthly[6] += 1;
                                }else if (month.contains("Aug")) {
                                    monthly[7] += 1;
                                }else if (month.contains("Sep")) {
                                    monthly[8] += 1;
                                }else if (month.contains("Oct")) {
                                    monthly[9] += 1;
                                }else if (month.contains("Nov")) {
                                    monthly[10] += 1;
                                }else if (month.contains("Dec")) {
                                    monthly[11] += 1;
                                }
                                
                                
                            } 
                     
                }  

                if (avgCount>0 )
                avgLarge /= avgCount;



        System.out.println("\nNumber of contracts with High Bundle: " + high);
        System.out.println("\nNumber of contracts with Unlimited Bundle: " + unlimited);
        System.out.println("\nAverage charge of large package contracts: " + avgLarge);
        System.out.println("\nContracts in month\n");
        System.out.println("Jan: " + monthly[0]);
        System.out.println("Feb: " + monthly[1]);
        System.out.println("Mar: " + monthly[2]);
        System.out.println("Apr: " + monthly[3]);
        System.out.println("May: " + monthly[4]);
        System.out.println("June: " + monthly[5]);
        System.out.println("July: " + monthly[6]);
        System.out.println("Aug: " + monthly[7]);
        System.out.println("Sep: " + monthly[8]);
        System.out.println("Oct: " + monthly[9]);
        System.out.println("Nov: " + monthly[10]);
        System.out.println("Dec: " + monthly[11]);
             
        
    }

    private static void loadContracts() {
        contracts = new ArrayList<>();
        try {  
            File file = new File("contracts.txt");
            FileReader fr = new FileReader(file); 
            BufferedReader br = new BufferedReader(fr);
            String line;  
            while((line=br.readLine())!=null)  
            {  

            String[] content = line.split(",");

            String accountType = content[1];

            Contract contract = null;

            switch(accountType) {
                case "B":
                contract = new BusinessContract(content[0],  content[1].charAt(0), Double.parseDouble(content[2]), Boolean.parseBoolean(content[5]), 
                Double.parseDouble(content[4]), content[6], content[8], content[10]
                , content[9], content[7], Double.parseDouble(content[3]));

                break;
                case "C":

                contract = new CharityContract(content[0],  content[1].charAt(0), Double.parseDouble(content[2]), Boolean.parseBoolean(content[5]), 
                Double.parseDouble(content[4]), content[6], content[8], content[10]
                , content[9], content[7], Double.parseDouble(content[3]));

                break;
                case "N":
                contract = new NormalContract(content[0],  content[1].charAt(0), Double.parseDouble(content[2]), Boolean.parseBoolean(content[5]), 
                Double.parseDouble(content[4]), content[6], content[8], content[10]
                , content[9], content[7], Double.parseDouble(content[3]));

                break;

            }

            contracts.add(contract);
      
            }  
            fr.close();

            }  
            catch(IOException e)  
            {  
            e.printStackTrace();  
            }  

    }

    private static void loadArchiveContracts() {
        archives = new ArrayList<>();

        try {  
            File file=new File("archive.txt");
            FileReader fr=new FileReader(file); 
            BufferedReader br=new BufferedReader(fr);
            String line; 
            
            
            while((line=br.readLine())!=null)  
            {  
                
                String[] content = new String[10];
                int i = 0;

                for (;; i++) {
                    if ( line.charAt(i) == ' ' || line.charAt(i) == '\t') {
                        break;
                    }
                    if (line.charAt(i) != '\0') {
                        content[0] += line.charAt(i);
                    }
                    
                }

                content[0] = content[0].replace("null", "");

                for (; line.charAt(i) == ' ' || line.charAt(i) == '\t'; i++) {}

                for (; line.charAt(i) != ' ' || line.charAt(i) != '\t'; i++) {
                    if ( line.charAt(i) == ' ' || line.charAt(i) == '\t') {
                        break;
                    } 
                    if (line.charAt(i) == '\0') break;

                    content[1] += line.charAt(i);
                }

                content[1] = content[1].replace("null", "");

                for (; line.charAt(i) == ' ' || line.charAt(i) == '\t'; i++) {}

                for (; line.charAt(i) != ' ' || line.charAt(i) != '\t'; i++) {
                    if ( line.charAt(i) == ' ' || line.charAt(i) == '\t') {
                        break;
                    }
                    if (line.charAt(i) == '\0') break;

                    content[2] += line.charAt(i);
                }

                content[2] = content[2].replace("null", "");


                for (; line.charAt(i) == ' ' || line.charAt(i) == '\t'; i++) {}

                for (; line.charAt(i) != ' ' || line.charAt(i) != '\t'; i++) {
                    if ( line.charAt(i) == ' ' || line.charAt(i) == '\t') {
                        break;
                    }
                    if (line.charAt(i) == '\0') break;

                    content[3] += line.charAt(i);
                }

                content[3] = content[3].replace("null", "");


                for (; line.charAt(i) == ' ' || line.charAt(i) == '\t'; i++) {}

                for (; line.charAt(i) != ' ' || line.charAt(i) != '\t'; i++) {
                    if ( line.charAt(i) == ' ' || line.charAt(i) == '\t') {
                        break;
                    } 
                    if (line.charAt(i) == '\0') break;

                    content[4] += line.charAt(i);
                }

                content[4] = content[4].replace("null", "");


                for (; line.charAt(i) == ' ' || line.charAt(i) == '\t'; i++) {}

                for (; line.charAt(i) != ' ' || line.charAt(i) != '\t'; i++) {
                    if ( line.charAt(i) == ' ' || line.charAt(i) == '\t') {
                        break;
                    }
                    if (line.charAt(i) == '\0') break;

                    content[5] += line.charAt(i);
                }

                content[5] = content[5].replace("null", "");

                for (; line.charAt(i) == ' ' || line.charAt(i) == '\t'; i++) {}

                for (; line.charAt(i) != ' ' || line.charAt(i) != '\t'; i++) {
                    if ( line.charAt(i) == ' ' || line.charAt(i) == '\t') {
                        break;
                    }
                    if (line.charAt(i) == '\0') break;

                    content[6] += line.charAt(i);
                }

                content[6] = content[6].replace("null", "");


                for (; line.charAt(i) == ' ' || line.charAt(i) == '\t'; i++) {}
          
                for (; line.charAt(i) != ' ' || line.charAt(i) != '\t'; i++) {
                    if ( line.charAt(i) == ' ' || line.charAt(i) == '\t') {
                        break;
                    } 
                    if (line.charAt(i) == '\0') break;

                    content[7] += line.charAt(i);
                }

                content[7] = content[7].replace("null", "");

          
                for (; line.charAt(i) == ' ' || line.charAt(i) == '\t'; i++) {}

                for (; line.charAt(i) != ' ' || line.charAt(i) != '\t'; i++) {
                    if ( line.charAt(i) == ' ' || line.charAt(i) == '\t') {
                        break;
                    } 
                    if (line.charAt(i) == '\0') break;

                    content[8] += line.charAt(i);
                }

                content[8] = content[8].replace("null", "");

                for (; line.charAt(i) == ' ' || line.charAt(i) == '\t'; i++) {}


                for (; i < line.length(); i++) {
                    if ( line.charAt(i) == ' ' || line.charAt(i) == '\t') {
                        break;
                    } 
                    if (line.charAt(i) == '\0') break;

                    content[9] += line.charAt(i);
                }



                content[9] = content[9].replace("null", "");

                char accountType = ' ';

                if (content[8].equalsIgnoreCase("NORMAL")) accountType = 'N';
                else  if (content[8].equalsIgnoreCase("BUSINESS")) accountType = 'B';
                else accountType = 'C';

               double discountedPrice = Double.parseDouble(content[9]);

               boolean internationalCallSelected = false;

               if (content[4].equals("Y")) internationalCallSelected = true;

                String date = content[0];

                String periodInMonths = content[3];

                String pkg = content[1];

                String dataBundle = content[2];


                String reference = content[5];

                double discountInPercent = discountedPrice/100;

                Contract contract = null;

                switch(accountType) {
                    case 'B':
                    contract = new BusinessContract(
                        content[6] + " " + content[7], accountType, discountedPrice, internationalCallSelected, 
                        Double.parseDouble(content[9]), reference, pkg, periodInMonths, 
                        dataBundle, date, discountInPercent);

                    break;
                    case 'C':

                    contract = new CharityContract(
                        content[6] + " " + content[7], accountType, discountedPrice, internationalCallSelected, 
                        Double.parseDouble(content[9]), reference, pkg, periodInMonths, 
                        dataBundle, date, discountInPercent);

    
                    break;
                    case 'N':
                    contract = new NormalContract(
                        content[6] + " " + content[7], accountType, discountedPrice, internationalCallSelected, 
                        Double.parseDouble(content[9]), reference, pkg, periodInMonths, 
                        dataBundle, date, discountInPercent);

                    break;

                }

                archives.add(contract);

                }  

            fr.close();
          
            }  
            catch(IOException e)  
            {  
            e.printStackTrace();  
            }  
    }

    

    private static void displaySummaryOfContractsForSelectedMonth() {
        System.out.println();

        sc.nextLine();

        String chooseFile = "";

        while(true) {

            System.out.println("1. contracts.txt");
            System.out.println("2. archive.txt");
            System.out.println("Choose File: ");

            chooseFile = sc.nextLine().trim();

            if (!chooseFile.matches("[1-2]")) {
                System.out.println("Choose 1 or 2");
                continue;
            } else break;
        }

        System.out.println();
       

        int high = 0;
        int unlimited = 0;
        double avgLarge = 0;
        int avgCount = 0;
 
        if (chooseFile.equals("1")) {

            loadContracts();

            String months = selectedMonth();
            System.out.println(months);
            List<Contract> monthContracts = new ArrayList<>();
           
            for (Contract contract : contracts) {
               
                if (contract.getDate().contains(months)) {
                    
                    monthContracts.add(contract);
                }
            }

           

                     for (Contract contract : monthContracts) {
                    
                        if (contract.getDataBundle().equals("3")) {
                           
                            high++;
                        } 
                        else if (contract.getDataBundle().equals("4")) unlimited++;

                        if (contract.getPkg().equals("3"))  {
                            avgLarge += contract.getDiscountedPrice();
                            avgCount++;
                        }
                        
                    } 
                    
                    System.out.println("\nTotal number of contracts: " + monthContracts.size());
                   

        }
       
       
        else {

            loadArchiveContracts();

            String months = selectedMonth();
            System.out.println(months);
            List<Contract> monthContracts = new ArrayList<>();
           
            for (Contract contract : archives) {
               
                if (contract.getDate().contains(months)) {
                    
                    monthContracts.add(contract);
                }
            }

           

                     for (Contract contract : monthContracts) {
                    
                        if (contract.getDataBundle().equals("3")) {
                           
                            high++;
                        } 
                        else if (contract.getDataBundle().equals("4")) unlimited++;

                        if (contract.getPkg().equals("3"))  {
                            avgLarge += contract.getDiscountedPrice();
                            avgCount++;
                        }
                        
                    } 
                    
                    System.out.println("\nTotal number of contracts: " + monthContracts.size());


        }
                if (avgCount>0 )
                avgLarge /= avgCount;


            System.out.println("\nNumber of contracts with High Bundle: " + high);
            System.out.println("\nNumber of contracts with Unlimited Bundle: " + unlimited);
            System.out.println("\nAverage charge of large package contracts: " + avgLarge);
    }

    private static String selectedMonth() {
        String month = "";


        while(true) {

            System.out.println("1. Jan ");
            System.out.println("2. Feb ");
            System.out.println("3. Mar ");
            System.out.println("4. Apr ");
            System.out.println("5. May ");
            System.out.println("6. Jun ");
            System.out.println("7. July ");
            System.out.println("8. Aug ");
            System.out.println("9. Sep ");
            System.out.println("10. Oct ");
            System.out.println("11. Nov ");
            System.out.println("12. Dec ");

            month = sc.nextLine().trim();

            if (!month.matches("[1-9]|1[0-2]")) {
                System.out.println("Enter Number only!");
                continue;
            } else break;
            
        }

        if (month.equals("1")) month = "Jan";
        else if (month.equals("2")) month = "Feb";
        else if (month.equals("3")) month = "Mar";
        else if (month.equals("4")) month = "Apr";
        else if (month.equals("5")) month = "May";
        else if (month.equals("6")) month = "Jun";
        else if (month.equals("7")) month = "Jul";
        else if (month.equals("8")) month = "Aug";
        else if (month.equals("9")) month = "Sep";
        else if (month.equals("10")) month = "Oct";
        else if (month.equals("11")) month = "Nov";
        else if (month.equals("12")) month = "Dec";

       return month;
    }

    private static void findAndDisplayContract() {
        System.out.println();

        sc.nextLine();

        String chooseFile = "";

        while(true) {

            System.out.println("1. contracts.txt");
            System.out.println("2. archive.txt");
            System.out.println("Choose File: ");

            chooseFile = sc.nextLine().trim();

            if (!chooseFile.matches("[1-2]")) {
                System.out.println("Choose 1 or 2");
                continue;
            } else break;
        }

        System.out.println();

        System.out.println("Enter Text to search: ");
        String find = sc.nextLine();

    
 
        if (chooseFile.equals("1")) {

            loadContracts();
    
            for (Contract contract : contracts) {
                if (contract.getCustomerName().toLowerCase().contains(find.toLowerCase()) ||
                contract.getReferenceNumber().toLowerCase().contains(find.toLowerCase())) {
                    System.out.println(contract.getCustomerName().toLowerCase());
                    System.out.println(contract.getReferenceNumber().toLowerCase());
                    displaySummaryOfAContract(contract);
                }
            }

        }
       
       
        else {
            System.out.println("loaded archive contract file");
            loadArchiveContracts();

            for (Contract contract : archives) {
                if (contract.getCustomerName().toLowerCase().contains(find.toLowerCase()) ||
                contract.getReferenceNumber().toLowerCase().contains(find.toLowerCase())) {
                    displaySummaryOfAContract(contract);
                }
            }
                

                }
            }

    private static void modifyExistingContract(){
        loadContracts();
        System.out.println();
        System.out.println("Enter Text to search: ");
        sc.nextLine();
        String searchPhrase = sc.nextLine();
        


        List<Contract> foundContract = new ArrayList<>();
    int count = 1;
    System.out.println(contracts.size());
        for (Contract contract : contracts) {
            if (contract.getCustomerName().toLowerCase().contains(searchPhrase.toLowerCase()) ||
            contract.getReferenceNumber().toLowerCase().contains(searchPhrase.toLowerCase())) {
               System.out.println("|------ " + count + " -------|"); 
                displaySummaryOfAContract(contract);
                foundContract.add(contract);
                count++;
            }
        }

        if (foundContract.size() == 0) {
            System.out.println("No contract found");
            return;
        }

        Contract contract = null;

        if (foundContract.size() > 1) {
            String chooseContract = "";

            while(true) {
    
                System.out.println("Choose Contract By number: ");
    
                chooseContract = sc.nextLine().trim();
    
                if (!chooseContract.matches("[0-9]+")) {
                    System.out.println("Choose number only!");
                    continue;
                } else if (chooseContract.matches("[0-9]+") && (Integer.parseInt(chooseContract) <= 0 || 
                Integer.parseInt(chooseContract) > foundContract.size())) {
                   System.out.println(Integer.parseInt(chooseContract));
                    System.out.println("Enter correct number!");
                    continue;
                }
                break;
            }
    
            System.out.println();
    
            contract = foundContract.get(Integer.parseInt(chooseContract)-1);
        }
        else {
            contract = foundContract.get(0);
        }

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date firstDate;
        Date secondDate;
        long diff = 0;
        try {
            firstDate = (Date) sdf.parse(contract.getDate());
             secondDate = (Date) sdf.parse(sdf.format(cal.getTime()));
             long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
              diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                 diff /= 31.04;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (!(diff >= (Integer.parseInt(contract.getPeriodInMonths())/100 * 50))) {
            System.out.println("Contract period is less then 50%");
            return;
        }

        if (!(contract.getAccountType() == 'C') && diff < 6) {
            System.out.println("period is less then 6 months");
            return;
        }

        System.err.println();
        System.out.println("Enter new details");
        System.out.println();

       Contract newContract = enterNewContract(true);

        contracts.remove(contract);
        contracts.add(newContract);

        try {         
                File f= new File("contracts.txt");           

                f.delete();
                
              }    
              catch(Exception e) {  
             } 


             displaySummaryOfAContract(newContract);

            for (Contract save : contracts) {
                saveContract(save);
            }

    }

    
}
