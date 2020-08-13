package com.Estafet.Sprint6;

import com.Estafet.CustomExceptions.UnCheckedException;
import com.Estafet.Interfaces.InvoiceCalculations;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Orders extends Random implements InvoiceCalculations, Serializable {
    private static final String orderName = "*Shop Order*";// the variable is not inherited in extended classes and cannot be changed it can be only read
    private int orderNumber;
    private static Connection con;
    private static Statement nStat;
    private String clientDetails;
    private String[] listWithArticles = {"Laptop", "TV", "PC", "Monitor", "Security Cameras", "Toy Laptop", "Wall painting", "Desk", "Gaming chair", "Headset"};
    private long totalAmount;
    private String accountName;
    private String dateOfActivation;
    private String billingCity;
    private int zipCode;
    private String articles;
    private String price;
    private boolean paymentMethod;
    private String orderAuthorizedBy;
    private String dateOfAuthorization;
    private long[] itemPrice = {12, 34, 56, 7, 88, 123, 345, 809, 900, 1200};
    private static List<Orders> searchByIDOrders = new ArrayList<>();
    private int vaTInvoice;
    private long amountAfterVat;
    private long amountAfterDiscount;
    private long businessDiscount;
    private long[] orderPrice;
    private String[] items;
    static final String[] namesUsers = {"Dkk", "Delqn Delev", "Anton Rusanov", "Georgi Vlaykov", "Dimitar Kirilov Kirov", "Alistair Park", "Paulo Goncalves", "Dimo Kamenov", "Ludmila Nenkova", "Evgeni Popov"};
    private static List<Orders> listWithOrders = new ArrayList<>();
    ;


    public long getBusinessDiscount() {
        return businessDiscount;
    }

    public void setBusinessDiscount(long businessDiscount) {
        this.businessDiscount = businessDiscount;
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

    public long getAmountAfterDiscount() {
        return amountAfterDiscount;
    }

    public void setAmountAfterDiscount(long amountAfterDiscount) {
        this.amountAfterDiscount = amountAfterDiscount;
    }

    public static String getOrderName() {
        return orderName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(String clientDetails) {
        this.clientDetails = clientDetails;
    }

    public String[] getListWithArticles() {
        return listWithArticles;
    }

    public void setListWithArticles(String[] listWithArticles) {
        this.listWithArticles = listWithArticles;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDateOfActivation() {
        return dateOfActivation;
    }

    public void setDateOfActivation(String dateOfActivation) {
        this.dateOfActivation = dateOfActivation;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(boolean paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getOrderAuthorizedBy() {
        return orderAuthorizedBy;
    }

    public void setOrderAuthorizedBy(String orderAuthorizedBy) {
        this.orderAuthorizedBy = orderAuthorizedBy;
    }

    public String getDateOfAuthorization() {
        return dateOfAuthorization;
    }

    public void setDateOfAuthorization(String dateOfAuthorization) {
        this.dateOfAuthorization = dateOfAuthorization;
    }

    public long[] getItemPrice() {
        return itemPrice;
    }


    public void setItemPrice(long[] itemPrice) {
        this.itemPrice = itemPrice;
    }

    long[] getOrderPrice() {
        return orderPrice;
    }

    private void setOrderPrice(long[] orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String[] getItems() {
        return items;
    }

    private void setItems(String[] items) {
        this.items = items;
    }

    public static List<Orders> getListWithOrders() {
        return listWithOrders;
    }

    public Orders() {

    }

    public Orders(int orderNumber, String clientDetails, String accountName, String dateOfActivation, String billingCity, int zipCode, boolean paymentMethod, String orderAuthorizedBy, String dateOfAuthorization) {
        this.orderNumber = orderNumber;
        this.clientDetails = clientDetails;
        this.accountName = accountName;
        this.dateOfActivation = dateOfActivation;
        this.billingCity = billingCity;
        this.zipCode = zipCode;
        this.paymentMethod = paymentMethod;
        this.orderAuthorizedBy = orderAuthorizedBy;
        this.dateOfAuthorization = dateOfAuthorization;
    }

    public Orders(int orderNumber, String clientDetails, String[] listWithArticles, long totalAmount, String accountName, String dateOfActivation, String billingCity, int zipCode, boolean paymentMethod, String orderAuthorizedBy, String dateOfAuthorization, long[] itemPrice, int vaTInvoice, long amountAfterVat, long amountAfterDiscount, long businessDiscount) {
        this.orderNumber = orderNumber;
        this.clientDetails = clientDetails;
        this.listWithArticles = listWithArticles;
        this.totalAmount = totalAmount;
        this.accountName = accountName;
        this.dateOfActivation = dateOfActivation;
        this.billingCity = billingCity;
        this.zipCode = zipCode;
        this.paymentMethod = paymentMethod;
        this.orderAuthorizedBy = orderAuthorizedBy;
        this.dateOfAuthorization = dateOfAuthorization;
        this.itemPrice = itemPrice;
        this.vaTInvoice = vaTInvoice;
        this.amountAfterVat = amountAfterVat;
        this.amountAfterDiscount = amountAfterDiscount;
        this.businessDiscount = businessDiscount;
    }

    public Orders(int orderNumber, int zipCode, String clientDetails, String accountName, String dateOfActivation, String billingCity, String orderAuthorizedBy, String dateOfAuthorization, long businessDiscount) {
        this.orderNumber = orderNumber;
        this.zipCode = zipCode;
        this.clientDetails = clientDetails;
        this.accountName = accountName;
        this.dateOfActivation = dateOfActivation;
        this.billingCity = billingCity;
        this.orderAuthorizedBy = orderAuthorizedBy;
        this.dateOfAuthorization = dateOfAuthorization;
        this.businessDiscount = businessDiscount;

    }

    @Override
    public void priceCalc() {
        long a = 0;
        for (int l = 0; l < orderPrice.length; l++) {
            a += orderPrice[l];
        }
        setTotalAmount(a);
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
    public void discountCalc() {
        double c;
        long a = getTotalAmount();
        double b = getBusinessDiscount();
        c = a * (b / 100);
        setAmountAfterDiscount((long) (a - c));
    }

    @Override
    public void vatArticles() {
        double c;
        long d;
        long a = getTotalAmount();
        double b = getBusinessDiscount();
        c = a * (b / 100);
        d = (long) (a - c);
        long e;
        e = (long) (d - (d * 0.2));
        setAmountAfterVat(e);
    }


    @Override
    public void priceList() throws IOException {
        long[] price = new long[5];
        for (int i = 0; i <= itemPrice.length - 6; i++) {
            price[i] = itemPrice[i];
            setOrderPrice(price);
        }
    }

    @Override
    public void articlesList() {
        String[] itemsP = new String[5];
        for (int i = 0; i <= listWithArticles.length - 6; i++) {
            itemsP[i] = listWithArticles[i];
            setItems(itemsP);
        }

    }

    @Override
    public String toString() {
        StringBuffer a = new StringBuffer("\n\n " + orderName + "\n Order Number: " + orderNumber + "\n Client details: " + clientDetails
                + "\n Client account: " + accountName + "\n City to deliver: " + billingCity + "\n City Zip Code: " + zipCode +
                "\n Ordered item: " + articles + "\n Date of order: " + dateOfAuthorization + "\n Account discount: "
                + businessDiscount + "%" + "\n Price: " + totalAmount + "\n Price after discount: " + amountAfterDiscount);

        return a.toString();
    }

    public String printOrder() {
        String a = String.format("\n%s", orderName);
        String b = String.format("\n Order Number: %d", orderNumber);
        String c = String.format("\n Client details: %s", clientDetails);
        String d = String.format("\n Client account: %s", accountName);
        String e = String.format("\n City to deliver: %s", billingCity);
        String f = String.format("\n City Zip Code: %d", zipCode);
        String g = String.format("\n Ordered item: %s", Arrays.toString(items));
        String n = String.format("\n Date of order: %s", dateOfActivation);
        String t = String.format("\n Account discount: %d", businessDiscount).concat("%");
        String y = String.format("\n Price: %d", totalAmount);
        String h = String.format("\n Price after discount: %d", amountAfterDiscount);
        String u = String.format("\n Price after VAT: %d", amountAfterVat);
        System.out.println(a.concat(b + c + d + e + f + g + n + t + y + h + u));
        return a;

    }
public Orders(String accountName,String clientDetails,String billingCity,int zipCode,long businessDiscount){
        this.accountName=accountName;
        this.clientDetails=clientDetails;
        this.billingCity=billingCity;
        this.zipCode=zipCode;
        this.businessDiscount=businessDiscount;
}
    public static void addOrderToList(Orders a) throws SQLException {
        listWithOrders.add(a);
        //adding Invoice object to the list and database in the same time
        String prep = "INSERT INTO orders (accountName, clientDetails, billingCity, zipCode, listWithArticles, priceOfItem, businessDiscount,priceAfterDiscount," +
                "totalPrice ) values (?, ?, ?, ?, ?, ?, ?,?,?)";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
        PreparedStatement state = con.prepareStatement(prep);
        state.setString(1, a.accountName);
        state.setString(2, a.clientDetails);
        state.setString(3, a.billingCity);
        state.setInt(4, a.zipCode);
        state.setString(5, Arrays.toString(a.getItems()));
        state.setString(6, Arrays.toString(a.getOrderPrice()));
        state.setInt(7, (int) a.getBusinessDiscount());
        state.setInt(8, (int) a.amountAfterDiscount);
        state.setInt(9, (int) a.totalAmount);
        state.execute();
        con.close();
    }

    public static void orderList() throws IOException {

        for (int i = 0; i < namesUsers.length; i++) {
            Orders order = new Orders();
            order.accountName = accountName();
            order.clientDetails = namesUsers[i];
            order.billingCity = randomCity();
            order.zipCode = generateZip();
            order.orderAuthorizedBy = namesUsers[i];
            order.businessDiscount = bisDis();
            order.articlesList();
            order.priceList();
            order.priceCalc();
            order.discountCalc();
            order.connector();

        }
    }

    public static void printAllOrders() throws UnCheckedException {
        //Printing the list and list size that is created from database rows
        System.out.println(listWithOrders.toString());
        System.out.println("\n Invoice list size: " + listWithOrders.size());

    }

    public static void orderDbToList() throws SQLException {
        //converting database rows to Orders objects and adding them to a list
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");

            String finalTime = " ";
            String q = "select * from orders ";
            nStat = con.createStatement();
            ResultSet list = nStat.executeQuery(q);
            while (list.next()) {
                Date dateAuthorization = list.getDate("dateOfAuthorization");
                Time timeAuthorization = list.getTime("dateOfAuthorization");
                String time2 = timeAuthorization.toString();
                String time = dateAuthorization.toString();
                finalTime = time.concat(time2);

                for (int i = 0; i < 1; i++) {
                    Orders orders = new Orders();
                    orders.orderNumber = list.getInt("orderNumber");
                    orders.clientDetails = list.getString("clientDetails");
                    orders.zipCode = list.getInt("zipCode");
                    orders.accountName = list.getString("accountName");
                    orders.dateOfAuthorization = finalTime;
                    orders.billingCity = list.getString("billingCity");
                    orders.articles = list.getString("listWithArticles");
                    orders.price = list.getString("priceOfItem");
                    orders.businessDiscount = list.getInt("businessDiscount");
                    orders.totalAmount = list.getInt("totalPrice");
                    orders.amountAfterDiscount = list.getInt("priceAfterDiscount");
                    listWithOrders.add(orders);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }

    }

    public static void orderDBAndListQuantity() throws SQLException {
        System.out.println("ArrayList contains " + listWithOrders.size() + " invoices");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            String q = "select count(*) from orders";
            nStat = con.createStatement();
            ResultSet list = nStat.executeQuery(q);
            while (list.next()) {
                System.out.println("Table orders contains " + list.getInt(1) + " orders");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }
    }

    public static void searchUserOrdersQuantity(String userName) throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            String q = "select count(*) from orders where clientDetails= " + "'" + userName + "'";
            nStat = con.createStatement();
            ResultSet list = nStat.executeQuery(q);
            while (list.next()) {
                System.out.println(userName + " have " + list.getInt(1) + " orders");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }
    }

    public static void searchOrdersTableByID(int id) throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            String finalTime = " ";
            String q = "select * from orders where orderNumber=" + id;
            nStat = con.createStatement();
            ResultSet list = nStat.executeQuery(q);
            while (list.next()) {
                Date dateAuthorization = list.getDate("dateOfAuthorization");
                Time timeAuthorization = list.getTime("dateOfAuthorization");
                String time2 = timeAuthorization.toString();
                String time = dateAuthorization.toString();
                finalTime = time.concat(time2);

                for (int i = 0; i < 1; i++) {
                    Orders orders = new Orders();
                    orders.orderNumber = list.getInt("orderNumber");
                    orders.clientDetails = list.getString("clientDetails");
                    orders.zipCode = list.getInt("zipCode");
                    orders.accountName = list.getString("accountName");
                    orders.dateOfAuthorization = finalTime;
                    orders.billingCity = list.getString("billingCity");
                    orders.articles = list.getString("listWithArticles");
                    orders.price = list.getString("priceOfItem");
                    orders.businessDiscount = list.getInt("businessDiscount");
                    orders.totalAmount = list.getInt("totalPrice");
                    orders.amountAfterDiscount = list.getInt("priceAfterDiscount");
                    searchByIDOrders.add(orders);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }
        System.out.println(searchByIDOrders.toString());
        searchByIDOrders.clear();
    }
    public static void searchOrdersTableByName(String name) throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            String finalTime;
            String q = "select * from orders where clientDetails=" + "'" + name + "'";
            nStat = con.createStatement();
            ResultSet list = nStat.executeQuery(q);
            while (list.next()) {
                Date dateAuthorization = list.getDate("dateOfAuthorization");
                Time timeAuthorization = list.getTime("dateOfAuthorization");
                String time2 = timeAuthorization.toString();
                String time = dateAuthorization.toString();
                finalTime = time.concat(time2);

                for (int i = 0; i < 1; i++) {
                    Orders orders = new Orders();
                    orders.orderNumber = list.getInt("orderNumber");
                    orders.clientDetails = list.getString("clientDetails");
                    orders.zipCode = list.getInt("zipCode");
                    orders.accountName = list.getString("accountName");
                    orders.dateOfAuthorization = finalTime;
                    orders.billingCity = list.getString("billingCity");
                    orders.articles = list.getString("listWithArticles");
                    orders.price = list.getString("priceOfItem");
                    orders.businessDiscount = list.getInt("businessDiscount");
                    orders.totalAmount = list.getInt("totalPrice");
                    orders.amountAfterDiscount = list.getInt("priceAfterDiscount");
                    searchByIDOrders.add(orders);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }
        System.out.println(searchByIDOrders.toString());
        searchByIDOrders.clear();
    }

    public static void searchOrdersTableByIdRange(int a, int b) throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");

            String finalTime;
            String q = "select * from orders where orderNumber between " + a + " and " + b;
            nStat = con.createStatement();
            ResultSet list = nStat.executeQuery(q);
            while (list.next()) {
                Date dateAuthorization = list.getDate("dateOfAuthorization");
                Time timeAuthorization = list.getTime("dateOfAuthorization");
                String time2 = timeAuthorization.toString();
                String time = dateAuthorization.toString();
                finalTime = time.concat(time2);

                for (int i = 0; i < 1; i++) {
                    Orders orders = new Orders();
                    orders.orderNumber = list.getInt("orderNumber");
                    orders.clientDetails = list.getString("clientDetails");
                    orders.zipCode = list.getInt("zipCode");
                    orders.accountName = list.getString("accountName");
                    orders.dateOfAuthorization = finalTime;
                    orders.billingCity = list.getString("billingCity");
                    orders.articles = list.getString("listWithArticles");
                    orders.price = list.getString("priceOfItem");
                    orders.businessDiscount = list.getInt("businessDiscount");
                    orders.totalAmount = list.getInt("totalPrice");
                    orders.amountAfterDiscount = list.getInt("priceAfterDiscount");
                    searchByIDOrders.add(orders);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }
        System.out.println(searchByIDOrders.toString());
        searchByIDOrders.clear();
    }

    public static void searchOrdersTableByTimeRange(String a, String b) throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");

            String finalTime;
            String q = "select * from orders where dateOfAuthorization between " + "'" + a + "'" + " and " + "'" + b + "'";
            nStat = con.createStatement();
            ResultSet list = nStat.executeQuery(q);
            while (list.next()) {
                Date dateAuthorization = list.getDate("dateOfAuthorization");
                Time timeAuthorization = list.getTime("dateOfAuthorization");
                String time2 = timeAuthorization.toString();
                String time = dateAuthorization.toString();
                finalTime = time.concat(time2);

                for (int i = 0; i < 1; i++) {
                    Orders orders = new Orders();
                    orders.orderNumber = list.getInt("orderNumber");
                    orders.clientDetails = list.getString("clientDetails");
                    orders.zipCode = list.getInt("zipCode");
                    orders.accountName = list.getString("accountName");
                    orders.dateOfAuthorization = finalTime;
                    orders.billingCity = list.getString("billingCity");
                    orders.articles = list.getString("listWithArticles");
                    orders.price = list.getString("priceOfItem");
                    orders.businessDiscount = list.getInt("businessDiscount");
                    orders.totalAmount = list.getInt("totalPrice");
                    orders.amountAfterDiscount = list.getInt("priceAfterDiscount");
                    searchByIDOrders.add(orders);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }
        System.out.println(searchByIDOrders.toString());
        searchByIDOrders.clear();
    }

    public static void updateAccountName(String current, String update) throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            for (Orders i : listWithOrders) {
                if (i.accountName.equals(current)) {
                    i.setAccountName(update);
                }
            }
            String q = "update orders set accountName= " + "'" + update + "'" + " where accountName= " + "'" + current + "'";
            nStat = con.createStatement();
            nStat.execute(q);

        } catch (SQLException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }

    }
    public static void deleteOrdersByNumber(int a) throws SQLException {
        try { int b = 0;
        for (Orders j : listWithOrders) {
            if (j.orderNumber == a) {
                b = listWithOrders.indexOf(j);
            }
        }
        listWithOrders.remove(b);
        System.out.println(" *Order number " + a + " is deleted*");

            String del = "delete from orders where orderNumber =" + a;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            nStat = con.createStatement();
            nStat.execute(del);
            System.out.println(" *Table orders number " + a + " is deleted*");

        } catch (SQLException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }

    }

    public static void clearDatabaseTableOrders() throws SQLException {
        try {
            String del = "delete from orders ";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            nStat = con.createStatement();
            nStat.execute(del);
            System.out.println(" *Table orders is cleared*");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
        }
    }

    public static void deleteTableOrders() throws SQLException {
        try {
            String del = "drop table orders ";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            nStat = con.createStatement();
            nStat.execute(del);
            System.out.println(" *Table orders is deleted*");

        } catch (SQLException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            nStat.close();
            con.close();
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

    public static void listChecker(int orderN) throws UnCheckedException {
        orderNCheck(orderN);
        for (Orders i : listWithOrders) {
            if (i.orderNumber == orderN) {
                System.out.println("*Order is found*" + "\n" + i);
            }
        }

    }

    public static void listContainOrderNumber(int orderNum) throws UnCheckedException {
        try {
            orderNumCheck(orderNum);
            boolean a = false;
            for (Orders i : listWithOrders) {
                if (i.orderNumber == orderNum) {
                    a = true;
                    break;
                }
                System.out.println("Order is found, printing order: ");
            }
            System.out.println("\n" + a);
        } catch (UnCheckedException e1) {
            e1.printStackTrace();
        }
    }


    private static void orderNCheck(int orderN) throws UnCheckedException {
        if (listWithOrders == null) {
            throw new UnCheckedException("*The list is empty*");
        }
        if (orderN <= 0) {
            throw new UnCheckedException("The list contains Orders with positive numbers. Input " + orderN);
        }
        if (orderN > listWithOrders.size()) {
            long b = listWithOrders.size();
            throw new UnCheckedException("The input is grater than List size." +
                    "The list size is: " + b);
        }
    }


    private static void orderNumCheck(int orderNum) throws UnCheckedException {
        if (listWithOrders == null) {
            throw new UnCheckedException("*The list is empty*");
        }
        if (orderNum <= 0) {
            throw new UnCheckedException("The list contains Orders with positive numbers. Input: " + orderNum);
        }
        if (orderNum > listWithOrders.size()) {
            long b = listWithOrders.size();
            throw new UnCheckedException("The input is grater than List size," +
                    "the list size is: " + b);
        }
    }

    public static void listToFile() throws IOException, UnCheckedException {
        ObjectOutputStream newListWithOrders = null;
        try {
            newListWithOrders = new ObjectOutputStream(new FileOutputStream("Orders List"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        newListWithOrders.writeObject(listWithOrders);
        if (listWithOrders == null) {
            throw new UnCheckedException("*The list is empty*");

        }
        if (listWithOrders.size() == 0) {
            throw new UnCheckedException("*the list does not contain any data*");
        } else {
            ObjectInputStream loadingFile = new ObjectInputStream(new FileInputStream("Orders list"));
            List<Orders> newListFromOldList;
            try {
                newListFromOldList = (List<Orders>) loadingFile.readObject();
                System.out.println("\n*New list from old list, read only*\n" + newListFromOldList);
            } catch (FileNotFoundException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    void connector() {
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project6?serverTimezone=Europe/Sofia", "root", "root");
            System.out.println("Connection successful");
            String prep = "INSERT INTO Orders (accountName, clientDetails, billingCity, zipCode, listWithArticles, priceOfItem, businessDiscount,priceAfterDiscount," +
                    "totalPrice ) values (?, ?, ?, ?, ?, ?, ?,?,?)";
            String creat = "create table if not exists Orders\n" +
                    "(\n" +
                    "\torderNumber INT unsigned not null auto_increment,\n" +
                    "\taccountName varchar(50) not null default '',\n" +
                    "\tclientDetails varchar(100) not null default '',\n" +
                    "\tbillingCity varchar(50) not null default '',\n" +
                    "\tzipCode int unsigned not null default 0,\n" +
                    "\tlistWithArticles varchar(500) not null default '',\n" +
                    "\tpriceOfItem varchar(50)  not null default '',\n" +
                    "\tbusinessDiscount int unsigned not null default 0,\n" +
                    "\tdateOfAuthorization datetime not null default (now() + interval 1 day),\n" +
                    "\ttotalPrice int not null default 0,\n" +
                    "\tpriceAfterDiscount int not null default 0,\n" +
                    "\tprimary key (orderNumber)\n" +
                    ");";
            Statement createDB = con.createStatement();
            createDB.execute(creat);
            PreparedStatement one = con.prepareStatement(prep);
            one.setString(1, accountName);
            one.setString(2, clientDetails);
            one.setString(3, billingCity);
            one.setInt(4, zipCode);
            one.setString(5, Arrays.toString(getItems()));
            one.setString(6, Arrays.toString(getOrderPrice()));
            one.setInt(7, (int) getBusinessDiscount());//change to decimal
            one.setInt(8, (int) amountAfterDiscount);
            one.setInt(9, (int) totalAmount);
            one.execute();
            con.close();
            System.out.println("database");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteList() {
        listWithOrders = null;
        System.out.println(" *The list is clear*");
    }


}




