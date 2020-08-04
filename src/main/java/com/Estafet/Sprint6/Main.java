package com.Estafet.Sprint6;

import com.Estafet.CustomExceptions.CustomExceptionIO;
import com.Estafet.CustomExceptions.UnCheckedException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class Main implements Serializable {


    public static void main(String[] args) throws IOException, UnCheckedException {

        try (FileInputStream file = new FileInputStream("C:\\Users\\lycifer\\IdeaProjects\\Training\\priceList2.txt")) {
            int a;
            while ((a = file.read()) != -1) {
                System.out.println("" + a);
            }
        } catch (FileNotFoundException e) {
            try {
                throw new CustomExceptionIO("\n*File is missing*\n" + e);
            } catch (CustomExceptionIO e34) {
                System.out.println(e34 + "\nPlease verify the file presence");
            }

            Orders order = new Orders(3, 1000, "D.Kirov", "Dimitar Kirov", "7/30/2020", "Sofia", "Order checked by:D.D", "7/30/2020", 10);
            order.priceList();
            order.priceCalc();
            order.discountCalc();
            order.vatArticles();
            System.out.println(order.toString());
            System.out.println(order.getAmountAfterVat());
            try {
                Orders.printAllOrders();//Prints all orders from the list with orders
            } catch (UnCheckedException e234) {
                System.out.println(e234);
            }
            Orders.orderList();//creates a list with random orders
            try {
                Orders.listContainOrderNumber(-2);//checks if order with input number is present in the order list (true/false)
            } catch (UnCheckedException e1) {
                System.out.print(e1);
                throw e1;
            }
            try {
                Orders.listContainOrderNumber(103);
            } catch (UnCheckedException q) {
                System.out.println("\n" + q);
            }
            try {
                Orders.listChecker(0);//prints the order with the input number if existing in the list
            } catch (UnCheckedException e245) {
                System.out.println(e245);
            }
            try {
                Orders.listChecker(1);
            } catch (UnCheckedException er) {
                System.out.println(er);
            } finally {
                Orders.deleteList();
            }
            try {
                Orders.listToFile();
            } catch (Throwable f1) {
                System.out.println("Throwable exception is cached " + f1);
            } finally {
                Orders.orderList();
            }
            Orders.listToFile();

            Invoice.invoiceList();
            Invoice.printAllInvoices();

            Invoice one = new Invoice("Dimitar Kirov", 11, "BG230967425", "7/7/2020", 2, "Dimitar Kirov");
            one.setBillingCity("Anemos");
            one.setZipCode(1287);
            one.articlesList();
            one.priceList();
            one.priceCalc();
            one.discountCalc();
            one.vatArticles();
            one.printInvoice();
//            Invoice.addInvoiceToList(one);
//            Invoice.printAllInvoices();


        }
        HashMap<String, Integer> countryNamesAndMobileCodes = new HashMap<>();
        countryNamesAndMobileCodes.put("Algeria", 213);
        countryNamesAndMobileCodes.put("Åland Islands", 358);
        countryNamesAndMobileCodes.put("Albania", 355);
        countryNamesAndMobileCodes.put("American Samoa", 1684);
        countryNamesAndMobileCodes.put("Andorra", 376);
        countryNamesAndMobileCodes.put("Angola", 244);
        countryNamesAndMobileCodes.put("Anguilla", 1264);
        countryNamesAndMobileCodes.put("Antigua and Barbuda", 1268);
        HashMap<Integer, String> lACZipCodesCity = new HashMap<>();

        lACZipCodesCity.put(90201, "Bell");
        lACZipCodesCity.put(90209, "Beverly Hills");
        lACZipCodesCity.put(90210, "Beverly Hills");
        lACZipCodesCity.put(90211, "Beverly Hills");
        lACZipCodesCity.put(90212, "Beverly Hills");
        lACZipCodesCity.put(90213, "Beverly Hills");
        lACZipCodesCity.put(90220, "Rancho Dominguez");
        System.out.println("\n" + countryNamesAndMobileCodes.toString() + "\n\n" + lACZipCodesCity.toString());

        System.out.println("\n" + lACZipCodesCity.get(90211));
        System.out.println("\n" + countryNamesAndMobileCodes.keySet());
        countryNamesAndMobileCodes.remove("Angola");
        lACZipCodesCity.remove(90210);
        System.out.println("\n" + countryNamesAndMobileCodes.toString() + "\n\n" + lACZipCodesCity.toString());
        //testing setttings
        Orders newOrder = new Orders();
        System.out.println(newOrder.toString());

        Orders theMoon = new Orders(4, 1000, "Delyan Delev", "Delyan@", "31/07/2020", "Sofia", "Estafet", "3/08/2020", 15);
        theMoon.articlesList();
        theMoon.priceList();
        theMoon.priceCalc();
        theMoon.discountCalc();
        theMoon.vatArticles();
        System.out.println(theMoon.toString());
        Orders.orderList();
        Orders.printAllOrders();
        Invoice.printAllInvoices();
        theMoon.printOrder();


    }
}





