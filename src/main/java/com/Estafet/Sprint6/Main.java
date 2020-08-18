package com.Estafet.Sprint6;

import com.Estafet.CustomExceptions.UnCheckedException;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;


public class Main implements Serializable {

    public static void main(String[] args) throws IOException, SQLException, UnCheckedException {

        //Creating database table Invoices and uploading the relevant invoice data
        System.out.println("\n*Creating database table Invoices/Orders and uploading the relevant invoice data*");
        Invoice.invoiceList();

        //Creating ArrayList with the invoices from the Invoices table
        System.out.println("\n*Creating ArrayList with the invoices from the Invoices table*");
        Invoice.invoiceDbToList();

        //Printing the content and size of the previously created ArrayList
        System.out.println("\n*Printing the content and size of the previously created ArrayList*");
        Invoice.readDBList();

        //The Number of invoice corresponding to the entered integer number is searched for in to the database table, then is stored to new ArrayList and printed in the console
        System.out.println("\n*The Number of invoice corresponding to the entered integer number is searched for in to the database table," +
                " then is stored to new ArrayList and printed in the console*");
        Invoice.searchInvoicesTableByID(9);

        //Searching the database table for corresponding invoice belonging to user name, inserting the invoice in newly created ArrayList and printing it in console
        System.out.println("\n*Searching the database table for corresponding orders belonging to user name," +
                " inserting the orders in newly created ArrayList and printing it in console*");
        Orders.searchOrdersTableByName("Dimitar Kirilov Kirov");

        //Searching the database table for invoices between set ID numbers //smallest ID number firs
        System.out.println("\n*Searching the database table for invoices between set ID numbers*");
        Invoice.searchInvoicesTableByIdRange(5, 8);


        //Searching for Invoices in the database table by entering data and time range// if entered range is the same all the invoices that are created for that day will be printed
        System.out.println("\n*Searching for Orders in the database table by entering data and time range" +
                "// if entered range is the same all the Orders that are created for that specific day and hour will be printed*");
        Orders.searchOrdersTableByTimeRange("2020-08-18 11:51:44", "2020-08-18 11:51:44");

        //Showing how many invoices a user has, searching by user name
        System.out.println("\n*Showing how many Orders a user has, searching by user name*");
        Orders.searchUserOrdersQuantity("Dimitar Kirilov Kirov");



//MODIFYING THE DATABASE TABLE INVOICES

        Invoice invoice = new Invoice("DKKK", 14790, "Account Number 007", "Oceania", 5);
        invoice.articlesList();
        invoice.priceList();
        invoice.priceCalc();
        invoice.discountCalc();
        invoice.vatArticles();

        //Adding separately created Invoice inside the ArrayList and database table Invoices
        System.out.println("\n*Adding separately created Invoice inside database table Invoices*");
        Invoice.addInvoiceToList(invoice);

        //Counting the invoices in both ArrayList and database table and printing the result
        System.out.println("\n*Counting the invoices in both ArrayList and database table and printing the result*");
        Invoice.invoiceDBAndListQuantity();

        //Changing the account name of user by searching the old name and replacing it with the new one, this is done for all invoices
//        System.out.println("\n*Changing the account name of user by searching the old name and replacing it with the new one, this is done for all invoices*");
//        Invoice.updateAccountName("Account Number 007", "Dimitar K");

        //The Number of invoice corresponding to the entered integer number is deleted in the ArrayList and Invoices database table
//        System.out.println("\n*The Number of invoice corresponding to the entered integer number is deleted in the ArrayList and Invoices database table*");
//        Invoice.deleteInvoiceByNumber(1);

//        //Deleting the content of database table invoices
//        System.out.println("\n*Deleting the content of database table invoices*");
//        Invoice.clearDatabaseTableInvoices();
//
//        //Deleting ArrayList containing Invoice objects
//        System.out.println("\n*Deleting  table invoices*");
//        Invoice.deleteTableInvoices();




    }
}





