package com.Estafet.Sprint6;

import com.Estafet.CustomExceptions.UnCheckedException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Invoice extends Orders {

    private static final String invoiceName = "*Shop Invoice*";// the variable is not inherited in extended classes and cannot be changed it can be only read
    private String clientDetailsInvoice;
    private String[] listWithArticlesInvoice = {"Laptop", "TV", "PC", "Monitor", "Security Cameras", "Toy Laptop", "Wall painting", "Desk", "Gaming chair", "Headset"};
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
    private static List<Invoice> listWhitInvoices;
    private int zipCode;
    private String accountName;
    private String dateOfAuthorization;
    private String billingCity;
    private String invoiceVatCalculatedBy;

    public Invoice() {

    }

    public Invoice(String clientDetailsInvoice, int invoiceNumber, String bankAccountIndexInvoice, String dateOfReleaseInvoice, long businessDiscountInvoice, String invoiceVatCalculatedBy) {
        this.clientDetailsInvoice = clientDetailsInvoice;
        this.invoiceNumber = invoiceNumber;
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

    @Override
    public int getZipCode() {
        return zipCode;
    }

    @Override
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String getBillingCity() {
        return billingCity;
    }

    @Override
    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
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
                "\n List With Articles: " + Arrays.toString(listWithArticlesInvoice) + "\n Date of Release: " + dateOfReleaseInvoice +
                "\n Discount:" + businessDiscountInvoice + "%" + "\n Total amount: " + totalAmount + "\n VAT responsibility: " + invoiceVatCalculatedBy +
                "\n Amount after Discount and VAT: " + amountAfterVat);
        return a.toString();
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
        int a = 1;
        listWhitInvoices = new ArrayList<>(1000);
        String dateOA = "Current Date";
        String dataOAUT = "Next Day";
        for (int i = 0; i < namesUsers.length; i++) {
            Invoice invoice = new Invoice();
            invoice.invoiceNumber = a++;
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

            listWhitInvoices.add(invoice);
        }
    }

    public static void addInvoiceToList(Invoice a) {
        listWhitInvoices.add(a);
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

    public static void listChecker(int invoiceN) throws UnCheckedException {
        invoiceNCheck(invoiceN);
        for (Invoice i : listWhitInvoices) {
            if (i.invoiceNumber == invoiceN) {
                System.out.println("*Order is found*" + "\n" + i);
            }
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

}


