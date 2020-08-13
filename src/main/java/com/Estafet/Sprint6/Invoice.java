package com.Estafet.Sprint6;

import com.Estafet.CustomExceptions.UnCheckedException;
import com.Estafet.Interfaces.InvoiceCalculations;

import java.io.IOException;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Invoice extends Random implements InvoiceCalculations, Serializable {
    private String articles;
    private String price;
    private static Connection con;
    private static Statement nStat;
    private static final String invoiceName = "*Shop Invoice*";// the variable is not inherited in extended classes and cannot be changed it can be only read
    private String clientDetailsInvoice;
    private String[] listWithArticlesInvoice = {"Laptop", "TV", "PC", "Monitor", "Security Cameras", "Toy Laptop", "Wall painting", "Desk", "Gaming chair", "Headset"};
    static final String[] namesUsers = {"Dkk", "Delqn Delev", "Anton Rusanov", "Georgi Vlaykov", "Dimitar Kirilov Kirov", "Alistair Park", "Paulo Goncalves", "Dimo Kamenov", "Ludmila Nenkova", "Evgeni Popov"};
    private long[] itemPriceInvoice;
    private int invoiceNumber;
    private String bankAccountIndexInvoice;
    private String dateOfReleaseInvoice;
    private long businessDiscountInvoice;
    private boolean paymentMethod;
    private long totalAmount;
    private long amountAfterDiscount;
    private long amountAfterVat;
    private long totalAmountInvoice;
    private int vaTInvoice;
    private static List<Invoice> listWhitInvoices = new ArrayList<>();
    private int zipCode;
    private String accountName;
    private String dateOfAuthorization;
    private String billingCity;
    private String invoiceVatCalculatedBy;
    private long[] itemPrice = {12, 34, 56, 7, 88, 123, 345, 809, 900, 1200};
    private long[] invoicePrice;
    private String[] items;
    private static List<String> dbList;
    private static List<Invoice> searchByID;


    public Invoice() {

    }

    public Invoice(String clientDetailsInvoice, String bankAccountIndexInvoice, String dateOfReleaseInvoice, long businessDiscountInvoice, String invoiceVatCalculatedBy) {
        this.clientDetailsInvoice = clientDetailsInvoice;
        this.bankAccountIndexInvoice = bankAccountIndexInvoice;
        this.dateOfReleaseInvoice = dateOfReleaseInvoice;
        this.businessDiscountInvoice = businessDiscountInvoice;
        this.invoiceVatCalculatedBy = invoiceVatCalculatedBy;
    }

    public Invoice(String clientDetailsInvoice, String[] listWithArticlesInvoice, long totalAmountInvoice, int invoiceNumber, String bankAccountIndexInvoice, String dateOfReleaseInvoice, long businessDiscountInvoice, int vaTInvoice) {
        this.clientDetailsInvoice = clientDetailsInvoice;
        this.listWithArticlesInvoice = listWithArticlesInvoice;
        this.totalAmountInvoice = totalAmountInvoice;
        this.invoiceNumber = invoiceNumber;
        this.bankAccountIndexInvoice = bankAccountIndexInvoice;
        this.dateOfReleaseInvoice = dateOfReleaseInvoice;
        this.businessDiscountInvoice = businessDiscountInvoice;
        this.vaTInvoice = vaTInvoice;
    }

    public Invoice(String clientDetailsInvoice, int zipCode, String accountName, String billingCity, long businessDiscountInvoice) {

        this.clientDetailsInvoice = clientDetailsInvoice;
        this.zipCode = zipCode;
        this.accountName = accountName;
        this.billingCity = billingCity;
        this.businessDiscountInvoice = businessDiscountInvoice;

    }

    private void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long[] getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(long[] invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public long getAmountAfterDiscount() {
        return amountAfterDiscount;
    }

    public void setAmountAfterDiscount(long amountAfterDiscount) {
        this.amountAfterDiscount = amountAfterDiscount;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public static String getInvoiceName() {
        return invoiceName;
    }

    public String getClientDetailsInvoice() {
        return clientDetailsInvoice;
    }

    public void setClientDetailsInvoice(String clientDetailsInvoice) {
        this.clientDetailsInvoice = clientDetailsInvoice;
    }

    public String[] getListWithArticlesInvoice() {
        return listWithArticlesInvoice;
    }

    public void setListWithArticlesInvoice(String[] listWithArticlesInvoice) {
        this.listWithArticlesInvoice = listWithArticlesInvoice;
    }

    public long[] getItemPriceInvoice() {
        return itemPriceInvoice;
    }

    public void setItemPriceInvoice(long[] itemPriceInvoice) {
        this.itemPriceInvoice = itemPriceInvoice;
    }

    public long getTotalAmountInvoice() {
        return totalAmountInvoice;
    }

    public void setTotalAmountInvoice(long totalAmountInvoice) {
        this.totalAmountInvoice = totalAmountInvoice;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getBankAccountIndexInvoice() {
        return bankAccountIndexInvoice;
    }

    public void setBankAccountIndexInvoice(String bankAccountIndexInvoice) {
        this.bankAccountIndexInvoice = bankAccountIndexInvoice;
    }

    public String getDateOfReleaseInvoice() {
        return dateOfReleaseInvoice;
    }

    public void setDateOfReleaseInvoice(String dateOfReleaseInvoice) {
        this.dateOfReleaseInvoice = dateOfReleaseInvoice;
    }

    public long getBusinessDiscountInvoice() {
        return businessDiscountInvoice;
    }

    public void setBusinessDiscountInvoice(long businessDiscountInvoice) {
        this.businessDiscountInvoice = businessDiscountInvoice;
    }

    public int getVaTInvoice() {
        return vaTInvoice;
    }

    public void setVaTInvoice(int vaTInvoice) {
        this.vaTInvoice = vaTInvoice;
    }

    public long getAmountAfterVat() {
        return amountAfterVat;
    }

    public void setAmountAfterVat(long amountAfterVat) {
        this.amountAfterVat = amountAfterVat;
    }

    @Override
    public String toString() {
        StringBuffer a = new StringBuffer("\n\n" + invoiceName + " " +
                "\n Invoice Number: " + invoiceNumber + "\n Client details: " + clientDetailsInvoice + "\n City to deliver: " + billingCity +
                "\n City Zip Code: " + zipCode +
                "\n List With Articles: " + articles + "\n Date of Release: " + dateOfReleaseInvoice +
                "\n Discount:" + businessDiscountInvoice + "%" + "\n Total amount: " + totalAmount +
                "\n Amount after Discount and VAT: " + amountAfterVat);
        return a.toString();
    }
public static void invoiceDBAndListQuantity() throws SQLException {
    System.out.println("ArrayList contains "+listWhitInvoices.size()+" invoices");
    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
        String q = "select count(*) from invoices";
        nStat = con.createStatement();
        ResultSet list = nStat.executeQuery(q);
        while(list.next()) {
            System.out.println("Table invoices contains " + list.getInt(1) + " invoices");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        nStat.close();
        con.close();
    }


}
public static void searchUserInvoicesQuantity(String userName) throws SQLException {
    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
        String q = "select count(*) from invoices where clientDetailsInvoice= "+"'"+userName+"'";
        nStat = con.createStatement();
        ResultSet list = nStat.executeQuery(q);
        while(list.next()) {
            System.out.println(userName+" have " + list.getInt(1) + " invoices");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        nStat.close();
        con.close();
    }
    }
    public String printInvoice() {
        String a = String.format("\n%s", invoiceName);
        String b = String.format("\n Order Number: %d", invoiceNumber);
        String c = String.format("\n Client details: %s", clientDetailsInvoice);
        String e = String.format("\n City to deliver: %s", billingCity);
        String f = String.format("\n City Zip Code: %d", zipCode);
        String g = String.format("\n Ordered item: %s", Arrays.toString(listWithArticlesInvoice));
        String n = String.format("\n Date of order: %s", dateOfReleaseInvoice);
        String t = String.format("\n Account discount: %d", businessDiscountInvoice).concat("%");
        String y = String.format("\n Price: %d", totalAmount);
        String h = String.format("\n Price after discount: %d", amountAfterDiscount);
        String u = String.format("\n Price after VAT: %d", amountAfterVat);
        System.out.println(a.concat(b + c + e + f + g + n + t + y + h + u));
        return a;

    }

    public static void invoiceList() throws IOException {
        String dateOA = "Current Date";
        String dataOAUT = "Next Day";
        for (int i = 0; i < namesUsers.length; i++) {
            Invoice invoice = new Invoice();
            invoice.clientDetailsInvoice = namesUsers[i];
            invoice.zipCode = generateZip();
            invoice.accountName = accountName();
            invoice.dateOfReleaseInvoice = dateOA;
            invoice.dateOfAuthorization = dataOAUT;
            invoice.billingCity = randomCity();
            invoice.invoiceVatCalculatedBy = namesUsers[i];
            invoice.businessDiscountInvoice = bisDis();
            invoice.articlesList();
            invoice.priceList();
            invoice.priceCalc();
            invoice.discountCalc();
            invoice.vatArticles();
            invoice.connector();
        }
    }

    public static void addInvoiceToList(Invoice a) throws SQLException {
        //adding Invoice object to the list and database in the same time
        listWhitInvoices.add(a);
        String prep = "INSERT INTO invoices (accountName, clientDetailsInvoice, billingCity, zipCode, listWithArticlesInvoice, priceOfItem, businessDiscountInvoice,priceAfterDiscount," +
                "priceAfterVat,totalPrice ) values (?, ?, ?, ?, ?, ?, ?,?,?,?)";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
        PreparedStatement state = con.prepareStatement(prep);
        state.setString(1, a.accountName);
        state.setString(2, a.clientDetailsInvoice);
        state.setString(3, a.billingCity);
        state.setInt(4, a.zipCode);
        state.setString(5, Arrays.toString(a.getItems()));
        state.setString(6, Arrays.toString(a.getInvoicePrice()));
        state.setInt(7, (int) a.getBusinessDiscountInvoice());
        state.setInt(8, (int) a.amountAfterDiscount);
        state.setInt(9, (int) a.amountAfterVat);
        state.setInt(10, (int) a.totalAmount);
        state.execute();
        con.close();
    }

    public static void readDBList() {
        //Printing the list and list size that is created from database rows
        System.out.println(listWhitInvoices.toString());
        System.out.println("\n Invoice list size: " + listWhitInvoices.size());

    }

    public static void invoiceDbToList() throws SQLException {
        //converting database rows to Invoice objects and adding them to a list
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");

            String finalTime = " ";
            String q = "select * from invoices ";
            nStat = con.createStatement();
            ResultSet list = nStat.executeQuery(q);
            while (list.next()) {
                Date dateAuthorization = list.getDate("dateOfAuthorization");
                Time timeAuthorization = list.getTime("dateOfAuthorization");
                String time2 = timeAuthorization.toString();
                String time = dateAuthorization.toString();
                finalTime = time.concat(time2);

                for (int i = 0; i < 1; i++) {
                    Invoice invoice = new Invoice();
                    invoice.invoiceNumber = list.getInt("invoiceNumber");
                    invoice.clientDetailsInvoice = list.getString("clientDetailsInvoice");
                    invoice.zipCode = list.getInt("zipCode");
                    invoice.accountName = list.getString("accountName");
                    invoice.dateOfReleaseInvoice = finalTime;
                    invoice.dateOfAuthorization = finalTime;
                    invoice.billingCity = list.getString("billingCity");
                    invoice.articles = list.getString("listWithArticlesInvoice");
                    invoice.price = list.getString("priceOfItem");///Exception in thread "main" java.sql.SQLFeatureNotSupportedException
                    invoice.businessDiscountInvoice = list.getInt("businessDiscountInvoice");
                    invoice.totalAmount = list.getInt("totalPrice");
                    invoice.amountAfterDiscount = list.getInt("priceAfterDiscount");
                    invoice.amountAfterVat = list.getInt("priceAfterVat");
                    listWhitInvoices.add(invoice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }

    }

    public static String printAllInvoices() throws UnCheckedException {
        StringBuilder print = new StringBuilder();
        int a = 0;
        if (listWhitInvoices == null) {
            throw new UnCheckedException("*The list is empty*");
        } else {

            for (int i = 0; i < listWhitInvoices.size(); i++) {
                print.insert(a, listWhitInvoices.get(i));
                a++;

            }
            System.out.println(print);
            return print.toString();

        }

    }

    @Override
    public void methodOfPayment() {
        if (paymentMethod) {
            System.out.println("Chosen payment method is: Online Payment");
        } else {
            System.out.println("Payment method is Cash on delivery receive");
        }
    }

    @Override
    public void priceCalc() {
        long a = 0;
        for (int l = 0; l < invoicePrice.length; l++) {
            a += invoicePrice[l];
        }
        setTotalAmount(a);
    }

    @Override
    public void discountCalc() {
        double c;
        long a = getTotalAmount();
        double b = getBusinessDiscountInvoice();
        c = a * (b / 100);
        setAmountAfterDiscount((long) (a - c));
    }

    @Override
    public void vatArticles() {
        double c;
        long d;
        long a = getTotalAmount();
        double b = getBusinessDiscountInvoice();
        c = a * (b / 100);
        d = (long) (a - c);
        long e;
        e = (long) (d - (d * 0.2));
        setAmountAfterVat(e);
    }

    @Override
    public void articlesList() {
        String[] itemsP = new String[5];
        for (int i = 0; i <= listWithArticlesInvoice.length - 6; i++) {
            itemsP[i] = listWithArticlesInvoice[i];
            setItems(itemsP);
        }

    }

    @Override
    public void priceList() throws IOException {
        long[] price = new long[5];
        for (int i = 0; i <= itemPrice.length - 6; i++) {
            price[i] = itemPrice[i];
            setInvoicePrice(price);
        }
    }

    static String accountName() {
        Random acc = new Random();
        String a;
        String[] accounts = {"Account 1", "Account 2", "Account 3", "Account 4", "Account 5", "Account 6", "Account 7", "Account 8", "Account 9", "Account 4A"};
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "11", "12", "13", "14", "15"};
        String b = numbers[acc.nextInt(15)];
        a = accounts[acc.nextInt(10)];
        return a.concat(b);
    }

    static String randomCity() {
        String a;
        Random city = new Random();
        String[] cityWorld = {"Tokyo", "Delhi", "Beijing", "Osaka", "Moscow", "Seoul", "London", "Xi'an", "Hong Kong", "Suzhou", "Sofia", "Yambol", "Oslo", "Trondheim"};
        a = cityWorld[city.nextInt(14)];
        return a;
    }

    static int bisDis() {
        int a;
        Random dis = new Random();
        a = 1 + dis.nextInt(20);
        return a;
    }

    public static void listChecker(int invoiceN) throws UnCheckedException {
        invoiceNCheck(invoiceN);
        for (Invoice i : listWhitInvoices) {
            if (i.invoiceNumber == invoiceN) {
                System.out.println("*Order is found*" + "\n" + i);
            }
        }

    }

    static int generateZip() {
        Random random = new Random();
        int a = 0;
        for (int i = 1; i <= 1; i++) {
            a = i + random.nextInt(2000);
        }
        return a;
    }

    public static void searchInvoicesTableByID(int id) throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            searchByID = new ArrayList<>();
            String finalTime = " ";
            String q = "select * from invoices where invoiceNumber=" + id;
            nStat = con.createStatement();
            ResultSet list = nStat.executeQuery(q);
            while (list.next()) {
                Date dateAuthorization = list.getDate("dateOfAuthorization");
                Time timeAuthorization = list.getTime("dateOfAuthorization");
                String time2 = timeAuthorization.toString();
                String time = dateAuthorization.toString();
                finalTime = time.concat(time2);

                for (int i = 0; i < 1; i++) {
                    Invoice invoice = new Invoice();
                    invoice.invoiceNumber = list.getInt("invoiceNumber");
                    invoice.clientDetailsInvoice = list.getString("clientDetailsInvoice");
                    invoice.zipCode = list.getInt("zipCode");
                    invoice.accountName = list.getString("accountName");
                    invoice.dateOfReleaseInvoice = finalTime;
                    invoice.dateOfAuthorization = finalTime;
                    invoice.billingCity = list.getString("billingCity");
                    invoice.articles = list.getString("listWithArticlesInvoice");
                    invoice.price = list.getString("priceOfItem");///Exception in thread "main" java.sql.SQLFeatureNotSupportedException
                    invoice.businessDiscountInvoice = list.getInt("businessDiscountInvoice");
                    invoice.totalAmount = list.getInt("totalPrice");
                    invoice.amountAfterDiscount = list.getInt("priceAfterDiscount");
                    invoice.amountAfterVat = list.getInt("priceAfterVat");
                    searchByID.add(invoice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }
        System.out.println(searchByID.toString());
        searchByID.clear();
    }

    public static void searchInvoiceTableByName(String name) throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            searchByID = new ArrayList<>();
            String finalTime;
            String q = "select * from invoices where clientDetailsInvoice=" +"'"+ name +"'";
            nStat = con.createStatement();
            ResultSet list = nStat.executeQuery(q);
            while (list.next()) {
                Date dateAuthorization = list.getDate("dateOfAuthorization");
                Time timeAuthorization = list.getTime("dateOfAuthorization");
                String time2 = timeAuthorization.toString();
                String time = dateAuthorization.toString();
                finalTime = time.concat(time2);

                for (int i = 0; i < 1; i++) {
                    Invoice invoice = new Invoice();
                    invoice.invoiceNumber = list.getInt("invoiceNumber");
                    invoice.clientDetailsInvoice = list.getString("clientDetailsInvoice");
                    invoice.zipCode = list.getInt("zipCode");
                    invoice.accountName = list.getString("accountName");
                    invoice.dateOfReleaseInvoice = finalTime;
                    invoice.dateOfAuthorization = finalTime;
                    invoice.billingCity = list.getString("billingCity");
                    invoice.articles = list.getString("listWithArticlesInvoice");
                    invoice.price = list.getString("priceOfItem");///Exception in thread "main" java.sql.SQLFeatureNotSupportedException
                    invoice.businessDiscountInvoice = list.getInt("businessDiscountInvoice");
                    invoice.totalAmount = list.getInt("totalPrice");
                    invoice.amountAfterDiscount = list.getInt("priceAfterDiscount");
                    invoice.amountAfterVat = list.getInt("priceAfterVat");
                    searchByID.add(invoice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }
        System.out.println(searchByID.toString());
        searchByID.clear();
    }

    public static void searchInvoicesTableByIdRange(int a, int b) throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            searchByID = new ArrayList<>();
            String finalTime;
            String q = "select * from invoices where invoiceNumber between " + a + " and " + b;
            nStat = con.createStatement();
            ResultSet list = nStat.executeQuery(q);
            while (list.next()) {
                Date dateAuthorization = list.getDate("dateOfAuthorization");
                Time timeAuthorization = list.getTime("dateOfAuthorization");
                String time2 = timeAuthorization.toString();
                String time = dateAuthorization.toString();
                finalTime = time.concat(time2);

                for (int i = 0; i < 1; i++) {
                    Invoice invoice = new Invoice();
                    invoice.invoiceNumber = list.getInt("invoiceNumber");
                    invoice.clientDetailsInvoice = list.getString("clientDetailsInvoice");
                    invoice.zipCode = list.getInt("zipCode");
                    invoice.accountName = list.getString("accountName");
                    invoice.dateOfReleaseInvoice = finalTime;
                    invoice.dateOfAuthorization = finalTime;
                    invoice.billingCity = list.getString("billingCity");
                    invoice.articles = list.getString("listWithArticlesInvoice");
                    invoice.price = list.getString("priceOfItem");///Exception in thread "main" java.sql.SQLFeatureNotSupportedException
                    invoice.businessDiscountInvoice = list.getInt("businessDiscountInvoice");
                    invoice.totalAmount = list.getInt("totalPrice");
                    invoice.amountAfterDiscount = list.getInt("priceAfterDiscount");
                    invoice.amountAfterVat = list.getInt("priceAfterVat");
                    searchByID.add(invoice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }
        System.out.println(searchByID.toString());
        searchByID.clear();
    }
    public static void searchInvoicesTableByTimeRange(String a,String b) throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            searchByID = new ArrayList<>();
            String finalTime;
            String q = "select * from invoices where dateOfAuthorization between "+"'"+  a +"'"+ " and " +"'"+ b+"'";
            nStat = con.createStatement();
            ResultSet list = nStat.executeQuery(q);
            while (list.next()) {
                Date dateAuthorization = list.getDate("dateOfAuthorization");
                Time timeAuthorization = list.getTime("dateOfAuthorization");
                String time2 = timeAuthorization.toString();
                String time = dateAuthorization.toString();
                finalTime = time.concat(time2);

                for (int i = 0; i < 1; i++) {
                    Invoice invoice = new Invoice();
                    invoice.invoiceNumber = list.getInt("invoiceNumber");
                    invoice.clientDetailsInvoice = list.getString("clientDetailsInvoice");
                    invoice.zipCode = list.getInt("zipCode");
                    invoice.accountName = list.getString("accountName");
                    invoice.dateOfReleaseInvoice = finalTime;
                    invoice.dateOfAuthorization = finalTime;
                    invoice.billingCity = list.getString("billingCity");
                    invoice.articles = list.getString("listWithArticlesInvoice");
                    invoice.price = list.getString("priceOfItem");///Exception in thread "main" java.sql.SQLFeatureNotSupportedException
                    invoice.businessDiscountInvoice = list.getInt("businessDiscountInvoice");
                    invoice.totalAmount = list.getInt("totalPrice");
                    invoice.amountAfterDiscount = list.getInt("priceAfterDiscount");
                    invoice.amountAfterVat = list.getInt("priceAfterVat");
                    searchByID.add(invoice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }
        System.out.println(searchByID.toString());
        searchByID.clear();

    }
    public static void updateAccountName(String current,String update) throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            for (Invoice i:listWhitInvoices  ) {
                if (i.accountName.equals(current)){
                    i.setAccountName(update);
                }
            }
            String q = "update invoices set accountName= "+"'"+update+"'"+" where accountName= "+"'"+current+"'";
            nStat = con.createStatement();
            nStat.execute(q);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }

    }

    public static void invoiceListContainOrderNumber(int invoiceNum) throws UnCheckedException {
        invoiceNumCheck(invoiceNum);
        boolean a = false;
        for (Invoice i : listWhitInvoices) {
            if (i.invoiceNumber == invoiceNum) {
                a = true;
                break;
            }
        }
        System.out.println("\n" + a);
    }

    private static void invoiceNCheck(int invoiceN) throws UnCheckedException {
        if (listWhitInvoices == null) {
            throw new UnCheckedException("*The list is empty*");
        }
        if (invoiceN <= 0) {
            throw new UnCheckedException("The list contains Invoices with positive numbers. Input " + invoiceN);
        }
        if (invoiceN > listWhitInvoices.size()) {
            long b = listWhitInvoices.size();
            throw new UnCheckedException("The input is grater than List size." +
                    "The list size is: " + b);
        }
    }


    private static void invoiceNumCheck(int invoiceNum) throws UnCheckedException {
        if (listWhitInvoices == null) {
            throw new UnCheckedException("*The list is empty*");
        }
        if (invoiceNum <= 0) {
            throw new UnCheckedException("The list contains Invoices with positive numbers. Input: " + invoiceNum);
        }
        if (invoiceNum > listWhitInvoices.size()) {
            long b = listWhitInvoices.size();
            throw new UnCheckedException("The input is grater than List size," +
                    "the list size is: " + b);
        }
    }

    void connector() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            System.out.println("Connection successful");
            String prep = "INSERT INTO invoices (accountName, clientDetailsInvoice, billingCity, zipCode, listWithArticlesInvoice, priceOfItem, businessDiscountInvoice,priceAfterDiscount," +
                    "priceAfterVat,totalPrice ) values (?, ?, ?, ?, ?, ?, ?,?,?,?)";
            String creat = "create table if not exists Invoices\n" +
                    "(\n" +
                    "\tinvoiceNumber INT unsigned not null auto_increment,\n" +
                    "\taccountName varchar(50) not null default '',\n" +
                    "\tclientDetailsInvoice varchar(100) not null default '',\n" +
                    "\tbillingCity varchar(50) not null default '',\n" +
                    "\tzipCode int unsigned not null default 0,\n" +
                    "\tlistWithArticlesInvoice varchar(500) not null default '',\n" +
                    "\tpriceOfItem varchar(50)  not null default '',\n" +
                    "\tbusinessDiscountInvoice int unsigned not null default 0,\n" +
                    "\tdateOfAuthorization datetime not null default (now() + interval 1 day),\n" +
                    "\ttotalPrice int not null default 0,\n" +
                    "\tpriceAfterDiscount int not null default 0,\n" +
                    "\tpriceAfterVat int not null default 0,\n" +
                    "\tprimary key (invoiceNumber)\n" +
                    ");";
            Statement createDB = con.createStatement();
            createDB.execute(creat);
            PreparedStatement one = con.prepareStatement(prep);
            one.setString(1, accountName);
            one.setString(2, clientDetailsInvoice);
            one.setString(3, billingCity);
            one.setInt(4, zipCode);
            one.setString(5, Arrays.toString(getItems()));
            one.setString(6, Arrays.toString(getInvoicePrice()));
            one.setInt(7, (int) getBusinessDiscountInvoice());//change to decimal
            one.setInt(8, (int) amountAfterDiscount);
            one.setInt(9, (int) amountAfterVat);
            one.setInt(10, (int) totalAmount);
            one.execute();
            con.close();
            System.out.println("database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteInvoiceByNumber(int a) throws SQLException {
        int b = 0;
        for (Invoice j : listWhitInvoices) {
            if (j.invoiceNumber == a) {
                b = listWhitInvoices.indexOf(j);
            }
        }
        listWhitInvoices.remove(b);
        System.out.println(" *Invoice number " + a + " is deleted*");
        try {
            String del = "delete from invoices where invoiceNumber =" + a;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            nStat = con.createStatement();
            nStat.execute(del);
            System.out.println(" *Database Invoice number "+a+"is deleted*");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }

    }

    public static void clearDatabaseTableInvoices() throws SQLException {
        try {
            String del = "delete from invoices ";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            nStat = con.createStatement();
            nStat.execute(del);
            System.out.println(" *Table Invoices is cleared*");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }
    }
    public static void deleteList(){
        listWhitInvoices=null;
    }
    public static void deleteTableInvoices() throws SQLException {
        try {
            String del = "drop table invoices ";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            nStat = con.createStatement();
            nStat.execute(del);
            System.out.println(" *Table Invoices is deleted*");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }
    }

}


