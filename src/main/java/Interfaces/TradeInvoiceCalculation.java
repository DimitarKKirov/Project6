package com.estafet.learning.Interfaces;

public interface TradeInvoiceCalculation extends InvoiceCalculations {

    @Override
    void discountCalc();

    @Override
    void vatArticles();

}
