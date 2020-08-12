package com.Estafet.Sprint6;

import com.Estafet.CustomExceptions.UnCheckedException;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;


public class Main implements Serializable {

    public static void main(String[] args) throws IOException, SQLException, UnCheckedException {

//    Invoice.invoiceList();
    Invoice one=new Invoice();
    one.invoiceDbToList();
    one.readDBList();


//        Invoice invoice = new Invoice("DKKK", 14790, "Account Number 007", "Oceania", 5);
//        invoice.articlesList();
//        invoice.priceList();
//        invoice.priceCalc();
//        invoice.discountCalc();
//        invoice.vatArticles();
//        Invoice.addInvoiceToList(invoice);
//        one.readDBList();
            Invoice.listChecker(22);
    }
}





