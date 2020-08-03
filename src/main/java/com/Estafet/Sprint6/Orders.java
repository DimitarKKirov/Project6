package com.Estafet.Sprint6;

import com.Estafet.CustomExceptions.UnCheckedException;
import com.Estafet.Interfaces.InvoiceCalculations;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Orders extends Random implements InvoiceCalculations, Serializable {
    private static final String orderName = "*Shop Order*";// the variable is not inherited in extended classes and cannot be changed it can be only read
    private int orderNumber;
    private String clientDetails;
    private String[] listWithArticles = {"Laptop", "TV", "PC", "Monitor", "Security Cameras", "Toy Laptop", "Wall painting", "Desk", "Gaming chair", "Headset"};
    private long totalAmount;
    private String accountName;
    private String dateOfActivation;
    private String billingCity;
    private int zipCode;
    private boolean paymentMethod;
    private String orderAuthorizedBy;
    private String dateOfAuthorization;
    private long[] itemPrice = {12, 34, 56, 7, 88, 123, 345, 809, 900, 1200};
    private int vaTInvoice;
    private long amountAfterVat;
    private long amountAfterDiscount;
    private long businessDiscount;
    private long[] orderPrice;
    private String[] items;
    static final String[] namesUsers = {"Dkk", "Delqn Delev", "Anton Rusanov", "Georgi Vlaykov", "Dimitar Kirilov Kirov", "Alistair Park", "Paulo Goncalves", "Dimo Kamenov", "Ludmila Nenkova", "Evgeni Popov"};
    private static List<Orders> listWithOrders;
    private static boolean invoiceOnOff;


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
        return "{" + "\n" + orderName + " " +
                " \n Order Number: " + orderNumber + "\n Client details: " + clientDetails + "\n City " + billingCity + "\n Account: " + accountName +
                "\n Order date: " + dateOfActivation + "\n List with items " + Arrays.toString(items) + "\n Discount " + businessDiscount +
                "\n zipCode:" + zipCode + "\n Total price " + totalAmount + "\n Price after discount " + amountAfterDiscount +
                '}';
    }

    public static void addOrderToList(Orders a) {
        listWithOrders.add(a);
    }

    public static void orderList() throws IOException {
        int a = 1;
        listWithOrders = new ArrayList<>(1000);
        String dateOA = "Current Date";
        String dataOAUT = "Next Day";
        for (int i = 0; i < namesUsers.length; i++) {
            Orders order = new Orders();
            order.orderNumber = a++;
            order.clientDetails = namesUsers[i];
            order.zipCode = generateZip();
            order.accountName = accountName();
            order.dateOfActivation = dateOA;
            order.dateOfAuthorization = dataOAUT;
            order.billingCity = randomCity();
            order.orderAuthorizedBy = namesUsers[i];
            order.businessDiscount = bisDis();
            order.invoiceIncluded();
            if (invoiceOnOff){

            }
            order.articlesList();
            order.priceList();
            order.priceCalc();
            order.discountCalc();

            listWithOrders.add(order);
        }
    }

    public static void orderListShow() throws UnCheckedException {
        if (listWithOrders == null) {
            throw new UnCheckedException("*The list is empty*");
        } else {
            System.out.println(listWithOrders);
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
        a = accounts[acc.nextInt(10)];
        return a;
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

    private void invoiceIncluded() {
        invoiceOnOff = false;
        Random randomNumber = new Random(100);
        int number = randomNumber.nextInt(50);
        invoiceOnOff = number / 2 == 0;
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

    public static void deleteList() {
        listWithOrders.clear();
        System.out.println(" *The list is clear*");
    }
}




