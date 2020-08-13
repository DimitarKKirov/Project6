package com.Estafet.Sprint6;

import com.Estafet.CustomExceptions.UnCheckedException;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;


public class Main implements Serializable {

    public static void main(String[] args) throws IOException, SQLException, UnCheckedException {

//        Invoice.invoiceList();

        Invoice.invoiceDbToList();
        Invoice.readDBList();


        Invoice invoice = new Invoice("DKKK", 14790, "Account Number 007", "Oceania", 5);
        invoice.articlesList();
        invoice.priceList();
        invoice.priceCalc();
        invoice.discountCalc();
        invoice.vatArticles();
        Invoice.addInvoiceToList(invoice);
        Invoice.readDBList();
        Invoice.listChecker(2);
        Invoice.deleteInvoiceByNumber(1);
        Invoice.readDBList();
        Invoice.searchInvoicesTableByID(9);
        Invoice.searchInvoiceTableByName("DKKK");
        Invoice.searchInvoicesTableByIdRange(5,10);//smallest ID number firs
        Invoice.searchInvoicesTableByTimeRange("2020-08-14 11:43:23", "2020-08-14 11:46:20");
            Invoice.updateAccountName("Account Number 007","Dimitar K");
        Invoice.invoiceDBAndListQuantity();
        Invoice.searchUserInvoicesQuantity("DKKK");
//        Invoice.clearDatabaseTableInvoices();
//        Invoice.deleteList();
//        Invoice.deleteTableInvoices();


//      Orders.orderList();

        Orders.orderDbToList();

        Orders.printAllOrders();

        Orders.orderDBAndListQuantity();

        Orders test=new Orders("Dimitar Kirov Copy","Someone","The last City",340000,3);
        test.articlesList();
        test.priceList();
        test.priceCalc();
        test.discountCalc();

        Orders.addOrderToList(test);

        Orders.searchUserOrdersQuantity("DKK");

        Orders.searchOrdersTableByID(9);

        Orders.searchOrdersTableByName("DKK");

        Orders.searchOrdersTableByIdRange(3,3);

        Orders.searchOrdersTableByTimeRange("2020-08-14 17:28:29","2020-08-14 17:28:29");

        Orders.updateAccountName("Account 94","Dimitar Kirov");
        Orders.printAllOrders();

//        Orders.deleteOrdersByNumber(3);
//        Orders.orderDbToList();
//        Orders.printAllOrders();
//
//        Orders.clearDatabaseTableOrders();
//        Orders.orderDbToList();
//        Orders.printAllOrders();
//
//        Orders.deleteTableOrders();


    }
}





