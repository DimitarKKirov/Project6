package com.Estafet.Interfaces;

public interface TradeInvoiceCalculation extends InvoiceCalculations {

    @Override
    void discountCalc();

    @Override
    void vatArticles();

}
